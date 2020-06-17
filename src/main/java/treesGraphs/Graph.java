package treesGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 17.06.20.
 */
public class Graph {
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
