package trees.trees_iterative;

import zobjects.Node;
import zobjects.SNode;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintSortedDataOfTwoBST {
// https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/


    static void merge(Node root1, Node root2) {
        SNode s1 = new SNode();
        Node current1 = root1;
        SNode s2 = new SNode();
        Node current2 = root2;
        if (root1 == null) {
            inorder(root2);
            return;
        }

        if (root2 == null) {
            inorder(root1);
            return;
        }

        while (current1 != null || !s1.isEmpty() || current2 != null || !s2.isEmpty()) {
            if (current1 != null || current2 != null) {
                if (current1 != null) {
                    s1.push(current1);
                    current1 = current1.left;
                }
                if (current2 != null) {
                    s2.push(current2);
                    current2 = current2.left;
                }

            } else {
                if (s1.isEmpty()) {
                    while (!s2.isEmpty()) {
                        current2 = s2.pop();
                        current2.left = null;
                        inorder(current2);
                    }
                    return;
                }
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        current1 = s1.pop();
                        current1.left = null;
                        inorder(current1);
                    }
                    return;
                }

                current1 = s1.pop();
                current2 = s2.pop();

                if (current1.data < current2.data) {
                    System.out.print(current1.data + " ");
                    current1 = current1.right;
                    s2.push(current2);
                    current2 = null;
                } else {
                    System.out.print(current2.data + " ");
                    current2 = current2.right;
                    s1.push(current1);
                    current1 = null;
                }
            }
        }
        System.out.println(s1.t);
        System.out.println(s2.t);
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root1 = null, root2 = null;

        /* Let us create the following tree as first tree
                3
            / \
            1 5
        */
        root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        /* Let us create the following tree as second tree
                4
            / \
            2 6
        */
        root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);

        merge(root1, root2);
    }
}
