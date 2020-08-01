package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class VerticalWidth {
    // https://www.geeksforgeeks.org/width-binary-tree-set-1/

    static int maximum = 0, minimum = 0;

    static void lengthUtil(Node root, int curr) {
        if (root == null) {
            return;
        }

        lengthUtil(root.left, curr - 1);

        if (minimum > curr) {
            minimum = curr;
        }

        if (maximum < curr) {
            maximum = curr;
        }

        lengthUtil(root.right, curr + 1);
    }

    static int getLength(Node root) {
        maximum = 0;
        minimum = 0;
        lengthUtil(root, 0);

        // 1 is added to include root in the width
        return (Math.abs(minimum) + maximum) + 1;
    }

    // Utility function to create a new tree node
    static Node newNode(int data) {
        Node curr = new Node();
        curr.data = data;
        curr.left = curr.right = null;
        return curr;
    }

    // Driver Code
    public static void main(String[] args) {
        Node root = newNode(7);
        root.left = newNode(6);
        root.right = newNode(5);
        root.left.left = newNode(4);
        root.left.right = newNode(3);
        root.right.left = newNode(2);
        root.right.right = newNode(1);

        System.out.println(getLength(root));
    }
}
