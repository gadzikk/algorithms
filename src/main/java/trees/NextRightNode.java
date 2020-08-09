package trees;

import zobjects.Node;

/**
 * Created by gadzik on 08.08.20.
 */
public class NextRightNode {
    // https://www.geeksforgeeks.org/find-next-right-node-given-key-set-2/
    static class V {
        int level = 0;
    }

    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Node nextRightNode(Node root, int k, int level, V value) {
        if (root == null) {
            return null;
        }

        if (root.data == k) {
            value.level = level;
            return null;
        } else if (value.level != 0) {
            if (level == value.level) {
                return root;
            }
        }

        Node leftNode = nextRightNode(root.left, k, level + 1, value);

        if (leftNode != null) {
            return leftNode;
        }

        return nextRightNode(root.right, k, level + 1, value);
    }

    static Node nextRightNodeUtil(Node root, int k) {
        V v = new V();
        return nextRightNode(root, k, 1, v);
    }

    static void test(Node root, int k) {
        Node nr = nextRightNodeUtil(root, k);
        if (nr != null) {
            System.out.println("Next Right of " + k + " is " + nr.data);
        }
        else {
            System.out.println("No next right node found for " + k);
        }
    }

    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(2);
        root.right = newNode(6);
        root.right.right = newNode(5);
        root.left.left = newNode(8);
        root.left.right = newNode(4);

        test(root, 10);
        test(root, 2);
        test(root, 6);
        test(root, 5);
        test(root, 8);
        test(root, 4);
    }
}
