package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class Diameter {
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    Node root;

    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

    }

    /* A wrapper over diameter(Node root) */
    int diameter() {
        return diameter(root);
    }

    static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }
}
