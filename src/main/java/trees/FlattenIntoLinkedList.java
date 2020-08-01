package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenIntoLinkedList {
    // https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list-set-2/



// into linked list by altering the right nodeand making left node point to null
    static Node solution(Node A) {

        Stack<Node> st = new Stack<>();
        Node ans = A;

        while (A != null || st.size() != 0) {

            if (A.right != null) {
                st.push(A.right);
            }

            // Make the Right Left and
            // left null
            A.right = A.left;
            A.left = null;

            if (A.right == null && st.size() != 0) {
                A.right = st.peek();
                st.pop();
            }

            A = A.right;
        }
        return ans;
    }


    static Node newNode(int key) {
        Node node = new Node();
        node.data = key;
        node.left = node.right = null;
        return (node);
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
    /* 1
        / \
    2     5
    / \     \
    3 4     6 */

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(5);
        root.left.left = newNode(3);
        root.left.right = newNode(4);
        root.right.right = newNode(6);

        root = solution(root);
        System.out.print("The Inorder traversal after "                + "flattening binary tree ");
        inorder(root);
    }
}
