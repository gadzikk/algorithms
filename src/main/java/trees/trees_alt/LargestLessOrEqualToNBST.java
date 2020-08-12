package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class LargestLessOrEqualToNBST {
    // https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/

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

    static int findMaxforN(Node root, int N) {

        if (root == null) {
            return -1;
        }
        if (root.data == N) {
            return N;
        } else if (root.data < N) {
            int k = findMaxforN(root.right, N);
            if (k == -1) {
                return root.data;
            } else {
                return k;
            }
        } else if (root.data > N) {
            return findMaxforN(root.left, N);
        }
        return -1;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        int N = 4;

        // creating following BST
    /*
                5
            / \
            2     12
        / \ / \
        1 3 9 21
                    / \
                    19 25 */
        Node root = null;
        root = insert(root, 25);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 12);
        insert(root, 9);
        insert(root, 21);
        insert(root, 19);
        insert(root, 25);

        System.out.println(findMaxforN(root, N));
    }
}
