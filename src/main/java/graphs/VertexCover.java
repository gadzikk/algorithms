package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 16.08.20.
 */
public class VertexCover {
    // https://www.geeksforgeeks.org/vertex-cover-problem-set-1-introduction-approximate-algorithm-2
    private int V;
    private LinkedList<Integer> adj[];

    VertexCover(int v) {
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

    void printVertexCover() {
        boolean visited[] = new boolean[V];
        for (int vertex = 0; vertex < V; vertex++) {
            visited[vertex] = false;
        }

        for (int vertex = 0; vertex < V; vertex++) {
            if (!visited[vertex]) {
                Iterator<Integer> i = adj[vertex].iterator();
                while (i.hasNext()) {
                    int v = i.next();
                    if (!visited[v]) {
                        visited[v] = true;
                        visited[vertex] = true;
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < V; j++) {
            if (visited[j]) {
                System.out.print(j + " ");
            }
        }
    }

    // Driver method
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        VertexCover g = new VertexCover(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.printVertexCover();
    }

}
