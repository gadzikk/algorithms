package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class KthSmallestBST {
    // https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
    static int count = 0;

    public static Node kthSmallest(Node root, int k) {

        if (root == null) {
            return null;
        }

        Node left = kthSmallest(root.left, k);

        if (left != null) {
            return left;
        }

        count++;
        if (count == k) {
            return root;
        }

        return kthSmallest(root.right, k);
    }

    public static void printKthSmallest(Node root, int k) {
        count = 0;

        Node res = kthSmallest(root, k);
        if (res == null) {
            System.out.println("There are less " + "than k nodes in the BST");
        } else {
            System.out.println("K-th Smallest" + " Element is " + res.data);
        }
    }

    public static Node insert(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }

        if (x < root.data) {
            root.left = insert(root.left, x);
        } else if (x > root.data) {
            root.right = insert(root.right, x);
        }

        return root;
    }

    public static void main(String[] args) {

        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};

        for (int x : keys) {
            root = insert(root, x);
        }

        int k = 3;
        printKthSmallest(root, k);
    }
}
