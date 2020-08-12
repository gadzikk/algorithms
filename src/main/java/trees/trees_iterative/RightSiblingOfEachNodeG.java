package trees.trees_iterative;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 09.08.20.
 */
public class RightSiblingOfEachNodeG {
    // https://www.geeksforgeeks.org/right-sibling-of-each-node-in-a-tree-given-as-array-of-edges/
    static void PrintSiblings(int root, int N, int E, Vector<Integer> adj[]) {
        boolean[] vis = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        q.add(-1);
        vis[root] = true;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            if (node == -1) {

                if (!q.isEmpty()) {
                    q.add(-1);
                }
                continue;
            }

            System.out.print(node + " " + q.peek() + "\n");
            for (Integer s : adj[node]) {
                if (!vis[s]) {
                    vis[s] = true;
                    q.add(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 7, E = 6;
        Vector<Integer>[] adj = new Vector[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new Vector<Integer>();
        }
        adj[1].add(2);
        adj[1].add(3);
        adj[2].add(4);
        adj[2].add(5);
        adj[3].add(6);
        adj[3].add(7);
        int root = 1;
        PrintSiblings(root, N, E, adj);
    }
}
