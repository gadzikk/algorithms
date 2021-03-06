package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 11.07.20.
 */
public class ZigZagRearrange {
    // https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
    static int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};

    // Method for zig-zag conversion of array
    static void zigZag() {
        // Flag true indicates relation "<" is expected,  else ">" is expected.  The first expected relation is "<"
        boolean flag = true;
        int temp = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            if (flag) {  /* "<" relation expected */
                /* If we have a situation like A > B > COLS,  we get A > B < COLS by swapping B and COLS */
                if (arr[i + 1] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else { /* ">" relation expected */
                /* If we have a situation like A < B < COLS, we get A < COLS > B by swapping B and COLS */
                if (arr[i] < arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }

    public static void main(String[] args) {
        zigZag();
        System.out.println(Arrays.toString(arr));
    }
}
