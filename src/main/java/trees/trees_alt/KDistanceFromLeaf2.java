package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromLeaf2 {
    // https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
    Node root;

    int printKDistantfromLeaf(Node node, int k) {
        if (node == null) {
            return -1;
        }
        int leftDistance = printKDistantfromLeaf(node.left, k);
        int rightDistance = printKDistantfromLeaf(node.right, k);
        boolean isLeaf = leftDistance == -1 && leftDistance == rightDistance;
        if (leftDistance == 0 || rightDistance == 0 || (isLeaf && k == 0)) {
            System.out.print(" " + node.data);
        }
        if (isLeaf && k > 0) {
            return k - 1; // leaf node
        }
        if (leftDistance > 0 && leftDistance < k) {
            return leftDistance - 1; // parent of left leaf
        }
        if (rightDistance > 0 && rightDistance < k) {
            return rightDistance - 1; // parent of right leaf
        }

        return -2;
    }

    public static void main(String args[]) {
        KDistanceFromLeaf2 tree = new KDistanceFromLeaf2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 2 are :");
        tree.printKDistantfromLeaf(tree.root, 2);
    }
}
