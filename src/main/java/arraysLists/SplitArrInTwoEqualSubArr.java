package arraysLists;

/**
 * Created by gadzik on 11.07.20.
 */
public class SplitArrInTwoEqualSubArr {
    static int findSplitPoint(int arr[], int n) {
        // traverse array element and compute sum of whole array
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            leftSum += arr[i];
        }

        int rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            // add current element to right_sum
            rightSum += arr[i];
            // exclude current element to the left_sum
            leftSum -= arr[i];

            if (rightSum == leftSum) {
                return i;
            }
        }

        // if it is not possible to split array
        return -1;
    }

    static void printTwoParts(int arr[], int n) {
        int splitPoint = findSplitPoint(arr, n);

        if (splitPoint == -1 || splitPoint == n) {
            System.out.println("Not Possible");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (splitPoint == i) {
                System.out.println();
            }

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 5};
        int n = arr.length;

        printTwoParts(arr, n);

    }

}
