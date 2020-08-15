package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 14.08.20.
 */
public class CheckBipartite3 {
    // https://algorithms.tutorialhorizon.com/check-if-graph-is-bipartite-adjacency-list-using-depth-first-searchdfs/
    enum Color {
        WHITE, RED, GREEN
    }

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int vertex = 0; vertex < vertices; vertex++) {
                adjList[vertex] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
        }

        public boolean isBipartite(Graph graph) {
            if (graph.vertices == 0) {
                return true;
            }

            Color colors[] = new Color[vertices];
            for (int i = 0; i < colors.length; i++) {
                colors[i] = Color.WHITE;
            }

            for (int i = 0; i < vertices; i++) {
                if (colors[i] == Color.WHITE) {
                    boolean result = isBipartiteUtil(i, colors);
                    if (!result) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isBipartiteUtil(int source, Color[] colors) {
            if (source == 0) {
                colors[source] = Color.RED;
            }

            for (int i = 0; i < adjList[source].size(); i++) {
                int vertex = adjList[source].get(i);
                if (colors[vertex] == Color.WHITE) {
                    if (colors[source] == Color.RED) {
                        colors[vertex] = Color.GREEN;
                    } else if (colors[source] == Color.GREEN) {
                        colors[vertex] = Color.RED;
                    }

                    return isBipartiteUtil(vertex, colors);

                } else if (colors[source] == colors[vertex]) {
                    return false;
                }
            }
            // if here means graph is successfully colored in 2 color, red and green graph is bipartite
            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        boolean result = graph.isBipartite(graph);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");

        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 1);

        result = graph1.isBipartite(graph1);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");
    }
}
