package trees;

/**
 * Created by gadzik on 02.08.20.
 */
public class HeightOfCompleteTree {
    // https://www.geeksforgeeks.org/height-complete-binary-tree-heap-n-nodes/
    static int height(int N) {
        return (int) Math.ceil(Math.log(N + 1) / Math.log(2)) - 1;
    }

    public static void main(String[] args) {
        int N = 6;
        System.out.println(height(N));
    }
}
