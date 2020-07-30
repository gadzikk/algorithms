package arrays;

/**
 * Created by gadzik on 08.07.20.
 */
public class MaxNoAdjElements {
    // https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
    int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;
            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }

    public static void main(String[] args) {
        MaxNoAdjElements sum = new MaxNoAdjElements();
//        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        int arr[] = new int[]{3, 2, 7, 10};

        System.out.println(sum.FindMaxSum(arr, arr.length));
    }
}
