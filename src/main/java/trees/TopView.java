package trees;

import zobjects.Node;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by gadzik on 08.08.20.
 */
public class TopView {
    // https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

    static TreeMap<Integer, pair> treeMap = new TreeMap<>();

    static void fillMap(Node root, int d, int l) {
        if (root == null) {
            return;
        }

        if (treeMap.get(d) == null) {
            treeMap.put(d, new pair(root.data, l));
        } else if (treeMap.get(d).second > l) {
            treeMap.put(d, new pair(root.data, l));
        }

        fillMap(root.left, d - 1, l + 1);
        fillMap(root.right, d + 1, l + 1);
    }

    static void topView(Node root) {
        fillMap(root, 0, 0);

        for (Map.Entry<Integer, pair> entry : treeMap.entrySet()) {
            System.out.print(entry.getValue().first + " ");
        }
    }

    static Node newNode(int key) {
        Node node = new Node();
        node.left = node.right = null;
        node.data = key;
        return node;
    }

    static class pair {
        int first, second;

        pair() {
        }

        pair(int i, int j) {
            first = i;
            second = j;
        }
    }

    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.left.right.right = newNode(5);
        root.left.right.right.right = newNode(6);
        System.out.println("Following are nodes in" +
                " top view of Binary Tree");
        topView(root);
    }
}
