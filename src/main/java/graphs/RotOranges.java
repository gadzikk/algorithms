package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 15.08.20.
 */
public class RotOranges {
    // https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
    public final static int R = 3;
    public final static int C = 5;

    static class Ele {
        int x = 0;
        int y = 0;

        Ele(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int row, int col) {
        return (row >= 0 && col >= 0 && row < R && col < C);
    }


    static boolean isDelim(Ele temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    // Function to check whether there is still a fresh orange remaining
    static boolean checkAll(int arr[][]) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static int rotOranges(int arr[][]) {
        Queue<Ele> Q = new LinkedList<>();
        Ele temp;
        int ans = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 2) {
                    Q.add(new Ele(i, j));
                }
            }
        }

        // Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1, -1));

        while (!Q.isEmpty()) {
            boolean flag = false;

            while (!isDelim(Q.peek())) {
                temp = Q.peek();

                if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        // if this is the first orange to get rotten, increase
                        // count and set the flag.
                        ans++;
                        flag = true;
                    }

                    arr[temp.x + 1][temp.y] = 2;
                    temp.x++;
                    Q.add(new Ele(temp.x, temp.y));
                    // Move back to current cell
                    temp.x--;
                }

                if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Ele(temp.x, temp.y)); // push this cell to Queue
                    temp.x++;
                }

                if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y + 1] = 2;
                    temp.y++;
                    Q.add(new Ele(temp.x, temp.y)); // Push this cell to Queue
                    temp.y--;
                }

                if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    Q.add(new Ele(temp.x, temp.y)); // push this cell to Queue
                }
                Q.remove();

            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty()) {
                Q.add(new Ele(-1, -1));
            }

        }

        // Return -1 if all arranges could not rot, otherwise -1.s
        return (checkAll(arr)) ? -1 : ans;

    }

    // Driver program
    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        int ans = rotOranges(arr);
        if (ans == -1) {
            System.out.println("All oranges cannot rot");
        } else {
            System.out.println("Time required for all oranges to rot = " + ans);
        }
    }
}
