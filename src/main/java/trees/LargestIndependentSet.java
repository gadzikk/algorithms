package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class LargestIndependentSet {
    // https://www.geeksforgeeks.org/largest-independent-set-problem-dp-26/
    static int LISS(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate size excluding the current node
        int size_excl = LISS(root.left) + LISS(root.right);

        // Calculate size including the current node
        int size_incl = 1;
        if (root.left != null) {
            size_incl += LISS(root.left.left) + LISS(root.left.right);
        }
        if (root.right != null) {
            size_incl += LISS(root.right.left) + LISS(root.right.right);
        }

        // Return the maximum of two sizes
        return max(size_incl, size_excl);
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    public static void main(String args[]) {
        Node root = newNode(20);
        root.left = newNode(8);
        root.left.left = newNode(4);
        root.left.right = newNode(12);
        root.left.right.left = newNode(10);
        root.left.right.right = newNode(14);
        root.right = newNode(22);
        root.right.right = newNode(25);

        System.out.println("Size of the Largest" + " Independent Set is " + LISS(root));
    }

}
