package graphs;

import zobjects.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by gadzik on 14.08.20.
 */
public class Dijkstra2 {
    // https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-min-heap-java-implementation/
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge);
        }

        public void dijkstra_GetMinDistances(int sourceVertex) {
            boolean[] SPT = new boolean[vertices];
            int[] distance = new int[vertices];

            for (int vertex = 0; vertex < vertices; vertex++) {
                distance[vertex] = Integer.MAX_VALUE;
            }

            PriorityQueue<Pair<Integer, Integer>> priorityQ = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    int key1 = p1.getKey();
                    int key2 = p2.getKey();
                    return key1 - key2;
                }
            });

            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);
            priorityQ.offer(p0);

            while (!priorityQ.isEmpty()) {
                Pair<Integer, Integer> extractedPair = priorityQ.poll();
                int extractedVertex = extractedPair.getValue();

                if (!SPT[extractedVertex]) {
                    SPT[extractedVertex] = true;
                    LinkedList<Edge> list = adjacencylist[extractedVertex];
                    for (int vertex = 0; vertex < list.size(); vertex++) {
                        Edge edge = list.get(vertex);
                        int destination = edge.destination;

                        if (!SPT[destination]) {
                            int newKey = distance[extractedVertex] + edge.weight;
                            int currentKey = distance[destination];

                            if (currentKey > newKey) {
                                Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                                priorityQ.offer(p);
                                distance[destination] = newKey;
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            printDijkstra(distance, sourceVertex);
        }

        public void printDijkstra(int[] distance, int sourceVertex) {
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " + +i + " distance: " + distance[i]);
            }
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);
        }
    }
}
