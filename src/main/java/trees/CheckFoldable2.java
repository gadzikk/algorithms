package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CheckFoldable2 {
    // https://www.geeksforgeeks.org/foldable-binary-trees/
    Node root;

    /* Returns true if the given tree can be folded */
    boolean IsFoldable(Node node) {
        if (node == null)
            return true;

        return IsFoldableUtil(node.left, node.right);
    }

    boolean IsFoldableUtil(Node n1, Node n2) {

        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return IsFoldableUtil(n1.left, n2.right) && IsFoldableUtil(n1.right, n2.left);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        CheckFoldable2 tree = new CheckFoldable2();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.IsFoldable(tree.root)) {
            System.out.println("tree is foldable");
        } else {
            System.out.println("Tree is not foldable");
        }
    }
}
