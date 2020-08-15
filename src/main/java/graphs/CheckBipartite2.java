package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 14.08.20.
 */
public class CheckBipartite2 {
    // https://algorithms.tutorialhorizon.com/check-if-graph-is-bipartite-adjacency-list-using-breadth-first-searchbfs/
    enum Color {
        WHITE, RED, GREEN
    }

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
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

            Queue<Integer> queue = new LinkedList<>();
            for (int source = 0; source < vertices; source++) {
                if (colors[source] == Color.WHITE) {
                    colors[source] = Color.RED;
                    queue.add(source);
                    while (!queue.isEmpty()) {
                        int vertex = queue.remove();
                        for (int i = 0; i < adjList[vertex].size(); i++) {
                            int dest = adjList[vertex].get(i);
                            if (colors[dest] == Color.WHITE) {
                                //color is with the alternate color of vertex vertex
                                if (colors[vertex] == Color.RED) {
                                    colors[dest] = Color.GREEN;
                                } else if (colors[vertex] == Color.GREEN) {
                                    colors[dest] = Color.RED;
                                }
                                queue.add(dest);
                            } else if (colors[vertex] == colors[dest]) {
                                return false;
                            }
                        }
                    }
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
