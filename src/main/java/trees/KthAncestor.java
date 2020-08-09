package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 08.08.20.
 */
public class KthAncestor {
    // https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree/
    static void generateArray(Node root, int ancestors[]) {
        ancestors[root.data] = -1;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();

            if (temp.left != null) {
                ancestors[temp.left.data] = temp.data;
                q.add(temp.left);
            }

            if (temp.right != null) {
                ancestors[temp.right.data] = temp.data;
                q.add(temp.right);
            }
        }
    }

    static int kthAncestor(Node root, int n, int k, int node) {
        int ancestors[] = new int[n + 1];
        generateArray(root, ancestors);
        int count = 0;

        while (node != -1) {
            node = ancestors[node];
            count++;

            if (count == k) {
                break;
            }
        }

        return node;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        int k = 2;
        int node = 5;

        // print kth ancestor of given node
        System.out.println(kthAncestor(root, 5, k, node));
    }
}
