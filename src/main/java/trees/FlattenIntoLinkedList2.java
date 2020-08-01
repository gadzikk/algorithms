package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenIntoLinkedList2 {
    // https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list-set-3/


    static Node last = null;

    static void FlattenBinaryTree(Node root) {
        if (root == null) {
            return;
        }

        Node left = root.left;
        Node right = root.right;

        // Avoid first iteration where root is the only node in the list
        if (root != last) {
            last.right = root;
            last.left = null;
            last = root;
        }

        FlattenBinaryTree(left);
        FlattenBinaryTree(right);

        if (left == null && right == null) {
            last = root;
        }
    }

    static Node AllocNode(int data) {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = data;
        return temp;
    }

    static void PrintInorderBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        PrintInorderBinaryTree(root.left);
        System.out.print(root.data + " ");
        PrintInorderBinaryTree(root.right);
    }

    public static void main(String args[]) {
        Node root = AllocNode(1);
        root.left = AllocNode(2);
        root.left.left = AllocNode(3);
        root.left.right = AllocNode(4);
        root.right = AllocNode(5);
        root.right.right = AllocNode(6);

        System.out.print("Original inorder traversal : ");
        PrintInorderBinaryTree(root);
        System.out.println();

        last = root;
        FlattenBinaryTree(root);

        System.out.print("Flattened inorder traversal : ");
        PrintInorderBinaryTree(root);
        System.out.println();

    }
}
