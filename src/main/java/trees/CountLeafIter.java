package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 30.07.20.
 */
public class CountLeafIter {
    static int getLeafCount(Node node) {

        if (node == null) {
            return 0;
        }

        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.poll();

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            if (temp.left == null && temp.right == null) {
                count++;
            }
        }
        return count;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String[] args) {
            /*   1
                / \
               2   3
              / \
             4   5  */
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        System.out.println(getLeafCount(root));
    }
}
