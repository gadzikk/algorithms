package trees;

import zobjects.Node;

/**
 * Created by gadzik on 04.08.20.
 */
public class ExtremeNodesAlternateOrder {
    // https://www.geeksforgeeks.org/recursive-program-to-print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/?ref=rp
    static class INT {
        int count;
    }


    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.max(lheight, rheight) + 1;
    }

    static void rightToLeft(Node root, int level, INT counter) {
        if (root == null) {
            return;
        }

        if (level == 1 && counter.count == 0) {
            System.out.printf("%d ", root.data);
            counter.count = 1;
        } else if (level > 1) {
            rightToLeft(root.right, level - 1, counter);
            rightToLeft(root.left, level - 1, counter);
        }
    }

    static void leftToRight(Node root, int level, INT counter) {
        if (root == null) {
            return;
        }

        if (level == 1 && counter.count == 1) {
            System.out.printf("%d ", root.data);
            counter.count = 0;
        } else if (level > 1) {
            leftToRight(root.left, level - 1, counter);
            leftToRight(root.right, level - 1, counter);
        }
    }

    static void printExtremeNodes(Node root) {
        int height = height(root);
        int flag = 0;
        INT counter = new INT();
        counter.count = 0;

        for (int i = 1; i <= height; i++) {
            if (flag == 0) {
                rightToLeft(root, i, counter);
                flag = 1;
            } else if (flag == 1) {
                leftToRight(root, i, counter);
                flag = 0;
            }
        }
        return;
    }

    public static void main(String args[]) {
        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.right = newNode(7);

        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        root.left.right.left = newNode(10);
        root.left.right.right = newNode(11);
        root.right.right.left = newNode(14);
        root.right.right.right = newNode(15);

        root.left.left.left.left = newNode(16);
        root.left.left.left.right = newNode(17);
        root.right.right.right.right = newNode(31);

        printExtremeNodes(root);

    }
}
