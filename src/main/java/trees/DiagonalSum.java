package trees;

import zobjects.NodeVD;

import java.util.*;

/**
 * Created by gadzik on 01.08.20.
 */
public class DiagonalSum {
    // https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
    NodeVD root;

    public DiagonalSum(NodeVD root) {
        this.root = root;
    }

    public void diagonalSum() {
        Queue<NodeVD> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        // Assign the root's vertical distance as 0.
        root.vd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            // Remove the front tree node from queue.
            // Get the vertical distance of the dequeued node.
            NodeVD curr = queue.remove();
            int verticalDistance = curr.vd;

            // Sum over this node's right-child, right-of-right-child and so on
            while (curr != null) {
                int prevSum = (map.get(verticalDistance) == null) ? 0 : map.get(verticalDistance);
                map.put(verticalDistance, prevSum + curr.data);

                // If for any node the left child is not null add it to the queue for future processing.
                if (curr.left != null) {
                    curr.left.vd = verticalDistance + 1;
                    queue.add(curr.left);
                }

                curr = curr.right;
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        System.out.print("Diagonal sum in a binary tree is - ");

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> me = iterator.next();

            System.out.print(me.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        NodeVD root = new NodeVD(1);
        root.left = new NodeVD(2);
        root.right = new NodeVD(3);
        root.left.left = new NodeVD(9);
        root.left.right = new NodeVD(6);
        root.right.left = new NodeVD(4);
        root.right.right = new NodeVD(5);
        root.right.left.left = new NodeVD(12);
        root.right.left.right = new NodeVD(7);
        root.left.right.left = new NodeVD(11);
        root.left.left.right = new NodeVD(10);
        DiagonalSum tree = new DiagonalSum(root);
        tree.diagonalSum();
    }
}
