package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 01.08.20.
 */
public class LeftmostRightmost {
    // https://www.geeksforgeeks.org/print-leftmost-and-rightmost-nodes-of-a-binary-tree/

    Node root;

    void printCorner(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // n is the no of nodes in current Level
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.peek();
                q.poll();
                if (i == 0 || i == n - 1) {
                    System.out.print(temp.data + "  ");
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        LeftmostRightmost tree = new LeftmostRightmost();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);
        tree.printCorner(tree.root);
    }
}
