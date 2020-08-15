package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 12.08.20.
 */
public class EulerianCircuitDirected {
    // https://www.geeksforgeeks.org/euler-circuit-directed-graph/
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[];//Adjacency List
    private int in[];            //maintaining in degree

    //Constructor
    EulerianCircuitDirected(int v) {
        V = v;
        adj = new LinkedList[v];
        in = new int[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
            in[i] = 0;
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        in[w]++;
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

    EulerianCircuitDirected getTranspose() {
        EulerianCircuitDirected g = new EulerianCircuitDirected(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(v);
                (g.in[v])++;
            }
        }
        return g;
    }

    // The main function that returns true if graph is strongly    // connected
    Boolean isSC() {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        DFSUtil(0, visited);

        // If DFS traversal doesn't visit all vertices, then return false.
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                return false;
            }
        }


        // Step 3: Create a reversed graph
        EulerianCircuitDirected gr = getTranspose();

        // Step 4: Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Step 5: Do DFS for reversed graph starting from first vertex.
        // Staring Vertex must be same starting point of first DFS
        gr.DFSUtil(0, visited);

        // If all vertices are not visited in second DFS, then
        // return false
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                return false;
            }
        }

        return true;
    }

    Boolean isEulerianCycle() {
        if (isSC() == false) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (adj[i].size() != in[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        EulerianCircuitDirected g = new EulerianCircuitDirected(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        if (g.isEulerianCycle())
            System.out.println("Given directed graph is eulerian ");
        else
            System.out.println("Given directed graph is NOT eulerian ");
    }
}
