package trees;

/**
 * Created by gadzik on 07.08.20.
 */
public class AncestorNode {
    // https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/

    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    Node root;

    boolean printAncestors(Node node, int target) {
        if (node == null) {
            return false;
        }

        if (node.data == target) {
            return true;
        }

        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        AncestorNode tree = new AncestorNode();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);

    }
}
