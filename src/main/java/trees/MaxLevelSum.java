package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class MaxLevelSum {
    // https://www.geeksforgeeks.org/find-maximum-level-sum-in-binary-tree-using-recursion/
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static int maxLevel(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(maxLevel(root.left), maxLevel(root.right)));
    }

    static void maxLevelSum(Node root, int max_level, int sum[], int current) {
        if (root == null) {
            return;
        }

        sum[current] += root.data;
        maxLevelSum(root.left, max_level, sum, current + 1);
        maxLevelSum(root.right, max_level, sum, current + 1);
    }

    static int maxLevelSum(Node root) {
        int max_level = maxLevel(root);
        int sum[] = new int[max_level + 1];
        maxLevelSum(root, max_level, sum, 1);
        int maxSum = 0;
        for (int i = 1; i <= max_level; i++) {
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }

    // Driver code
    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.right = newNode(8);
        root.right.right.left = newNode(6);
        root.right.right.right = newNode(7);

    /* Constructed Binary tree is:
                1
            / \
            2 3
            / \ \
            4 5 8
                / \
                6 7 */

        System.out.println(maxLevelSum(root));
    }
}
