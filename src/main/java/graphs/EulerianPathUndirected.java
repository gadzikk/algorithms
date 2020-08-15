package graphs;

/**
 * Created by gadzik on 12.08.20.
 */

import java.util.*;

public class EulerianPathUndirected {
    // https://www.geeksforgeeks.org/eulerian-path-undirected-graph/

    static void findpath(int[][] graph, int n) {
        Vector<Integer> numofadj = new Vector<>();

        // Find out number of edges each vertex has
        for (int i = 0; i < n; i++) {
            numofadj.add(accumulate(graph[i], 0));
        }

        // Find out how many vertex has odd number edges
        int startPoint = 0, numofodd = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (numofadj.elementAt(i) % 2 == 1) {
                numofodd++;
                startPoint = i;
            }
        }

        if (numofodd > 2) {
            System.out.println("No Solution");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        Vector<Integer> path = new Vector<>();
        int cur = startPoint;

        while (!stack.isEmpty() || accumulate(graph[cur], 0) != 0) {

            if (accumulate(graph[cur], 0) == 0) {
                path.add(cur);
                cur = stack.pop();
            } else {
                for (int i = 0; i < n; i++) {
                    if (graph[cur][i] == 1) {
                        stack.add(cur);
                        graph[cur][i] = 0;
                        graph[i][cur] = 0;
                        cur = i;
                        break;
                    }
                }
            }
        }

        for (int ele : path) {
            System.out.print(ele + " -> ");
        }
        System.out.println(cur);
    }

    static int accumulate(int[] arr, int sum) {
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0}};
        int n = graph1.length;
        findpath(graph1, n);

        // Test case 2
        int[][] graph2 = {{0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0}};
        n = graph2.length;
        findpath(graph2, n);

        // Test case 3
        int[][] graph3 = {{0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};
        n = graph3.length;
        findpath(graph3, n);
    }

}
