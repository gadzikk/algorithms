package trees;

import java.util.Arrays;

/**
 * Created by gadzik on 07.08.20.
 */
public class PrintLevelsSorted2 {
    static void printSortedLevels(int arr[], int n) {
        int level = 0;
        for (int i = 0; i < n; level++) {
            int cnt = (int) Math.pow(2, level);
            cnt -= 1;
            int min = Math.min(i + cnt, n - 1);
            Arrays.sort(arr, i, min + 1);
            while (i <= min) {
                System.out.print(arr[i] + " ");
                i++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 4, 9, 2, 1};
        int n = arr.length;
        printSortedLevels(arr, n);
    }
}
