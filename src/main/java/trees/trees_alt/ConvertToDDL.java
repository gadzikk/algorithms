package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class ConvertToDDL {
    // https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
    Node root;
    /* This is the core function to convert Tree to list. This function
       follows steps 1 and 2 of the above algorithm */

    Node bintree2listUtil(Node node) {
        if (node == null) {
            return node;
        }

        if (node.left != null) {
            Node left = bintree2listUtil(node.left);
            for (; left.right != null; left = left.right) ;
            left.right = node;
            node.left = left;
        }

        if (node.right != null) {
            Node right = bintree2listUtil(node.right);
            for (; right.left != null; right = right.left) ;
            right.left = node;
            node.right = right;
        }

        return node;
    }


    Node bintree2list(Node node) {
        if (node == null) {
            return node;
        }

        node = bintree2listUtil(node);

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        ConvertToDDL tree = new ConvertToDDL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        Node head = tree.bintree2list(tree.root);
        tree.printList(head);
    }
}
