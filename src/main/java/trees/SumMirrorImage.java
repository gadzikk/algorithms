package trees;

import zobjects.Node;

/**
 * Created by gadzik on 08.08.20.
 */
public class SumMirrorImage {
    // https://www.geeksforgeeks.org/sum-of-the-mirror-image-nodes-of-a-complete-binary-tree-in-an-inorder-way/
    static void printInorder(Node rootL, Node rootR) {
        if (rootL.left == null && rootR.right == null) {
            return;
        }

        printInorder(rootL.right, rootR.right);
        System.out.println(rootL.left.data + rootR.right.data);
        printInorder(rootL.right, rootR.left);
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(23);
        root.right = new Node(28);
        root.left.left = new Node(4);
        root.left.right = new Node(11);
        root.right.left = new Node(8);
        root.right.right = new Node(16);

        printInorder(root, root);

        if (root != null) {
            System.out.println(root.data * 2);
        }

    }
}
