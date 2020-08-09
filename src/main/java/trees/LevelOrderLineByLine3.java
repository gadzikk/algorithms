package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 07.08.20.
 */
public class LevelOrderLineByLine3 {
    // https://www.geeksforgeeks.org/level-order-traversal-line-line-set-2-using-two-queues/
    static void levelOrder(Node root) {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();

        if (root == null) {
            return;
        }

        q1.add(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {

            while (!q1.isEmpty()) {
                if (q1.peek().left != null) {
                    q2.add(q1.peek().left);
                }

                if (q1.peek().right != null) {
                    q2.add(q1.peek().right);
                }

                System.out.print(q1.peek().data + " ");
                q1.remove();
            }
            System.out.println();

            while (!q2.isEmpty()) {

                if (q2.peek().left != null) {
                    q1.add(q2.peek().left);
                }

                if (q2.peek().right != null) {
                    q1.add(q2.peek().right);
                }

                System.out.print(q2.peek().data + " ");
                q2.remove();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        levelOrder(root);
    }
}
