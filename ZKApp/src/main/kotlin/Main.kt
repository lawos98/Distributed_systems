import kotlinx.coroutines.*
import org.apache.zookeeper.*
import org.apache.zookeeper.data.Stat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import org.apache.log4j.Level
import org.apache.log4j.Logger
import java.util.*

class DescendantWatcher(
    private val zNode: String,
    private val zooKeeper: ZooKeeper,
    private val output: PrintWriter
) : Watcher, AsyncCallback.StatCallback {

    private var descendants: MutableList<String> = mutableListOf()

    private fun updateDescendants(children: List<String>): MutableList<String> =
        zooKeeper.getChildren(zNode, this).also {
            (it - children).singleOrNull()?.let { newChild ->
                val newPath = "$zNode/$newChild"
                zooKeeper.exists(newPath, true, DescendantWatcher(newPath, zooKeeper, output), null)
                val parentNodeName = zNode.split("/").last()
                output.println("add $parentNodeName $newChild")
                output.flush()
            }
            (children - it).singleOrNull()?.let { removedChild ->
                output.println("remove $removedChild")
                output.flush()
            }
        }

    override fun processResult(rc: Int, path: String, ctx: Any?, stat: Stat?) {
        when (KeeperException.Code.get(rc)) {
            KeeperException.Code.OK -> descendants = updateDescendants(descendants)
            else -> zooKeeper.exists(zNode, true, this, null)
        }
    }

    override fun process(event: WatchedEvent) {
        if (event.path == zNode && event.type == Watcher.Event.EventType.NodeChildrenChanged) {
            zooKeeper.exists(zNode, true, this, null)
        }
    }
}

class ProcessWatcher(private val hostPort: String, private val zNode: String) : Watcher, AsyncCallback.StatCallback {

    private val zooKeeper = ZooKeeper(hostPort, 5000, this)
    private var process: Process? = null
    private var output: PrintWriter? = null
    private var descendantWatcher: DescendantWatcher? = null

    private fun getAllDescendants(zNode: String): Set<String> {
        val descendants = mutableSetOf<String>()
        val queue = ArrayDeque<String>()

        queue.addLast(zNode)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            descendants.add(node)

            val children = zooKeeper.getChildren(node, false)
            queue.addAll(children.map { child -> "$node/$child" })
        }

        return descendants - zNode
    }

    override fun processResult(resultCode: Int, path: String, context: Any?, stat: Stat?) {
        when (KeeperException.Code.get(resultCode)) {
            KeeperException.Code.OK -> {
                if (process == null) {
                    if (path == zNode) {
                        startGraphApp()
                    } else {
                        zooKeeper.exists(zNode, true, this, null)
                    }
                }
            }
            KeeperException.Code.NONODE -> {
                if (process != null) {
                    stopGraphApp()
                }
            }
            KeeperException.Code.SESSIONEXPIRED, KeeperException.Code.NOAUTH -> return
            else -> zooKeeper.exists(zNode, true, this, null)
        }
    }

    override fun process(event: WatchedEvent) {
        if (event.path == zNode && event.type == Watcher.Event.EventType.NodeCreated) {
            startGraphApp()
        } else if (event.path == zNode && event.type == Watcher.Event.EventType.NodeDeleted) {
            stopGraphApp()
        }
    }

    private fun startGraphApp() {
        println("Starting GraphApp")
        process = Runtime.getRuntime().exec("java -jar GraphGUI.jar")
        output = PrintWriter(process!!.outputStream, true)

        val reader = BufferedReader(InputStreamReader(process!!.inputStream))
        GlobalScope.launch(Dispatchers.IO) {
            while (isActive) {
                val line = reader.readLine() ?: break
                println(line)
            }
        }

        descendantWatcher = DescendantWatcher(zNode, zooKeeper, output!!)
        zooKeeper.exists(zNode, true, descendantWatcher, null)
    }

    private fun stopGraphApp() {
        println("Stopping GraphApp")
        process?.destroy()
        runBlocking {
            process?.waitFor()
        }
        process = null
        output = null
        descendantWatcher = null
    }
    init {
        zooKeeper.exists(zNode, true, this, null)
        zooKeeper.exists(zNode, true, DescendantWatcher(zNode, zooKeeper, output ?: PrintWriter(System.out)), null)
        process?.inputStream?.bufferedReader()?.let { reader ->
            while (reader.ready()) { reader.readLine() }
        }

        zooKeeper.exists(zNode, false)?.let {
            val descendants = getAllDescendants(zNode)
            for (descendant in descendants) {
                val parts = descendant.split("/")
                val child = parts.last()
                val parentPath = parts.dropLast(1).joinToString("/")
                val parent = parentPath.split("/").last()
                output?.println("add $parent $child")
                output?.flush()
            }
        }
    }
}

fun main() = runBlocking {
    Logger.getRootLogger().level = Level.WARN
    ProcessWatcher("127.0.0.1:2181", "/z")

    while (isActive) {
        delay(100)
    }
}