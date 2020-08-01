package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CountBSTSubtreesInRange {
    // https://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
    static class INT {
        int a;
    }

    static boolean inRange(Node root, int low, int high) {
        return root.data >= low && root.data <= high;
    }

    static boolean getCountUtil(Node root, int low, int high, INT count) {
        if (root == null) {
            return true;
        }

        boolean l = getCountUtil(root.left, low, high, count);
        boolean r = getCountUtil(root.right, low, high, count);

        if (l && r && inRange(root, low, high)) {
            ++count.a;
            return true;
        }

        return false;
    }

    static INT getCount(Node root, int low, int high) {
        INT count = new INT();
        count.a = 0;
        getCountUtil(root, low, high, count);
        return count;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return (temp);
    }

    public static void main(String args[]) {
        Node root = newNode(10);
        root.left = newNode(5);
        root.right = newNode(50);
        root.left.left = newNode(1);
        root.right.left = newNode(40);
        root.right.right = newNode(100);
        /* Let us construct BST shown in above example
        10
        / \
    5 50
    / / \
    1 40 100 */
        int l = 5;
        int h = 45;
        System.out.println("Count of subtrees in [" + l + ", " + h + "] is " + getCount(root, l, h).a);
    }
}
