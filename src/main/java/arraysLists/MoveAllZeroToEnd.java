package arraysLists;

/**
 * Created by gadzik on 29.06.20.
 */
public class MoveAllZeroToEnd {
    // https://www.geeksforgeeks.org/move-zeroes-end-array/
    static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;  // Count of non-zero elements

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        while (count < n) {
            arr[count++] = 0;
        }
    }

    public static void main (String[] args)
    {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        pushZerosToEnd(arr, n);
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
