package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class TravellingSalesman {
    // https://www.geeksforgeeks.org/travelling-salesman-problem-implementation-using-backtracking/?ref=rp
    static int tsp(int[][] graph, boolean[] visited, int currPos, int n, int count, int cost, int ans) {
        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false && graph[currPos][i] > 0) {
                visited[i] = true;
                ans = tsp(graph, visited, i, n, count + 1, cost + graph[currPos][i], ans);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        boolean[] v = new boolean[n];
        v[0] = true;
        int ans = Integer.MAX_VALUE;
        ans = tsp(graph, v, 0, n, 1, 0, ans);
        System.out.println(ans);
    }
}
