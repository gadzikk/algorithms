package trees;

import zobjects.Node;
import java.util.TreeMap;

/**
 * Created by gadzik on 01.08.20.
 */
public class VerticalSum {
    // https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
    private Node root;

    public VerticalSum() {
        root = null;
    }

    public VerticalSum(Node n) {
        root = n;
    }

    public void VerticalSumMain() {
        VerticalSum(root);
    }

    private void VerticalSum(Node root) {

        if (root == null) {
            return;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Calls the VerticalSumUtil() to store the
        // vertical sum values in map
        VerticalSumUtil(root, 0, map);

        // Prints the values stored by VerticalSumUtil()
        if (map != null) {
            System.out.println(map.entrySet());
        }
    }

    private void VerticalSumUtil(Node root, int horizontalDistance, TreeMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        // Store the values in map for left subtree
        VerticalSumUtil(root.left, horizontalDistance - 1, map);

        // Update vertical sum for horizontalDistance of this node
        int prevSum = (map.get(horizontalDistance) == null) ? 0 : map.get(horizontalDistance);
        map.put(horizontalDistance, prevSum + root.data);

        // Store the values in map for right subtree
        VerticalSumUtil(root.right, horizontalDistance + 1, map);
    }

    public static void main(String[] args) {
        /* Create the following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        VerticalSum t = new VerticalSum(root);
        System.out.println("Following are the values of" + " vertical sums with the positions" + " of the columns with respect to root ");
        t.VerticalSumMain();
    }
}
