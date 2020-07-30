package arrays.arr_formula;

/**
 * Created by gadzik on 12.07.20.
 */
public class NumberOfPairsProductGrThanSum {
    // https://www.geeksforgeeks.org/number-pairs-array-product-greater-sum/
    static int countPairs(int arr[], int n) {
        int twoCount = 0, greaterThanTwo = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2) {
                twoCount++;
            } else if (arr[i] > 2) {
                greaterThanTwo++;
            }
        }
        return twoCount * greaterThanTwo + (greaterThanTwo * (greaterThanTwo - 1)) / 2;
    }

    public static void main(String args[]) {
        int arr[] = {3, 4, 5};
        int n = arr.length;
        System.out.println(countPairs(arr, n));
    }
}
