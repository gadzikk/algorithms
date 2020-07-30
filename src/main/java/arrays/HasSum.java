package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 01.07.20.
 */
public class HasSum {
    // https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
    static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
        int l, r;

        Arrays.sort(A);

        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum){
                l++;
            }
            else { // A[l] + A[j] > sum
                r--;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int A[] = { 1, 4, 45, 6, 10, -8 };
        int n = 16;
        int arr_size = A.length;

        if (hasArrayTwoCandidates(A, arr_size, n))
            System.out.println("Array has two "
                    + "elements with given sum");
        else
            System.out.println("Array doesn't have "
                    + "two elements with given sum");
    }
}
