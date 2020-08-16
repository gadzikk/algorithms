package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class MinCostPathOdd {
    // https://www.geeksforgeeks.org/minimum-odd-cost-path-in-a-matrix/
    public static final int M = 100;
    public static final int N = 100;

    static int find_min_odd_cost(int given[][], int m, int n) {
        int floor[][] = new int[M][N];
        int min_odd_cost = 0;
        int row, col, temp;

        for (col = 0; col < n; col++) {
            floor[0][col] = given[0][col];
        }

        for (row = 1; row < m; row++) {
            for (col = 0; col < n; col++) {

                // leftmost element
                if (col == 0) {
                    floor[row][col] = given[row][col];
                    floor[row][col] += Math.min(floor[row - 1][col], floor[row - 1][col + 1]);
                }

                // rightmost element
                else if (col == n - 1) {
                    floor[row][col] = given[row][col];
                    floor[row][col] += Math.min(floor[row - 1][col], floor[row - 1][col - 1]);
                } else {
                    temp = Math.min(floor[row - 1][col], floor[row - 1][col - 1]);
                    temp = Math.min(temp, floor[row - 1][col + 1]);
                    floor[row][col] = given[row][col] + temp;
                }
            }
        }

        min_odd_cost = Integer.MAX_VALUE;

        for (col = 0; col < n; col++) {
            if (floor[n - 1][col] % 2 == 1) {
                if (min_odd_cost > floor[n - 1][col]) {
                    min_odd_cost = floor[n - 1][col];
                }
            }
        }

        if (min_odd_cost == Integer.MIN_VALUE) {
            return -1;
        }

        return min_odd_cost;
    }

    public static void main(String args[]) {
        int m = 5, n = 5;
        int given[][] = {
                {1, 2, 3, 4, 6},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {100, 2, 3, 4, 5}
        };

        System.out.println("Minimum odd cost is " + find_min_odd_cost(given, m, n));
    }
}
