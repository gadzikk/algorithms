package trees;

import zobjects.Node;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by gadzik on 08.08.20.
 */
public class PrintVerticalOrder2 {
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
    static void getVerticalOrder(Node root, int horizontalDistance, TreeMap<Integer, Vector<Integer>> m) {
        if (root == null) {
            return;
        }

        Vector<Integer> horizontalDistanceFromMap = m.get(horizontalDistance);

        if (horizontalDistanceFromMap == null) {
            horizontalDistanceFromMap = new Vector<>();
            horizontalDistanceFromMap.add(root.data);
        } else {
            horizontalDistanceFromMap.add(root.data);
        }

        m.put(horizontalDistance, horizontalDistanceFromMap);

        getVerticalOrder(root.left, horizontalDistance - 1, m);
        getVerticalOrder(root.right, horizontalDistance + 1, m);
    }

    static void printVerticalOrder(Node root) {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        int horizontalDistance = 0;
        getVerticalOrder(root, horizontalDistance, map);

        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
