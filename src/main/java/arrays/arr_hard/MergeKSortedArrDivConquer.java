package arrays.arr_hard;

/**
 * Created by gadzik on 11.07.20.
 */
public class MergeKSortedArrDivConquer {
    static int n = 4;

    // Function to perform merge operation
    static void merge(int left, int right, int[] output) {
        // To store the starting point of getLeftChildIndex and getRightChildIndex array
        int l_in = left * n;
        int r_in  = ((left + right) / 2 + 1) * n;

        // to store the size of getLeftChildIndex and getRightChildIndex array
        int l_c = ((left + right) / 2 - left + 1) * n;
        int r_c = (right - (left + right) / 2) * n;

        // array to temporarily store getLeftChildIndex and getRightChildIndex array
        int l_arr[] = new int[l_c];
        int r_arr[] = new int[r_c];

        // storing data in getLeftChildIndex array
        for (int i = 0; i < l_c; i++) {
            l_arr[i] = output[l_in + i];
        }
        // storing data in getRightChildIndex array
        for (int i = 0; i < r_c; i++) {
            r_arr[i] = output[r_in + i];
        }
        // to store the current index of temporary getLeftChildIndex and getRightChildIndex array
        int l_curr = 0;
        int r_curr = 0;
        // to store the current index for output array
        int in = l_in;
        // two pointer merge for two sorted arrays
        while (l_curr + r_curr < l_c + r_c) {
            if ( r_curr == r_c  || (l_curr != l_c  && l_arr[l_curr] < r_arr[r_curr])) {
                output[in] = l_arr[l_curr];
                l_curr++;
                in++;
            } else {
                output[in] = r_arr[r_curr];
                r_curr++;
                in++;
            }
        }
    }

    // Code to drive merge-sort and create recursion tree
    static void divide(int left, int right, int[] output,
                       int arr[][]) {
        if (left == right) {
            /* base step to initialize the output array before performing merge operation */
            for (int i = 0; i < n; i++){
                output[left * n + i] = arr[left][i];
            }
            return;
        }

        // to sort getLeftChildIndex half
        divide(left, (left + right) / 2, output, arr);
        // to sort getRightChildIndex half
        divide((left + right) / 2 + 1, right, output, arr);
        // merge the getLeftChildIndex and getRightChildIndex half
        merge(left, right, output);
    }

    public static void main(String[] args) {
        int arr[][] = {{5, 7, 15, 18},
                {1, 8, 9, 17},
                {1, 4, 7, 7}};
        // Number of arrays
        int k = arr.length;
        // Output array
        int[] output = new int[n * k];
        divide(0, k - 1, output, arr);
        // Print merged array
        for (int i = 0; i < n * k; i++){
            System.out.print(output[i] + " ");
        }

    }
}
