package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class CountTilt {
    // https://www.geeksforgeeks.org/tilt-binary-tree/
    static class T {
        int tilt = 0;
    }

    static int traverse(Node root, T t) {
        if (root == null)
            return 0;

        int left = traverse(root.left, t);
        int right = traverse(root.right, t);

        t.tilt += Math.abs(left - right);

        return left + right + root.data;
    }

    static int Tilt(Node root) {
        T t = new T();
        traverse(root, t);
        return t.tilt;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
    /* Let us construct a Binary Tree
        4
    / \
    2 9
    / \ \
    3 5 7 */

        Node root = null;
        root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(9);
        root.left.left = newNode(3);
        root.left.right = newNode(8);
        root.right.right = newNode(7);
        System.out.println("The Tilt of whole tree is " + Tilt(root));
    }
}
