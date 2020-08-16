package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 16.08.20.
 */
public class NumberShortestPathsDirected {
    // https://www.geeksforgeeks.org/number-shortest-paths-unweighted-directed-graph/
    static void BFS(Vector<Integer>[] adj, int source, int distance[], int paths[], int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        distance[source] = 0;
        paths[source] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int current = q.peek();
            q.poll();

            for (int vertex : adj[current]) {
                if (!visited[vertex]) {
                    q.add(vertex);
                    visited[vertex] = true;
                }

                if (distance[current] + 1 < distance[vertex]) {
                    distance[vertex] = distance[current] + 1;
                    paths[vertex] = paths[current];
                } else if (distance[vertex] == distance[current] + 1) {
                    paths[vertex] += paths[current];
                }
            }
        }
    }

    static void findShortestPaths(Vector<Integer> adj[], int vertex, int numberOfVertices) {
        int[] dist = new int[numberOfVertices];
        int[] paths = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < numberOfVertices; i++) {
            paths[i] = 0;
        }

        BFS(adj, vertex, dist, paths, numberOfVertices);

        System.out.print("Numbers of shortest Paths are: ");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print(paths[i] + " ");
        }
    }

    static void addEdge(Vector<Integer> adj[], int source, int destination) {
        adj[source].add(destination);
    }

    public static void main(String[] args) {
        int n = 7;
        Vector<Integer>[] adj = new Vector[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vector<>();
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);
        findShortestPaths(adj, 0, 7);
    }
}
