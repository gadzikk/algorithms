package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gadzik on 15.08.20.
 */
public class FindPathTwoCells {
    // https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/

    int V;
    List<List<Integer>> adj;

    FindPathTwoCells(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int source, int destination) {
        adj.get(source).add(destination);
    }

    boolean BFS(int source, int destination) {
        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);
        List<Integer> edges;
        while (!queue.isEmpty()) {
            source = queue.poll();
            edges = adj.get(source);
            for (int curr : edges) {
                if (curr == destination) {
                    return true;
                }

                if (!visited[curr]) {
                    visited[curr] = true;
                    queue.offer(curr);
                }
            }
        }

        // If BFS is complete without visiting destination
        return false;
    }

    static boolean isSafe(int row, int col, int[][] M) {
        int N = M.length;
        if ((row < 0 || row >= N) || (col < 0 || col >= N) || M[row][col] == 0) {
            return false;
        }
        return true;
    }

    static boolean findPath(int[][] M) {
        int source = -1, destination = -1;
        int N = M.length;
        int V = N * N + 2;
        FindPathTwoCells g = new FindPathTwoCells(V);

        int k = 1; // Number of current vertex
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (M[row][col] != 0) {
                    if (isSafe(row, col + 1, M)) {
                        g.addEdge(k, k + 1);
                    }

                    if (isSafe(row, col - 1, M)) {
                        g.addEdge(k, k - 1);
                    }

                    if (row < N - 1 && isSafe(row + 1, col, M)) {
                        g.addEdge(k, k + N);
                    }

                    if (row > 0 && isSafe(row - 1, col, M)) {
                        g.addEdge(k, k - N);
                    }
                }

                // source index
                if (M[row][col] == 1) {
                    source = k;
                }

                // destination index
                if (M[row][col] == 2) {
                    destination = k;
                }
                k++;
            }
        }

        // find path Using BFS
        return g.BFS(source, destination);
    }

    // Driver program to check above function
    public static void main(
            String[] args) throws Exception {
        int[][] M = {{0, 3, 0, 1},
                {3, 0, 3, 3},
                {2, 3, 3, 3},
                {0, 3, 3, 3}};

        System.out.println(
                ((findPath(M)) ? "Yes" : "No"));
    }
}
