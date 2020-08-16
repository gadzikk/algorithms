package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class FoodFill3 {
    // https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
    static int M = 6;
    static int N = 6;

    static void floodFillUtil(char mat[][], int x, int y, char prevColor, char newColor) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (mat[x][y] != prevColor) {
            return;
        }

        mat[x][y] = newColor;

        floodFillUtil(mat, x + 1, y, prevColor, newColor);
        floodFillUtil(mat, x - 1, y, prevColor, newColor);
        floodFillUtil(mat, x, y + 1, prevColor, newColor);
        floodFillUtil(mat, x, y - 1, prevColor, newColor);
    }

    static void replaceSurrounded(char mat[][]) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = '-';
                }
            }
        }

        for (int i = 0; i < M; i++) { // Left side
            if (mat[i][0] == '-') {
                floodFillUtil(mat, i, 0, '-', 'O');
            }
        }
        for (int i = 0; i < M; i++) { // Right side
            if (mat[i][N - 1] == '-') {
                floodFillUtil(mat, i, N - 1, '-', 'O');
            }
        }
        for (int i = 0; i < N; i++) { // Top side
            if (mat[0][i] == '-') {
                floodFillUtil(mat, 0, i, '-', 'O');
            }
        }
        for (int i = 0; i < N; i++) { // Bottom side
            if (mat[M - 1][i] == '-') {
                floodFillUtil(mat, M - 1, i, '-', 'O');
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == '-') {
                    mat[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}
        };

        replaceSurrounded(mat);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }

        System.out.println("");
    }
}

