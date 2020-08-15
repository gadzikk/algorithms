package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 14.08.20.
 */
public class ReverseDirected {
    // https://algorithms.tutorialhorizon.com/reverse-the-directed-graph
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
        }

        public Graph reverse() {
            Graph reverseGraph = new Graph(vertices);
            for (int source = 0; source < vertices; source++) {
                LinkedList<Integer> nodeList = adjList[source];
                for (int vertex = 0; vertex < nodeList.size(); vertex++) {
                    int destination = nodeList.get(vertex);
                    reverseGraph.addEdge(destination, source);
                }
            }
            return reverseGraph;
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Integer> nodeList = adjList[i];
                System.out.println("Vertex connected from vertex: " + i);
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print("->" + nodeList.get(j));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        System.out.println("---------------Original Graph---------------------------");
        graph.printGraph();
        Graph reverseGraph = graph.reverse();
        System.out.println("---------------Reverse Graph---------------------------");
        reverseGraph.printGraph();
    }
}
