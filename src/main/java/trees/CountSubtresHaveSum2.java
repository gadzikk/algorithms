package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CountSubtresHaveSum2 {
    // https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
    static int count = 0;
    static Node ptr;

    int countSubtreesWithSumXUtil(Node node, int x) {
        int left = 0, right = 0;

        if (node == null) {
            return 0;
        }

        left += countSubtreesWithSumXUtil(node.left, x);
        right += countSubtreesWithSumXUtil(node.right, x);

        if (left + right + node.data == x) {
            count++;
        }

        if (ptr != node) {
            return left + node.data + right;
        }

        return count;
    }

    public static void main(String[] args) {
        /* binary tree creation
            5
        / \
        -10 3
        / \ / \
        9 8 -4 7
        */
        Node init = new Node(5);
        init.left = new Node(-10);
        init.right = new Node(3);
        init.left.left = new Node(9);
        init.left.right = new Node(8);
        init.right.left = new Node(-4);
        init.right.right = new Node(7);
        int x = 7;
        ptr = init; // assigning global value of ptr
        System.out.println("Count = " + new CountSubtresHaveSum2().countSubtreesWithSumXUtil(init, x));
    }
}
