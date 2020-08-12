package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 07.08.20.
 */
public class LeftView2 {
    // https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree/
    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Queue<Node> q;

    static void leftViewUtil(Node root) {
        if (root == null) {
            return;
        }

        q.add(root);
        q.add(null);

        while (q.size() > 0) {
            Node temp = q.peek();
            if (temp != null) {
                System.out.print(temp.data + " ");
                while (q.peek() != null) {

                    if (temp.left != null) {
                        q.add(temp.left);
                    }

                    if (temp.right != null) {
                        q.add(temp.right);
                    }

                    q.remove();
                    temp = q.peek();
                }
                q.add(null);
            }
            q.remove();
        }
    }

    static void leftView(Node root) {
        q = new LinkedList<Node>();
        leftViewUtil(root);
    }

    public static void main(String args[]) {
        Node root = newNode(10);
        root.left = newNode(12);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.right.left = newNode(5);
        root.right.left.right = newNode(6);
        root.right.left.right.left = newNode(18);
        root.right.left.right.right = newNode(7);

        leftView(root);
    }
}
