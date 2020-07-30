package arrays;

import java.util.HashMap;

/**
 * Created by gadzik on 13.07.20.
 */
public class FindSingleNumberOccuringOddTimes {
    // https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
    static int getOddOccurrence(int arr[], int n) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hmap.containsKey(arr[i])) {
                int val = hmap.get(arr[i]);
                hmap.put(arr[i], val + 1);
            } else {
                hmap.put(arr[i], 1);
            }
        }

        for (Integer a : hmap.keySet()) {
            if (hmap.get(a) % 2 != 0) {
                return a;
            }
        }
        return -1;
    }

    static int getOddOccurrenceSimpler(int ar[], int ar_size) {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++) {
            res = res ^ ar[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = arr.length;
        System.out.println(getOddOccurrence(arr, n));
    }
}
