package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class SumAndProductMaxMin {
    // https://www.geeksforgeeks.org/sum-and-product-of-maximum-and-minimum-element-in-binary-tree/
    static int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Return minimum of 3 values:
        // 1) Root's data 2) Max in Left Subtree
        // 3) Max in right subtree
        int res = root.data;
        int lres = findMin(root.left);
        int rres = findMin(root.right);
        if (lres < res) {
            res = lres;
        }
        if (rres < res) {
            res = rres;
        }
        return res;
    }

    // Function to returns maximum value
// in a given Binary Tree
    static int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int res = root.data;
        int lres = findMax(root.left);
        int rres = findMax(root.right);

        if (lres > res) {
            res = lres;
        }
        if (rres > res) {
            res = rres;
        }
        return res;
    }

    static int findSum(int max, int min) {
        return max + min;
    }

    static int findProduct(int max, int min) {
        return max * min;
    }

    public static void main(String[] args) {

        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);

        int max = findMax(root);
        int min = findMin(root);

        System.out.print("Sum of Maximum and Minimum element is " + findSum(max, min));
        System.out.print("\nProduct of Maximum and Minimum element is " + findProduct(max, min));
    }
}
