package arrays.arr_binary_search;

/**
 * Created by gadzik on 17.06.20.
 */
public class SearchInSortedRotatedArray {
    // https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/?ref=lbp

    static int pivotedBinarySearch(int arr[], int n, int key)
    {
        int pivot = findPivot(arr, 0, n-1);

        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n-1, key);

        // If we found a pivot, then first compare with pivot and then search in two subarrays around pivot
        if (arr[pivot] == key) {
            return pivot;
        }

        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot-1, key);
        }

        return binarySearch(arr, pivot+1, n-1, key);
    }

    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

       /* low + (high - low)/2; */
        int mid = (low + high)/2;

        if (mid < high && arr[mid + 1] < arr[mid]) {
            return mid;
        }
        if (low < mid && arr[mid] < arr[mid - 1]) {
            return (mid-1);
        }

        if (arr[mid] <= arr[low]) {
            return findPivot(arr, low, mid-1);
        }

        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

       /* low + (high - low)/2; */
        int mid = (low + high)/2;

        if (key == arr[mid]) {
            return mid;
        }

        if (arr[mid] < key) {
            return binarySearch(arr, (mid + 1), high, key);
        }

        return binarySearch(arr, low, (mid -1), key);
    }

    public static void main(String args[])
    {
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
    }
}
