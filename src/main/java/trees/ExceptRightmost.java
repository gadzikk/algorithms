package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 06.08.20.
 */
public class ExceptRightmost {
    // https://www.geeksforgeeks.org/print-all-nodes-except-rightmost-node-of-every-level-of-the-binary-tree

    static void excluderightmost(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (true) {

            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }

            while (nodeCount > 0) {
                Node node = q.peek();
                if (nodeCount != 1) {
                    System.out.print(node.data + " ");
                }
                q.remove();

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                nodeCount--;
            }
            System.out.println();
        }
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.right.left = newNode(8);
        root.left.right.right = newNode(9);
        root.left.right.right.right = newNode(10);

        excluderightmost(root);
    }
}
