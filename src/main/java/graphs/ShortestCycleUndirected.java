package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 15.08.20.
 */
public class ShortestCycleUndirected {
    // https://www.geeksforgeeks.org/shortest-cycle-in-an-undirected-unweighted-graph/

    static final int N = 100200;
    @SuppressWarnings("unchecked")
    static Vector<Integer>[] gr = new Vector[N];

    // Function to add edge
    static void Add_edge(int x, int y) {
        gr[x].add(y);
        gr[y].add(x);
    }

    static int shortest_cycle(int n) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);
            int[] par = new int[n];
            Arrays.fill(par, -1);

            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int child : gr[x]) {
                    if (dist[child] == (int) (1e9)) {
                        dist[child] = 1 + dist[x];
                        par[child] = x;
                        q.add(child);
                    } else if (par[x] != child && par[child] != x) {
                        ans = Math.min(ans, dist[x] + dist[child] + 1);
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < N; i++)
            gr[i] = new Vector<>();

        int n = 7;

        Add_edge(0, 6);
        Add_edge(0, 5);
        Add_edge(5, 1);
        Add_edge(1, 6);
        Add_edge(2, 6);
        Add_edge(2, 3);
        Add_edge(3, 4);
        Add_edge(4, 1);

        // Function call
        System.out.println(shortest_cycle(n));
    }
}
