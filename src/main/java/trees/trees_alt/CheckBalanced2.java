package trees.trees_alt;

import zobjects.High;
import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CheckBalanced2 {

    Node root;

    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(Node root, High height) {
        /* If tree is empty then return true */
        if (root == null) {
            height.height = 0;
            return true;
        }

        High lheight = new High();
        High rheight = new High();

        boolean leftBalanced = isBalanced(root.left, lheight);
        boolean rightBalanced = isBalanced(root.right, rheight);
        int leftHeight = lheight.height;
        int rightHeight = rheight.height;

        height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if (Math.abs(leftHeight - rightHeight) >= 2) {
            return false;
        } else {
            return leftBalanced && rightBalanced;
        }
    }

    public static void main(String args[]) {
        High height = new High();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        CheckBalanced2 tree = new CheckBalanced2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
