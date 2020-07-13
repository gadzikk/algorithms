package arraysLists;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by gadzik on 12.07.20.
 */
public class SortEvensThenOdds {
    // https://www.geeksforgeeks.org/sort-even-numbers-ascending-order-sort-odd-numbers-descending-order/
    static void twoWaySortNegative(int arr[], int n) {
        // Make all odd numbers negative
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) != 0) { // Check for odd
                arr[i] *= -1;
            }
        }

        Arrays.sort(arr);

        // Retaining original array
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) != 0) {
                arr[i] *= -1;
            }
        }
    }

    static void twoWaySort(Integer arr[], int n) {
        // Current indexes from left and right
        int l = 0, r = n - 1;
        // Count of odd numbers
        int k = 0;

        while (l < r) {
            // Find first odd number from left side.
            while (arr[l] % 2 != 0) {
                l++;
                k++;
            }

            // Find first even number from right side.
            while (arr[r] % 2 == 0 && l < r) {
                r--;
            }

            // Swap odd number present on left and even number right.
            if (l < r) {
                // swap arr[l] arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        // Sort odd number in descending order
        Arrays.sort(arr, 0, k, Collections.reverseOrder());
        // Sort even number in ascending order
        Arrays.sort(arr, k, n);
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 3, 2, 7, 5, 4};
        twoWaySort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
