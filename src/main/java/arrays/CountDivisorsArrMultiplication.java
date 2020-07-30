package arrays;

/**
 * Created by gadzik on 03.07.20.
 */
public class CountDivisorsArrMultiplication {
    // https://www.geeksforgeeks.org/count-divisors-array-multiplication/
    static int counDivisors(int X) {
        int count = 0;

        for (int i = 1; i <= X; ++i) {
            if (X % i == 0) {
                count++;
            }
        }
        return count;
    }

    static int countDivisorsMult(int arr[], int n) {
        int mul = 1;
        for (int i = 0; i < n; ++i)
            mul *= arr[i];

        return counDivisors(mul);
    }


    // Driver code
    public static void main(String[] args) {
        int arr[] = {2, 4, 6};
        int n = arr.length;
        System.out.println(countDivisorsMult(arr, n));
    }
}
