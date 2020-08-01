package trees;

/**
 * Created by gadzik on 01.08.20.
 */
public class LeftmostRightmostFromPreorder {
    // https://www.geeksforgeeks.org/find-leftmost-and-rightmost-node-of-bst-from-its-given-preorder-traversal/

    static void LeftRightNode(int preorder[], int n) {
        // Variables for finding minimum
        // and maximum values of the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (min > preorder[i]) {
                min = preorder[i];
            }

            if (max < preorder[i]) {
                max = preorder[i];
            }
        }
        System.out.println("Leftmost node is " + min);
        System.out.println("Rightmost node is " + max);
    }

    // Driver Code
    public static void main(String[] args) {
        int preorder[] = {3, 2, 1, 5, 4};
        int n = 5;
        LeftRightNode(preorder, n);

    }
}
