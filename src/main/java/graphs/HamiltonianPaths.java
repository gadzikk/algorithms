package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gadzik on 15.08.20.
 */
public class HamiltonianPaths {
    // https://www.techiedelight.com/print-all-hamiltonian-path-present-in-a-graph/
    static class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    static class Graph {
        List<List<Integer>> adjList = null;

        Graph(List<Edge> edges, int N) {
            adjList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            for (Edge edge : edges) {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }

        public static void printAllHamiltonianPaths(Graph g, int v, boolean[] visited, List<Integer> path, int N) {
            // if all the vertices are visited, then hamiltonian path exists
            if (path.size() == N) {
                System.out.println(path);
                return;
            }

            for (int w : g.adjList.get(v)) {
                // process only unvisited vertices as hamiltonian path visits each vertex exactly once
                if (!visited[w]) {
                    visited[w] = true;
                    path.add(w);

                    printAllHamiltonianPaths(g, w, visited, path, N);
                    visited[w] = false;
                    path.remove(path.size() - 1);
                }
            }
        }

        public static void main(String[] args) {
            List<Edge> edges = Arrays.asList(
                    new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                    new Edge(1, 2), new Edge(1, 3), new Edge(2, 3)
            );

            final int V = 4;
            Graph g = new Graph(edges, V);
            int start = 0;
            List<Integer> path = new ArrayList<>();
            path.add(start);

            boolean[] visited = new boolean[V];
            visited[start] = true;
            printAllHamiltonianPaths(g, start, visited, path, V);
        }
    }
