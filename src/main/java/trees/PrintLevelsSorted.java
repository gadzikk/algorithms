package trees;

import zobjects.Node;

import java.util.*;

/**
 * Created by gadzik on 07.08.20.
 */
public class PrintLevelsSorted {
    // https://www.geeksforgeeks.org/print-binary-tree-levels-sorted-order-2/
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static void sorted_level_order(Node root) {
        Queue<Node> q = new LinkedList<>();
        Set<Integer> s = new HashSet<Integer>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node tmp = q.peek();
            q.remove();
            if (tmp == null) {
                if (s.isEmpty()) {
                    break;
                }
                Iterator value = s.iterator();
                while (value.hasNext()) {
                    System.out.print(value.next() + " ");
                }
                q.add(null);
                s.clear();
            } else {
                s.add(tmp.data);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = newNode(7);
        root.left = newNode(6);
        root.right = newNode(5);
        root.left.left = newNode(4);
        root.left.right = newNode(3);
        root.right.left = newNode(2);
        root.right.right = newNode(1);
        sorted_level_order(root);
    }
}
