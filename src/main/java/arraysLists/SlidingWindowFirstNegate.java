package arraysLists;

import java.util.LinkedList;

/**
 * Created by gadzik on 11.07.20.
 */
public class SlidingWindowFirstNegate {
    // https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
    static void printFirstNegativeInteger(int arr[], int n, int k) {
        // A Double Ended Queue, Di that will store indexes of useful array elements
        // for the current window of size k.  The useful elements are all negative integers.
        LinkedList<Integer> Di = new LinkedList<>();

        // Process first k (or first window) elements of array
        int i;
        for (i = 0; i < k; i++) {
            // Add current element at the rear of Di if it is a negative integer
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        // Process rest of the elements,   i.e., from arr[k] to arr[n-1]
        for ( ; i < n; i++) {
            // if Di is not empty then the element
            // at the front of the queue is the first
            // negative integer of the previous window
            if (!Di.isEmpty()) {
                System.out.print(arr[Di.peek()] + " ");
            }
                // else the window does not have a negative integer
            else {
                System.out.print("0" + " ");
            }

            // Remove the elements which are out of this window
            while ((!Di.isEmpty()) && Di.peek() < (i - k + 1)) {
                Di.remove(); // Remove from front of queue
            }

            // Add current element at the rear of Di if it is a negative integer
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        // Print the first negative integer of last window
        if (!Di.isEmpty()) {
            System.out.print(arr[Di.peek()] + " ");
        }
        else {
            System.out.print("0" + " ");
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
    }
}
