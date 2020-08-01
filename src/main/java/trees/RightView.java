package trees;

import zobjects.MaxLevel;
import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class RightView {
    // https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
    Node root;
    MaxLevel max = new MaxLevel();

    // Recursive function to print right view of a binary tree.
    void rightViewUtil(Node node, int level, MaxLevel max_level) {
        if (node == null) {
            return;
        }

        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }

        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }

    void rightView() {
        rightView(root);
    }

    void rightView(Node node) {
        rightViewUtil(node, 1, max);
    }

    public static void main(String args[]) {
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        tree.rightView();

    }
}
