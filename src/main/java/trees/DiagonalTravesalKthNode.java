package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 09.08.20.
 */
public class DiagonalTravesalKthNode {
    // https://www.geeksforgeeks.org/kth-node-in-diagonal-traversal-of-binary-tree/
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static int diagonalPrint(Node root, int k) {
        if (root == null || k == 0) {
            return -1;
        }

        int ans = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 0) {
            Node temp = q.peek();
            q.remove();

            if (temp == null) {

                if (q.size() == 0) {
                    if (k == 0) {
                        return ans;
                    } else {
                        break;
                    }
                }
                q.add(null);
            } else {
                while (temp != null) {
                    if (k == 0) {
                        return ans;
                    }

                    k--;

                    ans = temp.data;
                    if (temp.left != null) {
                        q.add(temp.left);
                    }

                    temp = temp.right;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        Node root = newNode(8);
        root.left = newNode(3);
        root.right = newNode(10);
        root.left.left = newNode(1);
        root.left.right = newNode(6);
        root.right.right = newNode(14);
        root.right.right.left = newNode(13);
        root.left.right.left = newNode(4);
        root.left.right.right = newNode(7);
        int k = 9;
        System.out.println(diagonalPrint(root, k));
    }
}
