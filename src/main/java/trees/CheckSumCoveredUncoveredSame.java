package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class CheckSumCoveredUncoveredSame {
    // https://www.geeksforgeeks.org/check-sum-covered-uncovered-nodes-binary-tree
    Node root;

    int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    int uncoveredSumLeft(Node node) {
        if (node.left == null && node.right == null) {
            return node.data;
        }

        if (node.left != null) {
            return node.data + uncoveredSumLeft(node.left);
        } else {
            return node.data + uncoveredSumLeft(node.right);
        }
    }

    int uncoveredSumRight(Node node) {
        if (node.left == null && node.right == null) {
            return node.data;
        }

        if (node.right != null) {
            return node.data + uncoveredSumRight(node.right);
        } else {
            return node.data + uncoveredSumRight(node.left);
        }
    }

    int uncoverSum(Node node) {
        int leftBound = 0;
        int rightBound = 0;

        if (node.left != null) {
            leftBound = uncoveredSumLeft(node.left);
        }
        if (node.right != null) {
            rightBound = uncoveredSumRight(node.right);
        }

        return node.data + leftBound + rightBound;
    }

    boolean isSumSame(Node root) {
        int sumUncovered = uncoverSum(root);
        int sumAll = sum(root);
        return (sumUncovered == (sumAll - sumUncovered));
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        CheckSumCoveredUncoveredSame tree = new CheckSumCoveredUncoveredSame();
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        if (tree.isSumSame(tree.root)) {
            System.out.println("Sum of covered and uncovered is same");
        } else {
            System.out.println("Sum of covered and uncovered is not same");
        }
    }
}
