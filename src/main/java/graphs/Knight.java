package graphs;

import java.util.Vector;

/**
 * Created by gadzik on 16.08.20.
 */
public class Knight {
    // https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
    // https://www.techiedelight.com/chess-knight-problem-find-shortest-path-source-destination/
    static class Cell {
        int x, y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N) {
            return true;
        }
        return false;
    }

    static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        // x and y direction, where a knight can move
        int xRules[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int yRules[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Vector<Cell> q = new Vector<>();
        // push starting position of knight with 0 distance
        q.add(new Cell(knightPos[0], knightPos[1], 0));

        boolean visited[][] = new boolean[N + 1][N + 1];

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                visited[row][col] = false;
            }
        }

        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell temp = q.firstElement();
            q.remove(0);

            if (temp.x == targetPos[0] && temp.y == targetPos[1]) {
                return temp.dis;
            }

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                int x = temp.x + xRules[i];
                int y = temp.y + yRules[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Cell(x, y, temp.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 30;
        int knightPos[] = {1, 1};
        int targetPos[] = {30, 30};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
}
