package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CheckSymmetric {
    // https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
    Node root;

    boolean isMirror(Node node1, Node node2) {

        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 != null && node1.data == node2.data) {
            return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
        }

        return false;
    }

    public static void main(String args[]) {
        CheckSymmetric tree = new CheckSymmetric();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.isMirror(tree.root, tree.root);
        if (output == true) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
