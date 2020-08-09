package trees;

import zobjects.Node;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromTarget {
    // https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
    Node root;

    void printkdistanceNodeDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data);
            System.out.println("");
            return;
        }

        printkdistanceNodeDown(node.left, k - 1);
        printkdistanceNodeDown(node.right, k - 1);
    }

    int printkdistanceNode(Node node, Node target, int k) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            printkdistanceNodeDown(node, k);
            return 0;
        }

        int distanceLeft = printkdistanceNode(node.left, target, k);

        if (distanceLeft != -1) {
            if (distanceLeft + 1 == k) {
                System.out.print(node.data);
                System.out.println("");
            } else {
                printkdistanceNodeDown(node.right, k - distanceLeft - 2);
            }

            return 1 + distanceLeft;
        }

        int distanceRight = printkdistanceNode(node.right, target, k);
        if (distanceRight != -1) {
            if (distanceRight + 1 == k) {
                System.out.print(node.data);
                System.out.println("");
            } else {
                printkdistanceNodeDown(node.left, k - distanceRight - 2);
            }
            return 1 + distanceRight;
        }

        return -1;
    }

    public static void main(String args[]) {
        KDistanceFromTarget tree = new KDistanceFromTarget();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printkdistanceNode(tree.root, target, 2);
    }
}
