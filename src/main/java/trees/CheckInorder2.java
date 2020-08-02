package trees;

import java.util.Stack;

/**
 * Created by gadzik on 02.08.20.
 */
public class CheckInorder2 {
    // https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
    boolean canRepresentBST(int pre[], int n) {
        Stack<Integer> s = new Stack<>();

        int root = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre[i] < root) {
                return false;
            }

            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }

            s.push(pre[i]);
        }
        return true;
    }

    public static void main(String args[]) {
        CheckInorder2 bst = new CheckInorder2();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
