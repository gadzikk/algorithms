package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenPostorder {
    // https://www.geeksforgeeks.org/flatten-binary-tree-in-order-of-post-order-traversal

    static Node prev;

    static Node flatten(Node parent) {
        Node dummy = new Node(-1);
        prev = dummy;
        postorder(parent);
        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;
        dummy = null;
        return ret;
    }

    static void postorder(Node curr) {
        if (curr == null) {
            return;
        }
        postorder(curr.left);
        postorder(curr.right);
        prev.left = null;
        prev.right = curr;
        prev = curr;
    }

    static void print(Node parent) {
        Node curr = parent;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        print(flatten(root));
    }
}
