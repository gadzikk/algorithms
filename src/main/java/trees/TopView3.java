package trees;

import zobjects.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gadzik on 08.08.20.
 */
public class TopView3 {
    // https://www.geeksforgeeks.org/print-nodes-in-top-view-of-binary-tree-set-2/

    static class pair {
        int data, height;

        public pair(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    static void printTopViewUtil(Node root, int height, int horizontalDistance, Map<Integer, pair> m) {
        if (root == null) {
            return;
        }

        if (!m.containsKey(horizontalDistance)) {
            m.put(horizontalDistance, new pair(root.data, height));
        } else {
            pair p = m.get(horizontalDistance);

            if (p.height > height) {
                m.remove(horizontalDistance);
                m.put(horizontalDistance, new pair(root.data, height));
            }
        }

        // Recur for left and right subtree
        printTopViewUtil(root.left, height + 1, horizontalDistance - 1, m);
        printTopViewUtil(root.right, height + 1, horizontalDistance + 1, m);
    }

    static void printTopView(Node root) {
        // Map to store horizontal distance,
        // height and node's data
        Map<Integer, pair> m = new HashMap<>();
        printTopViewUtil(root, 0, 0, m);

        // Print the node's value stored by printTopViewUtil()
        for (Map.Entry<Integer, pair> it : m.entrySet()) {
            pair p = it.getValue();
            System.out.print(p.data + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.left.right.right = newNode(5);
        root.left.right.right.right = newNode(6);

        System.out.print("Top View : ");
        printTopView(root);
    }
}
