package trees;

import zobjects.Level;
import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class DeepestLeftLeafNode {
    // https://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
    Node root;
    Node result;

    void deepestLeftLeafUtil(Node node, int lvl, Level level, boolean isLeft) {

        if (node == null)
            return;

        if (isLeft && node.left == null && node.right == null && lvl > level.maxlevel) {
            result = node;
            level.maxlevel = lvl;
        }

        deepestLeftLeafUtil(node.left, lvl + 1, level, true);
        deepestLeftLeafUtil(node.right, lvl + 1, level, false);
    }

    void deepestLeftLeaf(Node node) {
        Level level = new Level();
        deepestLeftLeafUtil(node, 0, level, false);
    }

    public static void main(String[] args) {
        DeepestLeftLeafNode tree = new DeepestLeftLeafNode();
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

        tree.deepestLeftLeaf(tree.root);
        if (tree.result != null) {
            System.out.println("The deepest left child" + " is " + tree.result.data);
        } else {
            System.out.println("There is no left leaf in" + " the given tree");
        }
    }
}
