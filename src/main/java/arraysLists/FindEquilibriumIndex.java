package arraysLists;

/**
 * Created by gadzik on 12.07.20.
 */
public class FindEquilibriumIndex {
    // https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
    int equilibrium(int arr[], int n) {
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
        }

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum) {
                return i;
            }

            leftsum += arr[i];
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        FindEquilibriumIndex equi = new FindEquilibriumIndex();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr_size = arr.length;
        System.out.println("First equilibrium index is " +
                equi.equilibrium(arr, arr_size));
    }
}
