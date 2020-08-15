package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by gadzik on 14.08.20.
 */
public class StronglyConnectedComponents {
    // https://www.geeksforgeeks.org/strongly-connected-components/
    private int V;
    private LinkedList<Integer> adj[];

    StronglyConnectedComponents(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> i = adj[vertex].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    StronglyConnectedComponents getTranspose() {
        StronglyConnectedComponents g = new StronglyConnectedComponents(V);
        for (int vertex = 0; vertex < V; vertex++) {
            Iterator<Integer> i = adj[vertex].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(vertex);
            }
        }
        return g;
    }

    void fillOrder(int vertex, boolean visited[], Stack stack) {
        visited[vertex] = true;
        Iterator<Integer> i = adj[vertex].iterator();
        while (i.hasNext()) {
            int v = i.next();
            if (!visited[v]) {
                fillOrder(v, visited, stack);
            }
        }

        // All vertices reachable from vertex are processed by now, push vertex to Stack
        stack.push(vertex);
    }

    void printSCCs() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int vertex = 0; vertex < V; vertex++) {
            if (!visited[vertex]) {
                fillOrder(vertex, visited, stack);
            }
        }

        // Create a reversed graph
        StronglyConnectedComponents gr = getTranspose();

        for (int vertex = 0; vertex < V; vertex++) {
            visited[vertex] = false;
        }

        while (!stack.empty()) {
            int v = (int) stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        StronglyConnectedComponents g = new StronglyConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.printSCCs();
    }
}
