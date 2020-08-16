package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 16.08.20.
 */
public class ShortestPathBinaryMaze {
    // https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
    static int ROW = 9;
    static int COL = 10;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class pointNode {
        Point point;
        int distance;

        public pointNode(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    static int rowRules[] = {-1, 0, 0, 1};
    static int colRules[] = {0, -1, 1, 0};

    static int BFS(int mat[][], Point source, Point destination) {
        if (mat[source.x][source.y] != 1 || mat[destination.x][destination.y] != 1) {
            return -1;
        }

        boolean[][] visited = new boolean[ROW][COL];
        visited[source.x][source.y] = true;
        Queue<pointNode> q = new LinkedList<>();

        pointNode s = new pointNode(source, 0);
        q.add(s);

        while (!q.isEmpty()) {
            pointNode curr = q.peek();
            Point currentPoint = curr.point;

            // If we have reached the destination cell,
            // we are done
            if (currentPoint.x == destination.x && currentPoint.y == destination.y) {
                return curr.distance;
            }

            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = currentPoint.x + rowRules[i];
                int col = currentPoint.y + colRules[i];

                if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    pointNode Adjcell = new pointNode(new Point(row, col), curr.distance + 1);
                    q.add(Adjcell);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);
        int dist = BFS(mat, source, dest);

        if (dist != Integer.MAX_VALUE) {
            System.out.println("Shortest Path is " + dist);
        } else {
            System.out.println("Shortest Path doesn't exist");
        }
    }
}
