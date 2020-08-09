package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class MirrorNode {
    static int findMirrorRec(int target, Node left, Node right) {
        if (left == null || right == null) {
            return 0;
        }

        if (left.data == target) {
            return right.data;
        }

        if (right.data == target) {
            return left.data;
        }

        int mirror_val = findMirrorRec(target, left.left, right.right);
        if (mirror_val != 0) {
            return mirror_val;
        }

        return findMirrorRec(target, left.right, right.left);
    }

    static int findMirror(Node root, int target) {
        if (root == null) {
            return 0;
        }
        if (root.data == target) {
            return target;
        }
        return findMirrorRec(target, root.left, root.right);
    }

    static Node newNode(int key) {
        Node n = new Node();
        n.data = key;
        n.left = null;
        n.right = null;
        return n;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.left.left = newNode(4);
        root.left.left.right = newNode(7);
        root.right = newNode(3);
        root.right.left = newNode(5);
        root.right.right = newNode(6);
        root.right.left.left = newNode(8);
        root.right.left.right = newNode(9);

        int target = root.left.left.data;
        int mirror = findMirror(root, target);

        if (mirror != 0) {
            System.out.println("Mirror of Node " + target + " is Node " + mirror);
        } else {
            System.out.println("Mirror of Node " + target + " is null ");
        }
    }
}
