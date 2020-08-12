package trees.trees_iterative;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintKeysInRangeBST2 {
    // https://www.geeksforgeeks.org/print-bst-keys-in-given-range-o1-space/
    static void RangeTraversal(Node root, int n1, int n2) {
        if (root == null) {
            return;
        }

        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                if (curr.data <= n2 && curr.data >= n1) {
                    System.out.print(curr.data + " ");
                }

                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    if (curr.data <= n2 && curr.data >= n1) {
                        System.out.print(curr.data + " ");
                    }

                    curr = curr.right;
                }
            }
        }
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.right = null;
        temp.left = null;

        return temp;
    }

    public static void main(String[] args) {

    /* Constructed binary tree is
        4
        / \
    2     7
    / \ / \
    1 3 6 10
*/

        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(7);
        root.left.left = newNode(1);
        root.left.right = newNode(3);
        root.right.left = newNode(6);
        root.right.right = newNode(10);

        RangeTraversal(root, 4, 12);

    }
}
