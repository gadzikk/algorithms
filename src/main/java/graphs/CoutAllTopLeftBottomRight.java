package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class CoutAllTopLeftBottomRight {
    // https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
    static int numberOfPaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    }

    public static void main(String args[]) {
        System.out.println(numberOfPaths(3, 3));
    }
}
