package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 14.08.20.
 */
public class ConnectedComponents {
    // https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
    int V;
    LinkedList<Integer>[] adjListArray;

    ConnectedComponents(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int vertex : adjListArray[v]) {
            if (!visited[vertex]) {
                DFSUtil(vertex, visited);
            }
        }
    }

    void connectedComponents() {
        boolean[] visited = new boolean[V];
        for (int vertex = 0; vertex < V; ++vertex) {
            if (!visited[vertex]) {
                DFSUtil(vertex, visited);
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Following are connected components");
        g.connectedComponents();
    }
}
