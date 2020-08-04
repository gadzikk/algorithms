package trees;

import zobjects.Node;

/**
 * Created by gadzik on 04.08.20.
 */
public class SuccessorPredecessorInorder {
    // https://algorithms.tutorialhorizon.com/inorder-predecessor-and-successor-in-binary-search-tree/
    static int successor, predecessor;

    public void successorPredecessor(Node root, int val) {
        if (root != null) {
            if (root.data == val) {
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp.data;
                }
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp.data;
                }
            } else if (root.data > val) {
                successor = root.data;
                successorPredecessor(root.left, val);
            } else if (root.data < val) {
                predecessor = root.data;
                successorPredecessor(root.right, val);
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(18);
        SuccessorPredecessorInorder i = new SuccessorPredecessorInorder();
        i.successorPredecessor(root, 10);
        System.out.println("Inorder Successor of 10 is : " + successor + " and predecessor is : " + predecessor);
        i.successorPredecessor(root, 30);
        System.out.println("Inorder Successor of 30 is : " + successor + " and predecessor is : " + predecessor);
    }
}
