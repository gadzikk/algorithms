package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class LargestRegion {
    // https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
    static int ROW, COL, count;

    // A function to check if a given cell (row, col)
    // can be included in DFS
    static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {

        return ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]));
    }

    static void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column  numbers of 8 neighbours of a given cell
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                count++;
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    static int largestRegion(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];

        int result = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    DFS(M, i, j, visited);

                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int M[][] = {
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        ROW = 4;
        COL = 5;
        System.out.println(largestRegion(M));
    }
}
