package arrays.arr_binary_search;

/**
 * Created by gadzik on 08.07.20.
 */
public class FindClosestElement {
    // https://www.geeksforgeeks.org/split-the-given-array-into-k-sub-arrays-such-that-maximum-sum-of-all-sub-arrays-is-minimum/
    public static int findClosest(int arr[], int target) {
        int n = arr.length;

        if (target <= arr[0]) {
            return arr[0];
        }

        if (target >= arr[n - 1]) {
            return arr[n - 1];
        }


        // Doing binary search
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            /* If target is less than array element, then search in left */
            if (target < arr[mid]) {
                // If target is greater than previous to mid, return closest of two
                if (0 < mid && arr[mid - 1] < target) {
                    return getClosest(arr[mid - 1], arr[mid], target);
                }
                /* Repeat for left half */
                j = mid;
            }
            // If target is greater than mid
            else {
                if (mid < n - 1 && target < arr[mid + 1]){
                    return getClosest(arr[mid], arr[mid + 1], target);
                }
                i = mid + 1;
            }
        }

        // Only single element left after search
        return arr[mid];
    }

    // Method to compare which one is the more close find the closest by taking the difference
    //  between the target and both values. It assumes that val2 is greater than val1 and target lies between these two.
    public static int getClosest(int val1, int val2, int target) {
        if (val2 - target <= target - val1) {
            return val2;
        } else {
            return val1;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 6, 6, 8, 9};
        int target = 11;
        System.out.println(findClosest(arr, target));
    }
}
