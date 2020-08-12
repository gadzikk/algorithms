package trees.trees_iterative;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 04.08.20.
 */
public class PredecessorLevelorder {
    // https://www.geeksforgeeks.org/level-order-predecessor-of-a-node-in-binary-tree
    static class Node {
        Node left, right;
        int value;
    }


    static Node levelOrderPredecessor(Node root, Node key) {
        if (root == null) {
            return null;
        }

        if (root == key) {
            return null;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node prev = null;

        while (!q.isEmpty()) {
            Node nd = q.peek();
            q.remove();

            if (nd == key) {
                break;
            } else {
                prev = nd;
            }

            if (nd.left != null) {
                q.add(nd.left);
            }

            if (nd.right != null) {
                q.add(nd.right);
            }
        }

        return prev;
    }

    static Node newNode(int value) {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.value = value;

        return temp;
    }

    public static void main(String[] args) {
        Node root = newNode(20);
        root.left = newNode(10);
        root.left.left = newNode(4);
        root.left.right = newNode(18);
        root.right = newNode(26);
        root.right.left = newNode(24);
        root.right.right = newNode(27);
        root.left.right.left = newNode(14);
        root.left.right.left.left = newNode(13);
        root.left.right.left.right = newNode(15);
        root.left.right.right = newNode(19);

        Node key = root.left.right.right;

        Node res = levelOrderPredecessor(root, key);

        if (res != null)
            System.out.println("LevelOrder Predecessor of " + key.value + " is " + res.value);
        else
            System.out.println("LevelOrder Predecessor of " + key.value + " is null");

    }
}
