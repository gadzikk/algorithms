package trees;

/**
 * Created by gadzik on 09.08.20.
 */
public class BSTOperationsDuplicates {
    // https://www.geeksforgeeks.org/how-to-handle-duplicates-in-binary-search-tree/
    static class Node {
        int key;
        int count;
        Node left, right;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        temp.count = 1;
        return temp;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + "(" + root.count + ") ");
            inorder(root.right);
        }
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key == node.key) {
            node.count++;
            return node;
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        return node;
    }

    static Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.count > 1) {
                root.count--;
                return root;
            }

            if (root.left == null) {
                Node temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            }

            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
        return root;
    }

    public static void main(String[] args) {
    /* Let us create following BST
            12(3)
        /     \
    10(2)     20(1)
    / \
    9(1) 11(1) */
        Node root = null;
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 9);
        root = insert(root, 11);
        root = insert(root, 10);
        root = insert(root, 12);
        root = insert(root, 12);

        System.out.print("Inorder traversal of " + "the given tree " + "\n");
        inorder(root);

        System.out.print("\nDelete 20\n");
        root = deleteNode(root, 20);
        System.out.print("Inorder traversal of " + "the modified tree \n");
        inorder(root);

        System.out.print("\nDelete 12\n");
        root = deleteNode(root, 12);
        System.out.print("Inorder traversal of " + "the modified tree \n");
        inorder(root);

        System.out.print("\nDelete 9\n");
        root = deleteNode(root, 9);
        System.out.print("Inorder traversal of " + "the modified tree \n");
        inorder(root);
    }
}
