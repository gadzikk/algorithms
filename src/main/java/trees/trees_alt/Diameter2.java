package trees.trees_alt;

import zobjects.High;
import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class Diameter2 {
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    Node root;

    int diameterOpt(Node root, High height) {
        High leftHeight = new High();
        High rightHeight = new High();

        if (root == null) {
            height.height = 0;
            return 0;
        }

        int ldiameter = diameterOpt(root.left, leftHeight);
        int rdiameter = diameterOpt(root.right, rightHeight);

        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return Math.max(leftHeight.height + rightHeight.height + 1, Math.max(ldiameter, rdiameter));
    }

    /* A wrapper over diameter(Node root) */
    int diameter() {
        High height = new High();
        return diameterOpt(root, height);
    }

    static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        Diameter2 tree = new Diameter2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }
}
