package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 04.08.20.
 */
public class ExtremeNodesAlternateOrder2 {
    // https://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/

    static void printExtremeNodes(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (q.size() > 0) {
            int nodeCount = q.size();
            int n = nodeCount;
            while (n-- > 0) {
                Node curr = q.peek();
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

                q.remove();

                if (flag && n == nodeCount - 1) {
                    System.out.print(curr.data + " ");
                }

                if (!flag && n == 0) {
                    System.out.print(curr.data + " ");
                }
            }

            flag = !flag;
        }
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.right = node.left = null;
        return node;
    }

    public static void main(String args[]) {
        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.right = newNode(7);

        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        root.left.right.left = newNode(10);
        root.left.right.right = newNode(11);
        root.right.right.left = newNode(14);
        root.right.right.right = newNode(15);

        root.left.left.left.left = newNode(16);
        root.left.left.left.right = newNode(17);
        root.right.right.right.right = newNode(31);

        printExtremeNodes(root);
    }
}
