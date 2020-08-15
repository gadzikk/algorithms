package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class PathBetwenTwoVertices {
    // https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    public PathBetwenTwoVertices(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //prints BFS traversal from a given source source
    Boolean isReachable(int source, int destination) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source] = true;
        queue.add(source);
        while (queue.size() != 0) {
            source = queue.poll();
            Iterator<Integer> i = adj[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (n == destination) {
                    return true;
                }

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        PathBetwenTwoVertices g = new PathBetwenTwoVertices(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int u = 1;
        int v = 3;
        if (g.isReachable(u, v)) {
            System.out.println("There is a path from " + u + " to " + v);
        } else {
            System.out.println("There is no path from " + u + " to " + v);
        }

        u = 3;
        v = 1;
        if (g.isReachable(u, v)) {
            System.out.println("There is a path from " + u + " to " + v);
        } else {
            System.out.println("There is no path from " + u + " to " + v);
        }
    }
}
