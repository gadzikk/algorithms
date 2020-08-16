package graphs;

import java.util.Vector;

/**
 * Created by gadzik on 16.08.20.
 */
public class IncomingEdgesEqualsToVertex {
    // https://www.geeksforgeeks.org/check-if-incoming-edges-in-a-vertex-of-directed-graph-is-equal-to-vertex-itself-or-not/
    static void add_edge(Vector<Integer> adj[], int source, int destination) {
        adj[source].add(destination);
    }

    static boolean Indegree(Vector<Integer> adj[], int v) {
        int indeg[] = new int[v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                indeg[adj[i].get(j)]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if (i == indeg[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 4;

        @SuppressWarnings("unchecked")
        Vector<Integer>[] adj = new Vector[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<>();
        }
        add_edge(adj, 0, 1);
        add_edge(adj, 1, 2);
        add_edge(adj, 0, 2);
        add_edge(adj, 0, 3);
        add_edge(adj, 1, 3);
        add_edge(adj, 2, 3);

        if (Indegree(adj, v)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
