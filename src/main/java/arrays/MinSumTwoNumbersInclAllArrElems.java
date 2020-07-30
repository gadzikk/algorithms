package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 11.07.20.
 */
public class MinSumTwoNumbersInclAllArrElems {
    // https://www.geeksforgeeks.org/minimum-sum-two-numbers-formed-digits-array/
    static int solve(int arr[], int n) {
        // sort the array
        Arrays.sort(arr);
        // let two numbers be a and b
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            // fill a and b with every alternate digit of input array
            if (i % 2 != 0) {
                a = a * 10 + arr[i];
            } else {
                b = b * 10 + arr[i];
            }
        }
        return a + b;
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        int n = arr.length;

        System.out.print("Sum is " + solve(arr, n));
    }
}
