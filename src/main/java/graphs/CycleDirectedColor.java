package graphs;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class CycleDirectedColor {
    // https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-a-directed-graph-using-colors/

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

        public boolean isCycle() {
            HashSet<Integer> whiteSet = new HashSet<>();
            HashSet<Integer> graySet = new HashSet<>();
            HashSet<Integer> blackSet = new HashSet<>();

            for (int i = 0; i < adjList.length; i++) {
                whiteSet.add(i);
            }

            for (int i = 0; i < vertices; i++) {
                if (whiteSet.contains(i) && isCycleUtil(i, whiteSet, graySet, blackSet)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isCycleUtil(int vertex, HashSet<Integer> whiteSet, HashSet<Integer> graySet, HashSet<Integer> blackSet) {
            whiteSet.remove(vertex);
            graySet.add(vertex);

            for (int i = 0; i < adjList[vertex].size(); i++) {
                int adjVertex = adjList[vertex].get(i);

                if (graySet.contains(adjVertex)) {
                    return true;
                }

                if (blackSet.contains(adjVertex)) {
                    continue;
                }

                if (isCycleUtil(adjVertex, whiteSet, graySet, blackSet)) {
                    return true;
                }
            }

            graySet.remove(vertex);
            blackSet.add(vertex);
            return false;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        boolean result = graph.isCycle();
        System.out.println("is Cycle present: " + result);
    }
}
