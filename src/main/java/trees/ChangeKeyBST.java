package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class ChangeKeyBST {
    // https://www.geeksforgeeks.org/how-to-implement-decrease-key-or-change-key-in-binary-search-tree/
    static Node root = null;

    static Node minValueNode(Node Node) {
        Node current = Node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.left == null) {
                Node temp = root.right;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                return temp;
            }

            Node temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    static Node changeKey(Node root, int oldVal, int newVal) {
        root = deleteNode(root, oldVal);
        root = insert(root, newVal);
        return root;
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
        if (node == null) return newNode(key);

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public static void main(String[] args) {
    /* Let us create following BST
            50
        / \
        30 70
        / \ / \
    20 40 60 80 */
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);


        System.out.println("Inorder traversal of the given tree");
        inorder(root);

        root = changeKey(root, 40, 10);

    /* BST is modified to
            50
        / \
        30 70
        / / \
    20 60 80
    /
    10 */
        System.out.println("\nInorder traversal of the modified tree ");
        inorder(root);
    }
}
