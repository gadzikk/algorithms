package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class DepthDeepestOddLevelLeafNode {
    // https://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
    Node root;

    int depthOfOddLeafUtil(Node node, int level) {
        if (node == null) {
            return 0;
        }


        if (node.left == null && node.right == null && (level & 1) != 0) {
            return level;
        }

        return Math.max(depthOfOddLeafUtil(node.left, level + 1), depthOfOddLeafUtil(node.right, level + 1));
    }

    int depthOfOddLeaf(Node node) {
        int level = 1, depth = 0;
        return depthOfOddLeafUtil(node, level);
    }

    public static void main(String args[]) {
        int k = 45;
        DepthDeepestOddLevelLeafNode tree = new DepthDeepestOddLevelLeafNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.root.right.left.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);
        tree.root.right.right.right.right.left = new Node(11);
        System.out.println(tree.depthOfOddLeaf(tree.root) + " is the required depth");
    }
}
