package graphs;

import java.util.Vector;

/**
 * Created by gadzik on 14.08.20.
 */
public class GraphEdgeAdjList {
    // https://www.geeksforgeeks.org/add-and-remove-edge-in-adjacency-list-representation-of-a-graph
    static void addEdge(Vector<Integer> adj[], int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    static void delEdge(Vector<Integer> adj[], int u, int v) {
        for (int vertex = 0; vertex < adj[u].size(); vertex++) {
            if (adj[u].get(vertex) == v) {
                adj[u].remove(vertex);
                break;
            }
        }

        for (int vertex = 0; vertex < adj[v].size(); vertex++) {
            if (adj[v].get(vertex) == u) {
                adj[v].remove(vertex);
                break;
            }
        }
    }

    static void printGraph(Vector<Integer> adj[], int V) {
        for (int v = 0; v < V; ++v) {
            System.out.print("vertex " + v + " ");
            for (Integer x : adj[v]) {
                System.out.print("-> " + x);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int V = 5;
        Vector<Integer>[] adj = new Vector[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Vector<>();
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj, V);
        delEdge(adj, 1, 4);
        printGraph(adj, V);
    }
}
