package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class CycleUndirected {
    // https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-undirected-graph-using-dfs/

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

        public boolean isCycle() {
            boolean result = false;
            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    if (isCycleUtil(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return result;
        }

        boolean isCycleUtil(int currVertex, boolean[] visited, int parent) {
            visited[currVertex] = true;

            for (int i = 0; i < adjList[currVertex].size(); i++) {
                int vertex = adjList[currVertex].get(i);
                if (vertex != parent) {
                    if (visited[vertex]) {
                        return true;
                    } else {
                        if (isCycleUtil(vertex, visited, currVertex)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        boolean result = graph.isCycle();
        System.out.println("is Cycle present: " + result);
    }
}
