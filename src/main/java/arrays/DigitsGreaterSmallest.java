package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 08.07.20.
 */
public class DigitsGreaterSmallest {
    // https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void findNext(char ar[], int n) {
        int i;

        // I) Start from the getRightChildIndex most digit and find the first digit that is smaller than the digit next to it.
        for (i = n - 1; i > 0; i--) {
            if (ar[i - 1] < ar[i]) {
                break;
            }
        }

        // If no such digit is found, then all digits are in descending order means there cannot be a greater number with
        // same set of digits
        if (i == 0) {
            System.out.println("Not possible");
        } else {
            int beforeMinIndValue = ar[i - 1], minIndex = i;

            // II) Find the smallest digit on getRightChildIndex side of (i-1)'th digit that is greater than number[i-1]
            for (int j = i + 1; j < n; j++) {
                if (beforeMinIndValue < ar[j] && ar[j] < ar[minIndex]) {
                    minIndex = j;
                }
            }

            // III) Swap the above found smallest digit with number[i-1]
            swap(ar, i - 1, minIndex);

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++) {
                System.out.print(ar[i]);
            }
        }
    }

    public static void main(String[] args) {
        char digits[] = {'5', '3', '4', '9', '7', '6'};
        int n = digits.length;
        findNext(digits, n);
    }
}
