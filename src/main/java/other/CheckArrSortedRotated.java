package other;

/**
 * Created by gadzik on 29.06.20.
 */
public class CheckArrSortedRotated {
// https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated-using-binary-search/?ref=leftbar-rightbar

    static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

       /* low + (high - low)/2; */
        int mid = (low + high) / 2;

        if (mid < high && arr[mid + 1] < arr[mid]) {
            return mid;
        }
        if (low < mid && arr[mid] < arr[mid - 1]) {
            return (mid - 1);
        }

        if (arr[mid] <= arr[low]) {
            return findPivot(arr, low, mid - 1);
        }

        return findPivot(arr, mid + 1, high);
    }

    public static boolean isRotated(int arr[], int n) {
        int l = 0;
        int r = n - 1;
        int pivot = -1;
        if (arr[r] < arr[l]) {
            pivot = findPivot(arr, l, r);

            // To check if the elements to the left of the pivot are in descending or not
            if (l < pivot) {
                while (l < pivot) {
                    if (arr[pivot] < arr[pivot - 1]) {
                        return false;
                    }
                    pivot--;
                }
            }

            // To check if the elements to the right of the pivot are in ascending or not
            else {
                pivot++;
                while (pivot < r) {
                    if (arr[pivot + 1] < arr[pivot]) {
                        return false;
                    }
                    pivot++;
                }
            }

            // If any of the above if or else is true Then the array is sorted rotated
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1, 2};
        System.out.println(isRotated(arr, 5));
    }
}
