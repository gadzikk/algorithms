package arraysLists;

/**
 * Created by gadzik on 08.07.20.
 */
public class KthSmallestQselectII {
    // This function returns k'th smallest element in arr[getLeftChildIndex..getRightChildIndex]
    // using QuickSort based method.  ASSUMPTION: ALL ELEMENTS
    // IN ARR[] ARE DISTINCT
    int kthSmallest(int arr[], int left, int right, int k) {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= right - left + 1) {
            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int position = randomPartition(arr, left, right);
            // If position is same as k
            if (position - left == k - 1) {
                return arr[position];
            }
            // If position is more, recur for getLeftChildIndex subarray
            if (position - left > k - 1) {
                return kthSmallest(arr, left, position - 1, k);
            }
            // Else recur for getRightChildIndex subarray
            return kthSmallest(arr, position + 1, right, k - position + left - 1);
        }
        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process of QuickSort().  It considers
    // the last element as pivot and moves all smaller element
    // to getLeftChildIndex of it and greater elements to getRightChildIndex. This function
    // is used by randomPartition()
    int partition(int arr[], int left, int right) {
        int x = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    // Picks a random pivot element between getLeftChildIndex and getRightChildIndex and
    // partitions arr[getLeftChildIndex..getRightChildIndex] arount the randomly picked
    // element using partition()
    int randomPartition(int arr[], int left, int right) {
        int n = right - left + 1;
        int pivot = (int) (Math.random()) * (n - 1);
        swap(arr, left + pivot, right);
        return partition(arr, left, right);
    }

    // Driver method to test above
    public static void main(String args[]) {
        KthSmallestQselectII ob = new KthSmallestQselectII();
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length, k = 3;
        System.out.println("K'th smallest element is " +
                ob.kthSmallest(arr, 0, n - 1, k));
    }
}
