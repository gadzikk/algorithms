package trees;

/**
 * Created by gadzik on 09.08.20.
 */
public class CountLeafsNArr {
    // https://www.geeksforgeeks.org/determine-the-count-of-leaf-nodes-in-an-n-ary-tree/
    static int calcNodes(int N, int I) {
        int result = 0;
        result = I * (N - 1) + 1;
        return result;
    }

    public static void main(String[] args) {
        int N = 5, I = 2;
        System.out.println("Leaf nodes = " + calcNodes(N, I));
    }
}
