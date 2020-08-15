package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class DFSDisconnected {
    // https://algorithms.tutorialhorizon.com/graph-depth-first-search-in-disconnected-graph/
    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination) {
            adjList[source].addFirst(destination);
        }

        public void DFSRecursion() {
            boolean[] visited = new boolean[vertices];
            System.out.println("Depth-First Search: ");
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited);
                }
            }
        }

        public void dfs(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start + " ");
            for (int i = 0; i < adjList[start].size(); i++) {
                int vertex = adjList[start].get(i);
                if (!visited[vertex]) {
                    dfs(vertex, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);
        graph.addEgde(1, 3);
        graph.addEgde(2, 3);
        graph.addEgde(0, 4);
        graph.addEgde(4, 5);
        graph.addEgde(5, 6);
        graph.DFSRecursion();
    }
}
