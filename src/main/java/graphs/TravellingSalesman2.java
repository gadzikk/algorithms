package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 15.08.20.
 */
public class TravellingSalesman2 {
    // https://www.geeksforgeeks.org/travelling-salesman-problem-greedy-approach/
    static void findMinRoute(int[][] graph) {
        int sum = 0;
        int counter = 0;
        int col = 0, row = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();

        visitedRouteList.add(0);
        int[] route = new int[graph.length];

        while (row < graph.length && col < graph[row].length) {

            if (counter >= graph[row].length - 1) {
                break;
            }

            if (col != row && !(visitedRouteList.contains(col))) {
                if (graph[row][col] < min) {
                    min = graph[row][col];
                    route[counter] = col + 1;
                }
            }
            col++;

            // Check all paths from the
            // ith indexed city
            if (col == graph[row].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                col = 0;
                row = route[counter] - 1;
                counter++;
            }
        }

        // Update the ending city in array
        // from city which was last visited
        row = route[counter - 1] - 1;

        for (col = 0; col < graph.length; col++) {
            if ((row != col) && graph[row][col] < min) {
                min = graph[row][col];
                route[counter] = col + 1;
            }
        }
        sum += min;

        System.out.print("Minimum Cost is : ");
        System.out.println(sum);
    }

    public static void
    main(String[] args) {
        int[][] tsp = {
                {-1, 10, 15, 20},
                {10, -1, 35, 25},
                {15, 35, -1, 30},
                {20, 25, 30, -1}
        };

        findMinRoute(tsp);
    }
}
