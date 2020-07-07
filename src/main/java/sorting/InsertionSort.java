package sorting;

/**
 * Created by gadzik on 07.07.20.
 */
public class InsertionSort {

    static void insertionSort(int A[], int size)
    {
        int i, key, j;
        for (i = 1; i < size; i++)
        {
            key = A[i];
            j = i-1;

            while (j >= 0 && A[j] > key) {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }
    }
}
