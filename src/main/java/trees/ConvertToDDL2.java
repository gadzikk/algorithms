package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class ConvertToDDL2 {
    // https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
    static Node prev;

    static void fixPrevptr(Node root) {
        if (root == null) {
            return;
        }

        fixPrevptr(root.left);
        root.left = prev;
        prev = root;
        fixPrevptr(root.right);

    }

    static Node fixNextptr(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        while (root != null && root.left != null) {
            Node left = root.left;
            left.right = root;
            root = root.left;
        }

        return root;
    }

    static Node BTTtoDLL(Node root) {
        prev = null;
        fixPrevptr(root);
        return fixNextptr(root);
    }

    static void printlist(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        System.out.println("Inorder Tree Traversal");
        inorder(root);

        Node head = BTTtoDLL(root);

        System.out.println("\nDLL Traversal");
        printlist(head);
    }
}
