package graphs;

/**
 * Created by gadzik on 17.08.20.
 */
public class CountWaysToReachPointMaze {
    // https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
    static int R = 4;
    static int C = 4;

    static int countPaths(int maze[][]) {
        if (maze[0][0] == -1) {
            return 0;
        }

        for (int row = 0; row < R; row++) {
            if (maze[row][0] == 0) {
                maze[row][0] = 1;
            }

            // If we encounter a blocked cell
            // in leftmost row, there is no way
            // of visiting any cell directly below it.
            else {
                break;
            }
        }

        for (int col = 1; col < C; col++) {
            if (maze[0][col] == 0) {
                maze[0][col] = 1;
            }

            // If we encounter a blocked cell in
            // bottommost row, there is no way of
            // visiting any cell directly below it.
            else {
                break;
            }
        }

        // The only difference is that if a cell
        // is -1, simply ignore it else recursively
        // compute count value maze[i][j]
        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                // If blockage is found,
                // ignore this cell
                if (maze[row][col] == -1) {
                    continue;
                }

                // If we can reach maze[row][col] from
                // maze[row-1][col] then increment count.
                if (maze[row - 1][col] > 0) {
                    maze[row][col] = (maze[row][col] + maze[row - 1][col]);
                }

                // If we can reach maze[row][col] from
                //  maze[row][col-1] then increment count.
                if (maze[row][col - 1] > 0) {
                    maze[row][col] = (maze[row][col] + maze[row][col - 1]);
                }
            }
        }

        return (maze[R - 1][C - 1] > 0) ? maze[R - 1][C - 1] : 0;
    }


    public static void main(String[] args) {
        int maze[][] = {
                {0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(countPaths(maze));
    }
}
