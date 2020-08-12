package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 09.08.20.
 */
public class DiagonalTravesal2 {
    // https://www.geeksforgeeks.org/iterative-diagonal-traversal-binary-tree/
    static void diagonalPrint(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while (q.size() > 0) {
            Node temp = q.peek();
            q.remove();

            if (temp == null) {
                if (q.size() == 0) {
                    return;
                }

                System.out.println();
                q.add(null);
            } else {
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    temp = temp.right;
                }
            }
        }
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String args[]) {
        Node root = newNode(8);
        root.left = newNode(3);
        root.right = newNode(10);
        root.left.left = newNode(1);
        root.left.right = newNode(6);
        root.right.right = newNode(14);
        root.right.right.left = newNode(13);
        root.left.right.left = newNode(4);
        root.left.right.right = newNode(7);
        diagonalPrint(root);
    }
}
