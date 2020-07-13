package arraysLists;

/**
 * Created by gadzik on 13.07.20.
 */
public class MaxRow {
    static int ROWS = 4, COLS = 4;

    static int first(int arr[], int low, int high) {
        if (high >= low) {
            // Get the middle index
            int mid = low + (high - low) / 2;

            // Check if the element at middle index is first 1
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) {
                return mid;
            }
                // If the element is 0, recur for right side
            else if (arr[mid] == 0) {
                return first(arr, (mid + 1), high);
            }

            // If element is not first 1, recur for left side
            else {
                return first(arr, low, (mid - 1));
            }
        }
        return -1;
    }

    // Function that returns index of row with maximum number of 1s.
    static int rowWithMax1s(int mat[][]) {
        int max_row_index = 0, max = -1;

        // Traverse for each row and count number of  1s by finding the index of first 1
        int i, index;
        for (i = 0; i < ROWS; i++) {
            index = first(mat[i], 0, COLS - 1);
            if (index != -1 && max < COLS - index) {
                max = COLS - index;
                max_row_index = i;
            }
        }

        return max_row_index;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println("Index of row with maximum 1s is "
                + rowWithMax1s(mat));
    }
}
