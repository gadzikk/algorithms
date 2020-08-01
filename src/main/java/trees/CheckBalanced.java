package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CheckBalanced {
    // https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
    Node root;

    boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }

        return false;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String args[]) {
        CheckBalanced tree = new CheckBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
