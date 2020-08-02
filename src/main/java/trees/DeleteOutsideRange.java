package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class DeleteOutsideRange {
    // https://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
    private static Node removeOutsideRange(Node root, int min, int max) {
        if (root == null) {
            return null;
        }

        root.left = removeOutsideRange(root.left, min, max);
        root.right = removeOutsideRange(root.right, min, max);

        if (root.data < min) {
            Node rchild = root.right;
            root = null;
            return rchild;
        }

        if (root.data > max) {
            Node lchild = root.left;
            root = null;
            return lchild;
        }

        return root;
    }

    public static Node newNode(int num) {
        Node temp = new Node();
        temp.data = num;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static Node insert(Node root,
                              int key) {
        if (root == null) {
            return newNode(key);
        }
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 6);
        root = insert(root, -13);
        root = insert(root, 14);
        root = insert(root, -8);
        root = insert(root, 15);
        root = insert(root, 13);
        root = insert(root, 7);

        System.out.print("Inorder Traversal of " + "the given tree is: ");
        inorderTraversal(root);
        root = removeOutsideRange(root, -10, 13);
        System.out.print("\nInorder traversal of " + "the modified tree: ");
        inorderTraversal(root);
    }
}
