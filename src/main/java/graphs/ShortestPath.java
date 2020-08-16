package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class ShortestPath {
    // https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
    public static void main(String args[]) {
        int v = 8;
        List<List<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;
        printShortestDistance(adj, source, dest, v);
    }

    private static void addEdge(List<List<Integer>> adj, int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    private static void printShortestDistance(List<List<Integer>> adj, int source, int destination, int v) {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from source
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, source, destination, v, pred, dist) == false) {
            System.out.println("Given source and destination" + "are not connected");
            return;
        }

        LinkedList<Integer> path = new LinkedList<>();
        int crawl = destination;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        System.out.println("Shortest path length is: " + dist[destination]);
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(List<List<Integer>> adj, int source, int destination, int v, int pred[], int dist[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        for (int vertex = 0; vertex < v; vertex++) {
            visited[vertex] = false;
            dist[vertex] = Integer.MAX_VALUE;
            pred[vertex] = -1;
        }

        visited[source] = true;
        dist[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int qVertex = queue.remove();
            for (int vertex = 0; vertex < adj.get(qVertex).size(); vertex++) {
                if (!visited[adj.get(qVertex).get(vertex)]) {
                    visited[adj.get(qVertex).get(vertex)] = true;
                    dist[adj.get(qVertex).get(vertex)] = dist[qVertex] + 1;
                    pred[adj.get(qVertex).get(vertex)] = qVertex;
                    queue.add(adj.get(qVertex).get(vertex));
                    if (adj.get(qVertex).get(vertex) == destination) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
