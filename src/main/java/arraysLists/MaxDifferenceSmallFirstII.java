package arraysLists;

/**
 * Created by gadzik on 07.07.20.
 */
public class MaxDifferenceSmallFirstII {
    // https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
    static int maxDiff(int arr[], int n)
    {
        int maxDiff = -1;

        // Initialize max element from right side
        int maxRight = arr[n-1];

        for (int i = n-2; i >= 0; i--) {

            if (arr[i] > maxRight) {
                maxRight = arr[i];
            }

            else {
                int diff = maxRight - arr[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static void main (String[] args) {
        int arr[] = {1, 2, 90, 10, 110};
        int n = arr.length;

        System.out.println ("Maximum difference is " + maxDiff(arr, n));
    }
}
