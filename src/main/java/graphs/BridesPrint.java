package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 16.08.20.
 */
public class BridesPrint {
    // https://www.geeksforgeeks.org/bridge-in-a-graph/
    private int V;
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    BridesPrint(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridgeUtil(int vertex, boolean visited[], int discoveryTimes[], int low[], int parent[]) {
        visited[vertex] = true;
        discoveryTimes[vertex] = low[vertex] = ++time;
        Iterator<Integer> i = adj[vertex].iterator();
        while (i.hasNext()) {
            int v = i.next();

            if (!visited[v]) {
                parent[v] = vertex;
                bridgeUtil(v, visited, discoveryTimes, low, parent);
                low[vertex] = Math.min(low[vertex], low[v]);
                if (low[v] > discoveryTimes[vertex]) {
                    System.out.println(vertex + " " + v);
                }
            } else if (v != parent[vertex]) {
                low[vertex] = Math.min(low[vertex], discoveryTimes[v]);
            }
        }
    }


    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                bridgeUtil(i, visited, disc, low, parent);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Bridges in first graph ");
        BridesPrint g1 = new BridesPrint(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();

        System.out.println("Bridges in Second graph");
        BridesPrint g2 = new BridesPrint(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.bridge();
        System.out.println();

        System.out.println("Bridges in Third graph ");
        BridesPrint g3 = new BridesPrint(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.bridge();
    }
}
