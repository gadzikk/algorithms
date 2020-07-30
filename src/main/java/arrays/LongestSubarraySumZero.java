package arrays;

import java.util.HashMap;

/**
 * Created by gadzik on 13.07.20.
 */
public class LongestSubarraySumZero {
    // https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
    static int maxLen(int arr[]) {
        HashMap<Integer, Integer> mapOfSum = new HashMap<>();
        int sum = 0;
        int max_len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0) {
                max_len = 1;
            }

            if (sum == 0) {
                max_len = i + 1;
            }

            // Look this sum in hash table
            Integer prev_i = mapOfSum.get(sum);

            // If this sum is seen before, then update max_len if required
            if (prev_i != null) {
                max_len = Math.max(max_len, i - prev_i);
            } else {// Else put this sum in hash table
                mapOfSum.put(sum, i);
            }
        }

        return max_len;
    }

    public static void main(String arg[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));
    }
}
