package arraysLists;

/**
 * Created by gadzik on 12.07.20.
 */
public class PairMaxProductPositiveNegative {
    // https://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-integers/
    static void maxProduct(int arr[], int n) {
        if (n < 2) {
            System.out.println("No pairs exists");
            return;
        }

        if (n == 2) {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }

        int posa = Integer.MIN_VALUE;
        int posb = Integer.MIN_VALUE;

        int nega = Integer.MIN_VALUE;
        int negb = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            if (arr[i] > posa) {
                posb = posa;
                posa = arr[i];
            } else if (arr[i] > posb) {
                posb = arr[i];
            }

            if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(nega)) {
                negb = nega;
                nega = arr[i];
            } else if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negb)) {
                negb = arr[i];
            }
        }

        if (nega * negb > posa * posb) {
            System.out.println("Max product pair is {"
                    + nega + ", " + negb + "}");
        } else {
            System.out.println("Max product pair is {"
                    + posa + ", " + posb + "}");
        }
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 6, 7, 0};
        int n = arr.length;
        maxProduct(arr, n);

    }

}
