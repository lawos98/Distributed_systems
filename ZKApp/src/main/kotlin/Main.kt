import org.apache.zookeeper.AsyncCallback.StatCallback
import org.apache.zookeeper.KeeperException
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.ZooKeeper
import org.apache.zookeeper.data.Stat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import org.apache.log4j.Level
import org.apache.log4j.Logger
import java.util.*
class ChildrenWatcher(private val origin: String, private val zNode: String, private val zk: ZooKeeper, private val out: PrintWriter) : Watcher, StatCallback {

    private var children = mutableListOf<String>()

    private fun updateChildren(zk: ZooKeeper, origin: String, zNode: String, children: MutableList<String>, watcher: Watcher): MutableList<String> =
        zk.getChildren(zNode, watcher).also {
            (it - children).singleOrNull()?.let { newChild ->
                val newPath = "$zNode/$newChild"
                zk.exists(newPath, true, ChildrenWatcher(origin, newPath, zk, out), null)
                val parentNodeName = zNode.split("/").last()
                out.println("add $parentNodeName $newChild")
                out.flush()
            }
            (children - it).singleOrNull()?.let { removedChild ->
                out.println("remove $removedChild")
                out.flush()
            }
        }

    override fun process(event: WatchedEvent) {
        if (event.path == zNode) {
            zk.exists(zNode, true, this, null)
        }
    }

    override fun processResult(rc: Int, path: String, ctx: Any?, stat: Stat?) {
        when (KeeperException.Code.get(rc)) {
            KeeperException.Code.OK -> children = updateChildren(zk, origin, zNode, children, this)
            else -> zk.exists(zNode, true, this, null)
        }
    }
}

class ProcessWatcher(hostPort: String, private val zNode: String) : Watcher, StatCallback {

    private val zk = ZooKeeper(hostPort, 5000, this)
    private var process: Process? = null
    private var out: PrintWriter? = null
    private var childrenWatcher: ChildrenWatcher? = null

    private fun getDescendants(zNode: String): List<String> {
        val descendants = mutableListOf<String>()
        val queue = LinkedList<String>()

        queue.offer(zNode)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            descendants.add(node)

            val children = zk.getChildren(node, false)
            for (child in children) {
                val childPath = "$node/$child"
                queue.offer(childPath)
            }
        }

        return descendants.drop(1)
    }

    override fun process(event: WatchedEvent) {
        if (event.path == zNode) {
            zk.exists(zNode, true, this, null)
        }
    }

    override fun processResult(rc: Int, path: String, ctx: Any?, stat: Stat?) {
        when (KeeperException.Code.get(rc)) {
            KeeperException.Code.OK ->  {
                if(process == null) {
                    println("Starting GraphApp")
                    process = Runtime.getRuntime().exec("java -jar GraphGUI.jar")
                    out = PrintWriter(process!!.outputStream, true)
                    val reader = BufferedReader(InputStreamReader(process!!.inputStream))
                    Thread {
                        var line: String?
                        while (reader.readLine().also { line = it } != null) {
                            println(line)
                        }
                    }.start()

                    childrenWatcher = ChildrenWatcher(zNode, zNode, zk, out!!)
                    zk.exists(zNode, true, childrenWatcher, null)
                }
            }
            KeeperException.Code.NONODE -> {
                if(process != null) {
                    println("Stopping GraphApp")
                    process?.destroy()
                    try {
                        process!!.waitFor()
                        process = null
                        out = null
                        childrenWatcher = null
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
            KeeperException.Code.SESSIONEXPIRED, KeeperException.Code.NOAUTH -> {
                return
            }
            else -> {
                zk.exists(zNode, true, this, null)
            }
        }
    }

    init {
        zk.exists(zNode, true, this, null)
        zk.exists(zNode, true, ChildrenWatcher(zNode, zNode, zk, out ?: PrintWriter(System.out)), null)
        process?.inputStream?.bufferedReader()?.let { reader ->
            while (reader.ready()) { reader.readLine() }
        }

        zk.exists(zNode, false)?.let {
            val descendants = getDescendants(zNode)
            for (descendant in descendants) {
                val parts = descendant.split("/")
                val child = parts.last()
                val parentPath = parts.dropLast(1).joinToString("/")
                val parent = parentPath.split("/").last()
                out?.println("add $parent $child")
                out?.flush()
            }
        }
    }
}


fun main() {
    Logger.getRootLogger().level = Level.WARN
    ProcessWatcher("127.0.0.1:2181", "/z")
    while (true){
        Thread.sleep(100)
    }
}