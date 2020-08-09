package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenLevelorder {
    // https://www.geeksforgeeks.org/flatten-binary-tree-in-order-of-level-order-traversal
    static void flatten(Node parent) {
        Queue<Node> q = new LinkedList<>();
        q.add(parent.left);
        q.add(parent.right);
        Node prev = parent;

        while (q.size() > 0) {

            int s = q.size();
            while (s-- > 0) {
                Node curr = q.peek();
                q.remove();

                if (curr == null) {
                    continue;
                }
                prev.right = curr;
                prev.left = null;
                prev = curr;

                q.add(curr.left);
                q.add(curr.right);
            }
        }
        prev.left = null;
        prev.right = null;
    }

    static void print(Node parent) {
        Node curr = parent;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(5);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(4);
        root.right.left = new Node(9);
        root.right.right = new Node(3);

        flatten(root);
        print(root);
    }
}
