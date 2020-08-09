package trees;

import zobjects.Node;

/**
 * Created by gadzik on 08.08.20.
 */
public class SwapAllLevelGreaterThanK {
    // https://www.geeksforgeeks.org/swap-nodes-binary-tree-every-kth-level/
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }


    static void swapEveryKLevelUtil(Node root, int level, int k) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if ((level + 1) % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        swapEveryKLevelUtil(root.left, level + 1, k);
        swapEveryKLevelUtil(root.right, level + 1, k);
    }

    static void swapEveryKLevel(Node root, int k) {
        swapEveryKLevelUtil(root, 1, k);
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
    /* 1
        / \
    2 3
    / / \
    4 7 8 */
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.right.right = newNode(8);
        root.right.left = newNode(7);

        int k = 2;
        System.out.println("Before swap node :");
        inorder(root);

        swapEveryKLevel(root, k);

        System.out.println("\nAfter swap Node :");
        inorder(root);
    }
}
