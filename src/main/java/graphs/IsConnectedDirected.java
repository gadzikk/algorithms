package graphs;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by gadzik on 14.08.20.
 */
public class IsConnectedDirected {
    // https://www.geeksforgeeks.org/check-if-a-directed-graph-is-connected-or-not/
    static int N = 100000;
    static Vector<Integer>[] gr1 = new Vector[N];
    static Vector<Integer>[] gr2 = new Vector[N];
    static boolean[] vis1 = new boolean[N];
    static boolean[] vis2 = new boolean[N];

    static {
        for (int i = 0; i < N; i++) {
            gr1[i] = new Vector<>();
            gr2[i] = new Vector<>();
        }
    }

    static void Add_edge(int u, int v) {
        gr1[u].add(v);
        gr2[v].add(u);
    }

    static void dfs1(int x) {
        vis1[x] = true;
        for (int vertex : gr1[x]) {
            if (!vis1[vertex]) {
                dfs1(vertex);
            }
        }
    }

    static void dfs2(int x) {
        vis2[x] = true;
        for (int vertex : gr2[x]) {
            if (!vis2[vertex]) {
                dfs2(vertex);
            }
        }
    }

    static boolean Is_connected(int n) {
        // Call for correct direction Call for reverse direction
        Arrays.fill(vis1, false);
        dfs1(1);
        Arrays.fill(vis2, false);
        dfs2(1);
        for (int vetex = 1; vetex <= n; vetex++) {
            // If any vertex it not visited in any direction Then graph is not connected
            if (!vis1[vetex] && !vis2[vetex]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;

        Add_edge(1, 2);
        Add_edge(1, 3);
        Add_edge(2, 3);
        Add_edge(3, 4);

        if (Is_connected(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
