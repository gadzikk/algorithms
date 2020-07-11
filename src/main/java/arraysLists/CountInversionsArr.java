package arraysLists;

import java.util.Arrays;

/**
 * Created by gadzik on 11.07.20.
 */
public class CountInversionsArr {
    // https://www.geeksforgeeks.org/counting-inversions/
    private static int mergeAndCount(int[] arr, int leftPosition, int midPosition, int rightPosition) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, leftPosition, midPosition + 1);
        // Right subarray
        int[] right = Arrays.copyOfRange(arr, midPosition + 1, rightPosition + 1);

        int i = 0, j = 0, k = leftPosition, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
                swaps += (midPosition + 1) - (leftPosition + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }


        // Fill from the rest of the right subarray
        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }

        return swaps;
    }

    private static int mergeSortAndCount(int[] arr, int leftPosition, int rightPosition) {

        int count = 0;
        if (leftPosition < rightPosition) {
            int midPosition = (leftPosition + rightPosition) / 2;
            // Total inversion count = leftPosition subarray count + rightPosition subarray count + merge count
            // Left subarray count
            count += mergeSortAndCount(arr, leftPosition, midPosition);
            // Right subarray count
            count += mergeSortAndCount(arr, midPosition + 1, rightPosition);
            // Merge count
            count += mergeAndCount(arr, leftPosition, midPosition, rightPosition);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }
}
