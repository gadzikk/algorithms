package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class DeepestNode2 {
    // https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void deepestNode(Node root, int levels) {
        if (root == null) {
            return;
        }

        if (levels == 1) {
            System.out.print(root.data + " ");
        } else if (levels > 1) {
            deepestNode(root.left, levels - 1);
            deepestNode(root.right, levels - 1);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);

        int levels = height(root);
        deepestNode(root, levels);
    }
}
