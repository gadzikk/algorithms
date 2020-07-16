package arraysLists.arr_binary_search;

/**
 * Created by gadzik on 11.07.20.
 */
public class FindIndexOfExtraInTwoSortedArrs {
    // https://www.geeksforgeeks.org/find-index-of-an-extra-element-present-in-one-sorted-array/
    static int findExtra(int arr1[], int arr2[], int n) {
        // Initialize result
        int index = n;

        // left and right are end  points denoting the current range.
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr2[mid] == arr1[mid]) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }

        // when right is greater than  left, search is complete.
        return index;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 4, 6, 8, 10, 12, 13};
        int arr2[] = {2, 4, 6, 8, 10, 12};
        int n = arr2.length;

        // Solve is passed both arrays
        System.out.println(findExtra(arr1, arr2, n));
    }
}
