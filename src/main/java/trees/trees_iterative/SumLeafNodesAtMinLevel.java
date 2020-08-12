package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 02.08.20.
 */
public class SumLeafNodesAtMinLevel {

    static int sumOfLeafNodesAtMinLevel(Node root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        Queue<Node> q = new LinkedList<>();
        int sum = 0;
        boolean f = false;
        q.add(root);

        while (f == false) {
            int nc = q.size();
            while (nc-- > 0) {
                Node top = q.peek();
                q.remove();
                if (top.left == null && top.right == null) {
                    sum += top.data;
                    f = true;
                } else {
                    if (top.left != null)
                        q.add(top.left);
                    if (top.right != null)
                        q.add(top.right);
                }
            }
        }

        return sum;
    }

    static Node getNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    public static void main(String[] args) {
        Node root = getNode(1);
        root.left = getNode(2);
        root.right = getNode(3);
        root.left.left = getNode(4);
        root.left.right = getNode(5);
        root.right.left = getNode(6);
        root.right.right = getNode(7);
        root.left.right.left = getNode(8);
        root.right.left.right = getNode(9);
        System.out.println("Sum = " + sumOfLeafNodesAtMinLevel(root));
    }
}
