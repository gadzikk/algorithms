package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintOddNodesBST {
    // https://www.geeksforgeeks.org/print-all-odd-nodes-of-binary-search-tree

    static void oddNode(Node root) {
        if (root == null) {
            return;
        }

        oddNode(root.left);

        if (root.data % 2 != 0) {
            System.out.print(root.data + " ");
        }

        oddNode(root.right);
    }



    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public static void main(String[] args) {
    /* Let us create following BST
        5
    / \
    3 7
    / \ / \
    2 4 6 8 */
        Node root = null;
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 7);
        root = insert(root, 6);
        root = insert(root, 8);

        oddNode(root);

    }
}
