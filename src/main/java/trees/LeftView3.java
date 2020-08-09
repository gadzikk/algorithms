package trees;

import zobjects.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gadzik on 07.08.20.
 */
public class LeftView3 {
    // https://www.techiedelight.com/print-left-view-of-binary-tree/
    public static void leftView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;

            while (i++ < size) {
                curr = queue.poll();

                if (i == 1) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftView(root);
    }
}
