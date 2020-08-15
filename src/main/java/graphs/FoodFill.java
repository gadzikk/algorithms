package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class FoodFill {
    // https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
    static int M = 8;
    static int N = 8;

    static void floodFillUtil(int screen[][], int x, int y, int prevColor, int newColor) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (screen[x][y] != prevColor) {
            return;
        }

        screen[x][y] = newColor;

        floodFillUtil(screen, x + 1, y, prevColor, newColor);
        floodFillUtil(screen, x - 1, y, prevColor, newColor);
        floodFillUtil(screen, x, y + 1, prevColor, newColor);
        floodFillUtil(screen, x, y - 1, prevColor, newColor);
    }

    static void floodFill(int screen[][], int x, int y, int newColor) {
        int prevColor = screen[x][y];
        floodFillUtil(screen, x, y, prevColor, newColor);
    }

    public static void main(String[] args) {
        int screen[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;
        floodFill(screen, x, y, newC);

        System.out.println("Updated screen after call to floodFill: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
