package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 08.07.20.
 */
public class RearrangeEvenOddIndexes {
    // https://www.geeksforgeeks.org/rearrange-array-every-odd-indexed-element-greater-previous/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // method to rearrange array such that
    // odd indexed elements are greater.
    public static void Rearrage(int[] arr, int n) {
        // Common code for odd and even lengths
        for (int i = 0; i < n - 1; i = i + 2) {
            if (arr[i] > arr[i + 1])
                swap(arr, i, i + 1);
        }

        // If length is odd
        if ((n & 1) > 0) {
            for (int i = n - 1; i > 0; i = i - 2)
                if (arr[i] > arr[i - 1])
                    swap(arr, i, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Before rearranging");
        System.out.println(Arrays.toString(arr));

        Rearrage(arr, arr.length);

        System.out.println("After rearranging");
        System.out.println(Arrays.toString(arr));
    }
}
