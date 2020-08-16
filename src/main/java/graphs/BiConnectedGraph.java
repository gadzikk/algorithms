package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 16.08.20.
 */
public class BiConnectedGraph {
    // https://www.geeksforgeeks.org/biconnectivity-in-a-graph/
    private int V;
    private LinkedList<Integer> adj[];

    int time = 0;
    static final int NIL = -1;

    BiConnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isBCUtil(int vertex, boolean visited[], int discoveryTimes[], int low[], int parent[]) {

        int children = 0;
        visited[vertex] = true;

        discoveryTimes[vertex] = low[vertex] = ++time;

        Iterator<Integer> i = adj[vertex].iterator();
        while (i.hasNext()) {
            int v = i.next();

            if (!visited[v]) {
                children++;
                parent[v] = vertex;

                if (isBCUtil(v, visited, discoveryTimes, low, parent)) {
                    return true;
                }

                low[vertex] = Math.min(low[vertex], low[v]);

                if (parent[vertex] == NIL && children > 1) {
                    return true;
                }

                if (parent[vertex] != NIL && low[v] >= discoveryTimes[vertex]) {
                    return true;
                }

            } else if (v != parent[vertex]) {
                low[vertex] = Math.min(low[vertex], discoveryTimes[v]);
            }
        }
        return false;
    }

    boolean isBC() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }

        if (isBCUtil(0, visited, disc, low, parent) == true) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        BiConnectedGraph g1 = new BiConnectedGraph(2);
        g1.addEdge(0, 1);
        if (g1.isBC())
            System.out.println("Yes");
        else
            System.out.println("No");

        BiConnectedGraph g2 = new BiConnectedGraph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(2, 4);
        if (g2.isBC())
            System.out.println("Yes");
        else
            System.out.println("No");

        BiConnectedGraph g3 = new BiConnectedGraph(3);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        if (g3.isBC())
            System.out.println("Yes");
        else
            System.out.println("No");

        BiConnectedGraph g4 = new BiConnectedGraph(5);
        g4.addEdge(1, 0);
        g4.addEdge(0, 2);
        g4.addEdge(2, 1);
        g4.addEdge(0, 3);
        g4.addEdge(3, 4);
        if (g4.isBC())
            System.out.println("Yes");
        else
            System.out.println("No");

        BiConnectedGraph g5 = new BiConnectedGraph(3);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        g5.addEdge(2, 0);
        if (g5.isBC())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
