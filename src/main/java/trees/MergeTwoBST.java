package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class MergeTwoBST {
    // https://leetcode.com/problems/merge-two-binary-trees/solution/

    public static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
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

        Node after = mergeTrees(root1, root2);
        inorder(after);
    }
}
