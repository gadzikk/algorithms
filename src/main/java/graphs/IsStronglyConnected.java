package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 14.08.20.
 */
public class IsStronglyConnected {
    // https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
    private int V;
    private LinkedList<Integer> adj[];

    IsStronglyConnected(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    Boolean isSC() {
        // Step 1: Mark all the vertices as not visited (For first DFS)
        // Step 2: Do DFS traversal starting from first vertex.
        // If DFS traversal doesn't visit all vertices, then return false.
        Boolean visited[] = new Boolean[V];

        for (int vertex = 0; vertex < V; vertex++) {
            visited[vertex] = false;
        }

        DFSUtil(0, visited);

        for (int vertex = 0; vertex < V; vertex++) {
            if (!visited[vertex]) {
                return false;
            }
        }

        // Step 3: Create a reversed graph
        // Step 4: Mark all the vertices as not visited (For second DFS)
        // Step 5: Do DFS for reversed graph starting from
        IsStronglyConnected gr = getTranspose();

        for (int vertex = 0; vertex < V; vertex++) {
            visited[vertex] = false;
        }

        gr.DFSUtil(0, visited);

        for (int vertex = 0; vertex < V; vertex++) {
            if (!visited[vertex]) {
                return false;
            }
        }

        return true;
    }

    void DFSUtil(int v, Boolean visited[]) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    IsStronglyConnected getTranspose() {
        IsStronglyConnected g = new IsStronglyConnected(V);
        for (int vertex = 0; vertex < V; vertex++) {
            Iterator<Integer> i = adj[vertex].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(vertex);
            }
        }
        return g;
    }



    public static void main(String args[]) {
        IsStronglyConnected g1 = new IsStronglyConnected(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        if (g1.isSC()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        IsStronglyConnected g2 = new IsStronglyConnected(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (g2.isSC()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
