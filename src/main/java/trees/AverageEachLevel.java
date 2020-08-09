package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 07.08.20.
 */
public class AverageEachLevel {
    // https://www.geeksforgeeks.org/averages-levels-binary-tree/
    static void averageOfLevels(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int sum = 0, count = 0;

        while (!q.isEmpty()) {
            sum = 0;
            count = 0;
            Queue<Node> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                Node node = q.peek();
                q.remove();
                sum += node.data;
                count++;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            q = temp;
            System.out.print((sum * 1.0 / count) + " ");
        }
    }

    /* Helper function that allocates a
    new node with the given data and
    NULL left and right pointers. */
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Driver code
    public static void main(String[] args) {
    /* Let us construct a Binary Tree
        4
    / \
    2 9
    / \ \
    3 5 7 */

        Node root = null;
        root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(9);
        root.left.left = newNode(3);
        root.left.right = newNode(5);
        root.right.right = newNode(7);
        System.out.println("Averages of levels : ");
        System.out.print("[");
        averageOfLevels(root);
        System.out.println("]");
    }
}
