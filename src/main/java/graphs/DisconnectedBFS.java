package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 14.08.20.
 */
public class DisconnectedBFS {
    // https://algorithms.tutorialhorizon.com/breadth-first-search-in-disconnected-graph

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

        public void BFS() {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            System.out.println("BFS: ");
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    queue.add(i);

                    while (!queue.isEmpty()) {
                        int vertex = queue.remove();
                        visited[vertex] = true;
                        System.out.print(vertex + " ");

                        for (int j = 0; j < adjList[vertex].size(); j++) {
                            int adjVertex = adjList[vertex].get(j);
                            if (!visited[adjVertex]) {
                                visited[adjVertex] = true;
                                queue.add(adjVertex);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.BFS();
    }

}
