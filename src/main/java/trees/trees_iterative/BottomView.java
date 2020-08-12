package trees.trees_iterative;

import java.util.*;

/**
 * Created by gadzik on 04.08.20.
 */
public class BottomView {
    // https://www.geeksforgeeks.org/bottom-view-binary-tree/
    static class Node {
        int data;
        int horizontalDistance;
        Node left, right;

        public Node(int key) {
            data = key;
            horizontalDistance = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    Node root; //root node of tree

    // Default constructor
    public BottomView() {
    }

    // Parameterized tree constructor
    public BottomView(Node node) {
        root = node;
    }

    public void bottomView() {
        if (root == null) {
            return;
        }

        int horizontalDistance = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.horizontalDistance = horizontalDistance;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            horizontalDistance = temp.horizontalDistance;
            map.put(horizontalDistance, temp.data);
            if (temp.left != null) {
                temp.left.horizontalDistance = horizontalDistance - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.horizontalDistance = horizontalDistance + 1;
                queue.add(temp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue() + " ");
        }
    }


    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        BottomView tree = new BottomView(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }
}
