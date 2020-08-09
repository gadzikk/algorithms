package trees;

import zobjects.Node;
import zobjects.Res;

/**
 * Created by gadzik on 08.08.20.
 */
public class MaxDiffNodeAncestor {
    // https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
    Node root;

    int maxDiffUtil(Node node, Res result) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int val = Math.min(maxDiffUtil(node.left, result), maxDiffUtil(node.right, result));
        result.val = Math.max(result.val, node.data - val);

        return Math.min(val, node.data);
    }

    int maxDiff(Node root) {
        Res result = new Res();
        maxDiffUtil(root, result);

        return result.val;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + "");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        MaxDiffNodeAncestor tree = new MaxDiffNodeAncestor();

        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.maxDiff(tree.root));
    }
}
