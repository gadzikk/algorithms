package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CountNonLeaf {
    // https://www.geeksforgeeks.org/count-non-leaf-nodes-binary-tree/

    static int countNonleaf(Node root) {

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return 1 + countNonleaf(root.left) + countNonleaf(root.right);
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return (node);
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        System.out.println(countNonleaf(root));
    }
}
