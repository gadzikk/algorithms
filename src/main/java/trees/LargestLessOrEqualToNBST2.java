package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class LargestLessOrEqualToNBST2 {
    // https://www.geeksforgeeks.org/largest-number-less-equal-n-bst-iterative-approach/

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    static int findFloor(Node root, int key) {
        Node curr = root, ans = null;
        while (curr != null) {
            if (curr.data <= key) {
                ans = curr;
                curr = curr.right;
            } else
                curr = curr.left;
        }

        if (ans != null) {
            return ans.data;
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 25;

        Node root = new Node();
        insert(root, 19);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 12);
        insert(root, 9);
        insert(root, 21);
        insert(root, 19);
        insert(root, 25);

        System.out.printf("%d", findFloor(root, N));
    }
}
