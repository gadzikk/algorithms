package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class MinCostPath2 {
    // https://www.geeksforgeeks.org/min-cost-path-dp-6/
    private static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }

    private static int minCost(int cost[][], int rowLength, int colLength) {
        int row;
        int col;
        int totalCosts[][] = new int[rowLength + 1][colLength + 1];

        totalCosts[0][0] = cost[0][0];

        /* Initialize first column of total cost(totalCosts) array */
        for (row = 1; row <= rowLength; row++) {
            totalCosts[row][0] = totalCosts[row - 1][0] + cost[row][0];
        }
        /* Initialize first row of totalCosts array */
        for (col = 1; col <= colLength; col++) {
            totalCosts[0][col] = totalCosts[0][col - 1] + cost[0][col];
        }

        /* Construct rest of the totalCosts array */
        for (row = 1; row <= rowLength; row++) {
            for (col = 1; col <= colLength; col++) {
                totalCosts[row][col] = min(totalCosts[row - 1][col - 1], totalCosts[row - 1][col], totalCosts[row][col - 1]) + cost[row][col];
            }
        }

        return totalCosts[rowLength][colLength];
    }

    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println(minCost(cost, 2, 2));
    }
}
