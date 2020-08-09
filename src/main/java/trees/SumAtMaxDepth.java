package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class SumAtMaxDepth {
    // https://www.geeksforgeeks.org/sum-nodes-maximum-depth-binary-tree/
    static int sum = 0;
    static int max_level = Integer.MIN_VALUE;

    static Node createNode(int d) {
        Node node;
        node = new Node();
        node.data = d;
        node.left = null;
        node.right = null;
        return node;
    }

    static void sumOfNodesAtMaxDepth(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level > max_level) {
            sum = node.data;
            max_level = level;
        } else if (level == max_level) {
            sum = sum + node.data;
        }

        sumOfNodesAtMaxDepth(node.left, level + 1);
        sumOfNodesAtMaxDepth(node.right, level + 1);
    }

    public static void main(String[] args) {
        Node root;
        root = createNode(1);
        root.left = createNode(2);
        root.right = createNode(3);
        root.left.left = createNode(4);
        root.left.right = createNode(5);
        root.right.left = createNode(6);
        root.right.right = createNode(7);
        sumOfNodesAtMaxDepth(root, 0);
        System.out.println(sum);
    }
}
