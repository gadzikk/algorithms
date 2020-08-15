package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class CountSubgraphs {
    // https://algorithms.tutorialhorizon.com/count-number-of-subgraphs-in-a-given-graph/
    static class Graph {
        int vertices;
        LinkedList<Integer> adjList[];

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


        public int countConnectedComponents() {
            boolean[] visited = new boolean[vertices];
            int count = 0;
            int index;
            while ((index = checkGraphIsVisited(visited)) != -1) {
                dfs(index, visited);
                count++;
            }
            return count;
        }

        public int checkGraphIsVisited(boolean[] visited) {
            for (int vertex = 0; vertex < visited.length; vertex++) {
                if (!visited[vertex]) {
                    return vertex;
                }
            }
            return -1;
        }

        public void dfs(int start, boolean[] visited) {
            visited[start] = true;
            for (int i = 0; i < adjList[start].size(); i++) {
                int destination = adjList[start].get(i);
                if (!visited[destination]) {
                    dfs(destination, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(0, 1);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(2, 3);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
    }
}
