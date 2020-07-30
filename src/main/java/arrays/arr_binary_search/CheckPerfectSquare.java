package arrays.arr_binary_search;

/**
 * Created by gadzik on 29.06.20.
 */
public class CheckPerfectSquare {
    // https://www.geeksforgeeks.org/check-if-a-given-number-is-a-perfect-square-using-binary-search/?ref=leftbar-rightbar
    static int checkPerfectSquare(long N, long start, long last) {
        long mid = (start + last) / 2;

        if (last < start) {
            return -1;
        }

        // Check if we got the number which is square root of the perfect square number N
        if (mid * mid == N) {
            return (int) mid;
        }
        // If the square(mid) is greater than N it means only lower values then mid will be possibly the square root of N
        else if (N < mid * mid) {
            return checkPerfectSquare(N, start,mid - 1);
        }

        // If the square(mid) is less than N it means only higher values then mid will be possibly the square root of N
        return checkPerfectSquare(N, mid + 1, last);
    }

    public static void main(String[] args) {
        long N = 65;
        System.out.println(checkPerfectSquare(N, 1, N));
    }
}
