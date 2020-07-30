package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by gadzik on 01.07.20.
 */
public class ConvertReduced {
    // https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/
    public static void convert(int arr[], int n)
    {
        int temp[] = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> umap = new HashMap<>();

        int val = 0;
        for (int i = 0; i < n; i++) {
            umap.put(temp[i], val++);
        }

        // Convert array by taking positions from umap
        for (int i = 0; i < n; i++) {
            arr[i] = umap.get(arr[i]);
        }
    }

    public static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {10, 20, 15, 12, 11, 50};
        int n = arr.length;

        printArr(arr, n);
        convert(arr , n);
        printArr(arr, n);

    }
}
