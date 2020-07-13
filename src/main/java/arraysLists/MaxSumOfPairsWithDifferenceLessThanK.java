package arraysLists;

import java.util.Arrays;

/**
 * Created by gadzik on 12.07.20.
 */
public class MaxSumOfPairsWithDifferenceLessThanK {
    // https://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/

    static int maxSumPairWithDifferenceLessThanK(int arr[],
                                                 int N, int k) {
        int maxSum = 0;
        Arrays.sort(arr);

        for (int i = N - 1; i > 0; --i) {
            if (arr[i] - arr[i - 1] < k) {
                maxSum += arr[i];
                maxSum += arr[i - 1];
                --i;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int arr[] = {3, 5, 10, 15, 17, 12, 9};
        int N = arr.length;
        int K = 4;

        System.out.println(maxSumPairWithDifferenceLessThanK(
                arr, N, K));
    }
}
