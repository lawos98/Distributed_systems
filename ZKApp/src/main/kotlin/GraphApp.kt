import org.graphstream.graph.Graph
import org.graphstream.graph.Node
import org.graphstream.graph.Path
import org.graphstream.graph.implementations.SingleGraph
import org.graphstream.ui.view.Viewer
import java.io.File
import java.nio.file.Paths
import javax.swing.SwingUtilities

class GraphApp {
    private val graph: Graph = SingleGraph("ZNode Graph")
    private val rootName = "root"
    private var viewer:Viewer? = null

    init {
        System.setProperty("org.graphstream.ui", "swing")
        graph.addNode(rootName)
        println(Paths.get("").toAbsolutePath().toString())
        val css = File("ZKApp/src/main/resources/stylesheet.css").readText()
        graph.setAttribute("ui.stylesheet", css)
        graph.getNode(rootName).setAttribute("ui.label", "$rootName (0)")
        graph.display()
    }

    fun addNode(parentName: String,nodeName: String) {
        SwingUtilities.invokeLater {
            graph.addNode(nodeName)
            graph.addEdge("$parentName-$nodeName", parentName, nodeName,true)

            val count = updateLabels(rootName)
            graph.getNode(rootName).setAttribute("ui.label", "$rootName ($count)")
        }
    }

    fun removeNode(nodeName: String) {
        SwingUtilities.invokeLater {
            graph.removeNode(nodeName)

            val count = updateLabels(rootName)
            graph.getNode(rootName).setAttribute("ui.label", "$rootName ($count)")
        }
    }

    private fun updateLabels(name: String): Int {
        fun rec(node: Node):Int{
            var count = 0
            node.leavingEdges().forEach { edge ->
                count += 1 + rec(edge.targetNode)
            }
            return count
        }
        return rec(graph.getNode(name))
    }

    fun show() {
        viewer = graph.display()
    }

    fun close() {
        viewer?.close()
    }
}

fun main() {
    val app = GraphApp()
    println("Enter commands: ")
    while (true) {
        val command = readLine() ?: break
        val parts = command.split(" ")

        when (parts[0].toLowerCase()) {
            "add" -> {
                if (parts.size == 3) {
                    app.addNode(parts[1], parts[2])
                    println("Added node ${parts[2]} to ${parts[1]}")
                } else {
                    println("Invalid command. Usage: add parent node")
                }
            }
            "remove" -> {
                if (parts.size == 2) {
                    app.removeNode(parts[1])
                    println("Removed node ${parts[1]}")
                } else {
                    println("Invalid command. Usage: remove node")
                }
            }
            "exit" -> {
                println("Exiting...")
                System.exit(0)
            }
            else -> {
                println("Invalid command. Use 'add' or 'remove'")
            }
        }
    }
}