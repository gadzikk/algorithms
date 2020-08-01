package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class SumAllLeafs {
    // https://www.geeksforgeeks.org/sum-leaf-nodes-binary-tree/
    static int sum;

    static void leafSum(Node root) {
        if (root == null)
            return;

        // add root data to sum if
        // root is a leaf node
        if (root.left == null && root.right == null) {
            sum += root.data;
        }

        leafSum(root.left);
        leafSum(root.right);
    }

    // driver program
    public static void main(String args[]) {
        //construct binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);

        // variable to store sum of leaf nodes
        sum = 0;
        leafSum(root);
        System.out.println(sum);
    }
}
