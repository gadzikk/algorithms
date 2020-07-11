package arraysLists;

/**
 * Created by gadzik on 08.07.20.
 */
public class KthSmallestQselect {
    // https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
    public static int partition(Integer[] arr, int left, int right) {
        int x = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= x) {
                // Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Swapping arr[i] and arr[getRightChildIndex]
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    // This function returns k'th smallest element
    // in arr[getLeftChildIndex..getRightChildIndex] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] arr, int left, int right, int k) {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= right - left + 1) {
            // Partition the array around last  element and get position of pivot element in sorted array
            int position = partition(arr, left, right);
            // If position is same as k
            if (position - left == k - 1)
                return arr[position];
            // If position is more, recur for getLeftChildIndex subarray
            if (position - left > k - 1)
                return kthSmallest(arr, left, position - 1, k);
            // Else recur for getRightChildIndex subarray
            return kthSmallest(arr, position + 1, right, k - position + left - 1);
        }
        // If k is more than number of elements  in array
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.print("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
    }
}
