package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 06.08.20.
 */
public class CousinsOfNode2 {

    static void printCousins(Node root, Node node_to_find) {
        // be printed
        if (root == node_to_find) {
            System.out.print("Cousin Nodes :" + " None" + "\n");
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        boolean found = false;
        int size = 0;
        Node p = null;
        q.add(root);

        while (q.isEmpty() == false && found == false) {

            size = q.size();
            while (size-- > 0) {
                p = q.peek();
                q.remove();

                if ((p.left == node_to_find || p.right == node_to_find)) {
                    found = true;
                } else {
                    if (p.left != null) {
                        q.add(p.left);
                    }
                    if (p.right != null) {
                        q.add(p.right);
                    }
                }
            }
        }

        if (found == true) {
            System.out.print("Cousin Nodes : ");
            size = q.size();

            if (size == 0) {
                System.out.print("None");
            }

            for (int i = 0; i < size; i++) {
                p = q.peek();
                q.poll();

                System.out.print(p.data + " ");
            }
        } else {
            System.out.print("Node not found");
        }

        System.out.println("");
        return;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        Node x = new Node(43);

        printCousins(root, x);
        printCousins(root, root);
        printCousins(root, root.right);
        printCousins(root, root.left);
        printCousins(root, root.left.right);
    }
}
