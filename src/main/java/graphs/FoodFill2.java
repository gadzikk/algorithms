package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by gadzik on 15.08.20.
 */
public class FoodFill2 {
    // https://www.techiedelight.com/flood-fill-algorithm/
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Below arrays details all 8 possible movements
    private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean isSafe(char[][] M, int m, int n, int x, int y, char target) {
        return x >= 0 && x < m && y >= 0 && y < n && M[x][y] == target;
    }

    // Flood fill using BFS
    public static void floodfill(char[][] M, int x, int y, char replacement) {
        int m = M.length;
        int n = M[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));

        char target = M[x][y];

        while (!q.isEmpty()) {
            Pair node = q.poll();
            x = node.x;
            y = node.y;

            M[x][y] = replacement;

            for (int k = 0; k < row.length; k++) {
                if (isSafe(M, m, n, x + row[k], y + col[k], target)) {
                    q.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] M = {
                "YYYGGGGGGG".toCharArray(),
                "YYYYYYGXXX".toCharArray(),
                "GGGGGGGXXX".toCharArray(),
                "WWWWWGGGGX".toCharArray(),
                "WRRRRRGXXX".toCharArray(),
                "WWWRRGGXXX".toCharArray(),
                "WBWRRRRRRX".toCharArray(),
                "WBBBBRRXXX".toCharArray(),
                "WBBXBBBBXX".toCharArray(),
                "WBBXXXXXXX".toCharArray()
        };

        int x = 3, y = 9;
        char replacement = 'C';
        floodfill(M, x, y, replacement);
        for (char[] row : M) {
            System.out.println(Arrays.toString(row));
        }
    }
}
