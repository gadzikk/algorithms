package trees.trees_iterative;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class KthSmallestBST3 {
    // https://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/
    static int KSmallestUsingMorris(Node root, int k) {
        int count = 0;

        int ksmall = Integer.MIN_VALUE;
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) {
                    ksmall = curr.data;
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
                    count++;
                    if (count == k) {
                        ksmall = curr.data;
                    }
                    curr = curr.right;
                }
            }
        }
        return ksmall;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
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

    public static void main(String[] args) {
    /* Let us create following BST
            50
        /     \
        30     70
        / \ / \
    20 40 60 80 */
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        for (int k = 1; k <= 7; k++)
            System.out.print(KSmallestUsingMorris(root, k) + " ");

    }
}
