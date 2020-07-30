package arrays;

/**
 * Created by gadzik on 13.07.20.
 */
public class CountPairsInTwoSortedArrsMeetCond {
    // https://www.geeksforgeeks.org/count-pairs-two-sorted-arrays-whose-sum-equal-given-value-x/
    static int countPairs(int arr1[], int arr2[], int m, int n, int x) {
        int count = 0;
        int left = 0, right = n - 1;

        while (left < m && right >= 0) {

            if ((arr1[left] + arr2[right]) == x) {
                left++;
                right--;
                count++;
            }

            else if ((arr1[left] + arr2[right]) < x) {
                left++;
            }

            else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {2, 3, 5, 8};
        int m = arr1.length;
        int n = arr2.length;
        int x = 10;
        System.out.println("Count = "
                + countPairs(arr1, arr2, m, n, x));
    }
}
