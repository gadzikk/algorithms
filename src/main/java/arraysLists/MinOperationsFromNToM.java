package arraysLists;

/**
 * Created by gadzik on 13.07.20.
 */
public class MinOperationsFromNToM {
    // https://www.geeksforgeeks.org/find-the-minimum-number-of-steps-to-reach-m-from-n/
    static int Minsteps(int n, int m) {
        int ans = 0;
        while (m > n) {
            if (m % 2 != 0) {
                m++;
                ans++;
            }

            m /= 2;
            ans++;
        }

        return ans + n - m;
    }

    public static void main(String[] args) {
        int n = 4, m = 6;

        System.out.println(Minsteps(n, m));
    }
}
