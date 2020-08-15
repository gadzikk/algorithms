package graphs;

import zobjects.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by gadzik on 15.08.20.
 */
public class Prim2 {
    // https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
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

    static class ResultSet {
        int parent;
        int weight;
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

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge);
        }

        public void primMST() {
            boolean[] mst = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            int[] keys = new int[vertices];

            for (int i = 0; i < vertices; i++) {
                keys[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
            }

            PriorityQueue<Pair<Integer, Integer>> priorityQ = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    int key1 = p1.getKey();
                    int key2 = p2.getKey();
                    return key1 - key2;
                }
            });

            keys[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(keys[0], 0);
            priorityQ.offer(p0);

            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;

            while (!priorityQ.isEmpty()) {
                Pair<Integer, Integer> extractedPair = priorityQ.poll();
                int extractedVertex = extractedPair.getValue();
                mst[extractedVertex] = true;

                LinkedList<Edge> list = adjacencylist[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);

                    if (mst[edge.destination] == false) {
                        int destination = edge.destination;
                        int newKey = edge.weight;
                        if (keys[destination] > newKey) {
                            Pair<Integer, Integer> pair = new Pair<>(newKey, destination);
                            priorityQ.offer(pair);

                            resultSet[destination].parent = extractedVertex;
                            resultSet[destination].weight = newKey;
                            keys[destination] = newKey;
                        }
                    }
                }
            }
            //print mst
            printMST(resultSet);
        }

        public void printMST(ResultSet[] resultSet) {
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 1; i < vertices; i++) {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent + " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 2, 1);
            graph.addEgde(1, 3, 2);
            graph.addEgde(2, 3, 4);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 5, 6);
            graph.primMST();
        }
    }
}
