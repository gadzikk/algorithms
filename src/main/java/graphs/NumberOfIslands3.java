package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class NumberOfIslands3 {
    // https://www.geeksforgeeks.org/find-number-of-islands/
    static final int ROW = 5, COL = 5;

    boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    void DFS(int M[][], int row, int col, boolean visited[][]) {
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        NumberOfIslands3 I = new NumberOfIslands3();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
