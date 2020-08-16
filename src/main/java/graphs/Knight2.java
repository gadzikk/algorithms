package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class Knight2 {
    // https://www.geeksforgeeks.org/minimum-steps-reach-target-knight-set-2/
    static int dp[][] = new int[8][8];

    static int getsteps(int x, int y, int tx, int ty) {
        if (x == tx && y == ty) {
            return dp[0][0];
        } else {
            if (dp[Math.abs(x - tx)][Math.abs(y - ty)] != 0) {
                return dp[Math.abs(x - tx)][Math.abs(y - ty)];
            } else {

                // there will be two distinct positions from the knight towards a target.
                // if the target is in same row or column as of knight than there can be four
                // positions towards the target but in that two would be the same and the other two
                // would be the same.
                int x1, y1, x2, y2;

                // (x1, y1) and (x2, y2) are two positions. these can be different according to situation.
                // From position of knight, the chess board can be divided into four blocks i.e.. N-E, E-S, S-W, W-N .
                if (x <= tx) {
                    if (y <= ty) {
                        x1 = x + 2;
                        y1 = y + 1;
                        x2 = x + 1;
                        y2 = y + 2;
                    } else {
                        x1 = x + 2;
                        y1 = y - 1;
                        x2 = x + 1;
                        y2 = y - 2;
                    }
                } else if (y <= ty) {
                    x1 = x - 2;
                    y1 = y + 1;
                    x2 = x - 1;
                    y2 = y + 2;
                } else {
                    x1 = x - 2;
                    y1 = y - 1;
                    x2 = x - 1;
                    y2 = y - 2;
                }

                // ans will be, 1 + minimum of steps
                // required from (x1, y1) and (x2, y2).
                dp[Math.abs(x - tx)][Math.abs(y - ty)] = Math.min(getsteps(x1, y1, tx, ty), getsteps(x2, y2, tx, ty)) + 1;

                // exchanging the coordinates x with y of both
                // knight and target will result in same ans.
                dp[Math.abs(y - ty)][Math.abs(x - tx)] = dp[Math.abs(x - tx)][Math.abs(y - ty)];
                return dp[Math.abs(x - tx)][Math.abs(y - ty)];
            }
        }
    }

    // Driver Code
    static public void main(String[] args) {
        int ans;
        // size of chess board n*n
        int n = 100;

        // (x, y) coordinate of the knight.
        // (targetX, targetY) coordinate of the target position.
        int x = 4;
        int y = 5;
        int targetX = 1;
        int targetY = 1;

        // (Exception) these are the four corner points
        // for which the minimum steps is 4.
        if ((x == 1 && y == 1 && targetX == 2 && targetY == 2) || (x == 2 && y == 2 && targetX == 1 && targetY == 1)) {
            ans = 4;
        } else if ((x == 1 && y == n && targetX == 2 && targetY == n - 1) || (x == 2 && y == n - 1 && targetX == 1 && targetY == n)) {
            ans = 4;
        } else if ((x == n && y == 1 && targetX == n - 1 && targetY == 2) || (x == n - 1 && y == 2 && targetX == n && targetY == 1)) {
            ans = 4;
        } else if ((x == n && y == n && targetX == n - 1 && targetY == n - 1) || (x == n - 1 && y == n - 1 && targetX == n && targetY == n)) {
            ans = 4;
        } else {
            // dp[a][b], here a, b is the difference of
            // x & targetX and y & targetY respectively.
            dp[1][0] = 3;
            dp[0][1] = 3;
            dp[1][1] = 2;
            dp[2][0] = 2;
            dp[0][2] = 2;
            dp[2][1] = 1;
            dp[1][2] = 1;

            ans = getsteps(x, y, targetX, targetY);
        }

        System.out.println(ans);
    }
}
