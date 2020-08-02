package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class LevelOrderTravesalReverseSpiral {
    // https://www.geeksforgeeks.org/reverse-level-order-traversal-in-spiral-form/
    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.max(lheight + 1, rheight + 1);
    }

    static void rightToLeft(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            rightToLeft(root.right, level - 1);
            rightToLeft(root.left, level - 1);
        }
    }

    static void leftToRight(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            leftToRight(root.left, level - 1);
            leftToRight(root.right, level - 1);
        }
    }

    static void reverseSpiral(Node root) {
        int flag = 1;
        int height = height(root);

        for (int i = height; i >= 1; i--) {
            if (flag == 1) {
                leftToRight(root, i);
                flag = 0;
            } else if (flag == 0) {
                rightToLeft(root, i);
                flag = 1;
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        reverseSpiral(root);
    }
}
