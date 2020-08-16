package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 17.08.20.
 */
public class MinSourceEndCut {
    // https://www.geeksforgeeks.org/minimum-cut-in-a-directed-graph/
    private static boolean bfs(int[][] residualGraph, int source, int end, int[] parent) {

        boolean[] visited = new boolean[residualGraph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        parent[source] = -1;

        // Standard BFS Loop
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < residualGraph.length; i++) {
                if (residualGraph[v][i] > 0 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    parent[i] = v;
                }
            }
        }

        // If we reached sink in BFS starting
        // from source, then return true, else false
        return (visited[end] == true);
    }

    // A DFS based function to find all reachable
    // vertices from source. The function marks visited[i]
    // as true if i is reachable from source. The initial
    // values in visited[] must be false. We can also
    // use BFS to find reachable vertices
    private static void dfs(int[][] residualGraph, int source,
                            boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < residualGraph.length; i++) {
            if (residualGraph[source][i] > 0 && !visited[i]) {
                dfs(residualGraph, i, visited);
            }
        }
    }

    private static void minCut(int[][] graph, int source, int end) {
        int u, v;

        // Create a residual graph and fill the residual
        // graph with given capacities in the original
        // graph as residual capacities in residual graph
        // residualGraph[i][j] indicates residual capacity of edge i-j
        int[][] residualGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }

        // This array is filled by BFS and to store path
        int[] parent = new int[graph.length];

        // Augment the flow while tere is path from source to sink
        while (bfs(residualGraph, source, end, parent)) {

            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int pathFlow = Integer.MAX_VALUE;
            for (v = end; v != source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = end; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] = residualGraph[u][v] - pathFlow;
                residualGraph[v][u] = residualGraph[v][u] + pathFlow;
            }
        }

        // Flow is maximum now, find vertices reachable from source
        boolean[] isVisited = new boolean[graph.length];
        dfs(residualGraph, source, isVisited);

        // Print all edges that are from a reachable vertex to
        // non-reachable vertex in the original graph
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) {
                    System.out.println(i + " - " + j);
                }
            }
        }
    }

    public static void main(String args[]) {
        int graph[][] = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        minCut(graph, 0, 5);
    }
}
