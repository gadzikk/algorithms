package arraysLists;

/**
 * Created by gadzik on 30.06.20.
 */
public class BalancedMin {
    // https://www.geeksforgeeks.org/find-the-minimum-value-to-be-added-so-that-array-becomes-balanced/
    public static int minValueToBalance(int a[],
                                        int n)
    {
        int sum1 = 0;
        for (int i = 0; i < n / 2; i++)
            sum1 += a[i];

        int sum2 = 0;
        for (int i = n/2; i < n; i++)
            sum2 += a[i];

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 7, 1, 1, 3, 1};
        int n = 6;
        System.out.print(minValueToBalance(arr, n));
    }
}
