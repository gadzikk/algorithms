package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class NodesHavingKLeaves {
    // https://www.geeksforgeeks.org/print-nodes-binary-tree-k-leaves/

    static int kLeaves(Node node, int k) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int total = kLeaves(node.left, k) + kLeaves(node.right, k);

        if (k == total) {
            System.out.print(node.data + " ");
        }

        return total;
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
        root.right = newNode(4);
        root.left.left = newNode(5);
        root.left.right = newNode(6);
        root.left.left.left = newNode(9);
        root.left.left.right = newNode(10);
        root.right.right = newNode(8);
        root.right.left = newNode(7);
        root.right.left.left = newNode(11);
        root.right.left.right = newNode(12);

        kLeaves(root, 2);

    }
}
