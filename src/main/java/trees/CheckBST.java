package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class CheckBST {
    // https://www.geeksforgeeks.org/check-if-a-binary-tree-is-bst-simple-and-efficient-approach/
    static boolean isBSTUtil(Node root, int prev) {
        if (root != null) {

            if (!isBSTUtil(root.left, prev)) {
                return false;
            }

            if (root.data <= prev) {
                return false;
            }

            prev = root.data;
            return isBSTUtil(root.right, prev);
        }

        return true;
    }

    static boolean isBST(Node root) {
        int prev = Integer.MIN_VALUE;
        return isBSTUtil(root, prev);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        if (isBST(root)) {
            System.out.print("Is BST");
        } else {
            System.out.print("Not a BST");
        }
    }
}
