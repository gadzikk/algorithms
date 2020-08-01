package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class ConvertToSumTree {
    // https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
    Node root;

    int toSumTree(Node node) {
        if (node == null) {
            return 0;
        }

        int old_val = node.data;
        node.data = toSumTree(node.left) + toSumTree(node.right);
        return node.data + old_val;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        ConvertToSumTree tree = new ConvertToSumTree();

        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
        tree.toSumTree(tree.root);
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);
    }
}
