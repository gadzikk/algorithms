package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class GivenLevelMaxNode {
    // https://www.geeksforgeeks.org/find-the-maximum-node-at-a-given-level-in-a-binary-tree/

    static Node newNode(int val) {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = val;
        return temp;
    }


    static int maxAtLevel(Node root, int level) {
        if (root == null) {
            return 0;
        }

        if (level == 0) {
            return root.data;
        }

        int x = maxAtLevel(root.left, level - 1);
        int y = maxAtLevel(root.right, level - 1);

        // return maximum of two
        return Math.max(x, y);
    }

    public static void main(String args[]) {
        Node root = null;
        root = newNode(45);
        root.left = newNode(46);
        root.left.left = newNode(18);
        root.left.left.left = newNode(16);
        root.left.left.right = newNode(23);
        root.left.right = newNode(17);
        root.left.right.left = newNode(24);
        root.left.right.right = newNode(21);
        root.right = newNode(15);
        root.right.left = newNode(22);
        root.right.left.left = newNode(37);
        root.right.left.right = newNode(41);
        root.right.right = newNode(19);
        root.right.right.left = newNode(49);
        root.right.right.right = newNode(29);

        int level = 3;

        System.out.println(maxAtLevel(root, level));
    }
}
