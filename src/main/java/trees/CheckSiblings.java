package trees;

import zobjects.Node;

/**
 * Created by gadzik on 06.08.20.
 */
public class CheckSiblings {
    // https://algorithms.tutorialhorizon.com/in-a-binary-tree-check-if-two-nodes-has-the-same-parent-or-are-siblings/
    public boolean sameParents(Node root, Node x, Node y) {
        if (root == null) {
            return false;
        }

        return ((root.left == x && root.right == y) || root.left == y && root.right == x || sameParents(root.left, x, y) || sameParents(root.right, x, y));
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(1);
        Node x1 = new Node(2);
        Node y1 = new Node(3);
        root.left = x1;
        root.right = y1;
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        Node x2 = new Node(7);
        Node y2 = new Node(9);
        root.right.left.left = new Node(8);
        root.right.left.right = y2;
        root.left.left.left = x2;

        CheckSiblings i = new CheckSiblings();
        System.out.println("Node " + x1.data + " and Node " + y1.data + " are siblings??? " + i.sameParents(root, x1, y1));
        System.out.println("Node " + x2.data + " and Node " + y2.data + " are siblings??? " + i.sameParents(root, x2, y2));
    }
}
