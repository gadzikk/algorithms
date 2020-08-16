package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class Knight3 {
    // https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/

    static int N = 8;

    static boolean isSafe(int x, int y, int position[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && position[x][y] == -1);
    }

    static void printSolution(int position[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(position[x][y] + " ");
            }
            System.out.println();
        }
    }

    // This function solves the Knight Tour problem using Backtracking.

    static boolean solveKT() {
        int position[][] = new int[8][8];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                position[x][y] = -1;
            }
        }

        int xRules[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yRules[] = {1, 2, 2, 1, -1, -2, -2, -1};

        position[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, position, xRules, yRules)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(position);

        return true;
    }

    static boolean solveKTUtil(int x, int y, int movei, int position[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, position)) {
                position[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, position, xMove, yMove)) {
                    return true;
                }
                else {
                    position[next_x][next_y] = -1;// backtracking
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        solveKT();
    }
}
