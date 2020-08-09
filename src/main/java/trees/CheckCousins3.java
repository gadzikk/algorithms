package trees;

import zobjects.Node;

/**
 * Created by gadzik on 06.08.20.
 */
public class CheckCousins3 {
    // https://algorithms.tutorialhorizon.com/in-a-binary-tree-check-if-two-nodes-are-cousins/
    public boolean areCousins(Node root, Node x, Node y) {
        if (getHeight(root, x, 1) != getHeight(root, y, 1)) {
            return false;
        } else {
            if (sameParents(root, x, y) == false) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int getHeight(Node root, Node x, int height) {
        if (root == null) {
            return 0;
        }
        if (root == x) {
            return height;
        }

        int level = getHeight(root.left, x, height + 1);
        if (level != 0) {
            return level;
        }
        return getHeight(root.right, x, height + 1);
    }

    public boolean sameParents(Node root, Node x, Node y) {
        if (root == null) {
            return false;
        }
        return ((root.left == x && root.right == y) || (root.left == y && root.right == x)
                || sameParents(root.left, x, y) || sameParents(root.right, x, y));
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

        CheckCousins3 i = new CheckCousins3();
        System.out.println("Node " + x1.data + " and Node " + y1.data + " are cousins??? " + i.areCousins(root, x1, y1));
        System.out.println("Node " + x2.data + " and Node " + y2.data + " are cousins??? " + i.areCousins(root, x2, y2));
    }
}
