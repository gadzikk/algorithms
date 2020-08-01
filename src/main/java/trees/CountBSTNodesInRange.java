package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CountBSTNodesInRange {
    // https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
    Node root;

    int getCount(Node node, int low, int high) {

        if (node == null) {
            return 0;
        }

        if (node.data >= low && node.data <= high) {
            return 1 + this.getCount(node.left, low, high) + this.getCount(node.right, low, high);
        } else if (node.data < low) {
            return this.getCount(node.right, low, high);
        } else {
            return this.getCount(node.left, low, high);
        }
    }

    CountBSTNodesInRange() {
        root = null;
    }

    public static void main(String[] args) {
        CountBSTNodesInRange tree = new CountBSTNodesInRange();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       50
     /       /  \
    1       40   100   */
        int l = 5;
        int h = 45;
        System.out.println("Count of nodes between [" + l + ", " + h + "] is " + tree.getCount(tree.root, l, h));
    }
}
