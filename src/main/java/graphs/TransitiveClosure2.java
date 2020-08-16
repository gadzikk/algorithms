package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class TransitiveClosure2 {
    // https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
    private int vertices;
    private List<Integer>[] adjList;
    private int[][] transitiveClosures;

    public TransitiveClosure2(int vertices) {
        this.vertices = vertices;
        this.transitiveClosures = new int[this.vertices][this.vertices];
        initAdjList();
    }

    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public void transitiveClosure() {
        for (int i = 0; i < vertices; i++) {
            dfsUtil(i, i);
        }

        for (int vertex = 0; vertex < vertices; vertex++) {
            System.out.println(Arrays.toString(transitiveClosures[vertex]));
        }
    }

    private void dfsUtil(int source, int v) {
        transitiveClosures[source][v] = 1;
        for (int adj : adjList[v]) {
            if (transitiveClosures[source][adj] == 0) {
                dfsUtil(source, adj);
            }
        }
    }

    public static void main(String[] args) {
        TransitiveClosure2 g = new TransitiveClosure2(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " + "matrix is");
        g.transitiveClosure();

    }
}
