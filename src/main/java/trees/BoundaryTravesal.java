package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class BoundaryTravesal {
    // https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

    Node root;

    void printLeaves(Node node)
    {
        if (node == null) {
            return;
        }

        printLeaves(node.left);
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        printLeaves(node.right);
    }

    void printBoundaryLeft(Node node)
    {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }

    void printBoundaryRight(Node node)
    {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }

    void printBoundary(Node node)
    {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printBoundaryLeft(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printBoundaryRight(node.right);
    }

    public static void main(String args[])
    {
        BoundaryTravesal tree = new BoundaryTravesal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }
}
