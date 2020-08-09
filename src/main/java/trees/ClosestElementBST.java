package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class ClosestElementBST {
    // https://www.geeksforgeeks.org/find-closest-element-binary-search-tree/

    static int min_diff, min_diff_key;

    static void maxDiffUtil(Node node, int k) {
        if (node == null)
            return;

        if (node.data == k) {
            min_diff_key = k;
            return;
        }

        if (min_diff > Math.abs(node.data - k)) {
            min_diff = Math.abs(node.data - k);
            min_diff_key = node.data;
        }

        // if k is less than node.key then move in
        // left subtree else in right subtree
        if (k < node.data) {
            maxDiffUtil(node.left, k);
        } else {
            maxDiffUtil(node.right, k);
        }
    }

    // Wrapper over maxDiffUtil()
    static int maxDiff(Node root, int k) {
        min_diff = 999999999;
        min_diff_key = -1;
        maxDiffUtil(root, k);
        return min_diff_key;
    }

    static Node newnode(int key) {

        Node node = new Node();
        node.data = key;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String args[]) {
        Node root = newnode(9);
        root.left = newnode(4);
        root.right = newnode(17);
        root.left.left = newnode(3);
        root.left.right = newnode(6);
        root.left.right.left = newnode(5);
        root.left.right.right = newnode(7);
        root.right.right = newnode(22);
        root.right.right.left = newnode(20);
        int k = 18;
        System.out.println(maxDiff(root, k));

    }
}
