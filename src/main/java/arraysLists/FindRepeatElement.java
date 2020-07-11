package arraysLists;

/**
 * Created by gadzik on 12.07.20.
 */
public class FindRepeatElement {
    // https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
    static int findRepeatingElement(int arr[], int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] != mid + 1) {
            if (mid > 0 && arr[mid] == arr[mid - 1]) {
                return mid;
            }

            return findRepeatingElement(arr, low, mid - 1);
        }

        return findRepeatingElement(arr, mid + 1, high);
    }

    // Driver method
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 4, 5};
        int index = findRepeatingElement(arr, 0, arr.length - 1);
        if (index != -1)
            System.out.println(arr[index]);
    }
}
