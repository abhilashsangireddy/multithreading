import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A custom graph class extending the graph functionality provided by {@link Graph}
 * An extra set of vertices is being maintained by this class to keep check of the
 * vertices that are already added to the graph.
 */
public class HierarchyGraph {

    private Set<String> vertices;
    private Graph<String, DefaultEdge> graph;

    private final ReentrantLock mutex = new ReentrantLock();

    public HierarchyGraph() {
        this.vertices = ConcurrentHashMap.newKeySet();
        this.graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    public Set<String> getVertices() {
        return vertices;
    }

    public Graph<String, DefaultEdge> getGraph() {
        return graph;
    }

    private boolean containsVertex(String vertex) {
        return vertices.contains(vertex);
    }

    public void checkAndAddVertex(String vertex) {
        try {
            mutex.lock();
            if (vertex != null && !containsVertex(vertex)) {
                vertices.add(vertex);
                graph.addVertex(vertex);
            }
        } finally {
            mutex.unlock();
        }
    }

    public void checkAndAddEdge(String sourceVertex, String targetVertex) {
        try {
            mutex.lock();
            checkAndAddVertex(sourceVertex);
            checkAndAddVertex(targetVertex);
            if (sourceVertex != null && targetVertex != null) {
                graph.addEdge(sourceVertex, targetVertex);
            }
        } finally {
            mutex.unlock();
        }
    }

    public boolean containsCycle() {
        CycleDetector<String, DefaultEdge> detector = new CycleDetector<>(graph);
        return detector.detectCycles();
    }

    /**
     * Returns a set of all vertices which participate in at least one cycle in this graph.
     */
    public Set<String> getCycles() {
        CycleDetector<String, DefaultEdge> detector = new CycleDetector<>(graph);
        return detector.findCycles();
    }

}
