package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 12.08.20.
 */
public class EulerianPathAndCircuitUndirected {
    // https://www.geeksforgeeks.org/eulerian-path-and-circuit/
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[];

    EulerianPathAndCircuitUndirected(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        int i;
        for (i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0) {
                break;
            }
        }

        // If there are no edges in the graph, return true
        if (i == V) {
            return true;
        }

        // Start DFS traversal from a vertex with non-zero degree
        DFSUtil(i, visited);

        // Check if all non-zero degree vertices are visited
        for (i = 0; i < V; i++) {
            if (visited[i] == false && adj[i].size() > 0) {
                return false;
            }
        }

        return true;
    }

    /* The function returns one of the following values
       0 --> If grpah is not Eulerian
       1 --> If graph has an Euler path (Semi-Eulerian)
       2 --> If graph has an Euler Circuit (Eulerian)  */
    int isEulerian() {
        // Check if all non-zero degree vertices are connected
        if (isConnected() == false) {
            return 0;
        }

        // Count vertices with odd degree
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                odd++;
            }
        }

        // If count is more than 2, then graph is not Eulerian
        if (odd > 2) {
            return 0;
        }

        // If odd count is 2, then semi-eulerian.
        // If odd count is 0, then eulerian
        // Note that odd count can never be 1 for undirected graph
        return (odd == 2) ? 1 : 2;
    }

    void test() {
        int res = isEulerian();
        if (res == 0) {
            System.out.println("graph is not Eulerian");
        } else if (res == 1) {
            System.out.println("graph has a Euler path");
        } else {
            System.out.println("graph has a Euler cycle");
        }
    }

    public static void main(String args[]) {
        EulerianPathAndCircuitUndirected g1 = new EulerianPathAndCircuitUndirected(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();

        EulerianPathAndCircuitUndirected g2 = new EulerianPathAndCircuitUndirected(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();

        EulerianPathAndCircuitUndirected g3 = new EulerianPathAndCircuitUndirected(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();

        EulerianPathAndCircuitUndirected g4 = new EulerianPathAndCircuitUndirected(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();

        EulerianPathAndCircuitUndirected g5 = new EulerianPathAndCircuitUndirected(3);
        g5.test();
    }
}
