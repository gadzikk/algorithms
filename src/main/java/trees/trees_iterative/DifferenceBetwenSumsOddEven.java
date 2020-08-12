package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 01.08.20.
 */
public class DifferenceBetwenSumsOddEven {
    // https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
    static int evenOddLevelDifference(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int evenSum = 0, oddSum = 0;

        while (q.size() != 0) {
            int size = q.size();
            level++;

            while (size > 0) {
                Node temp = q.remove();

                if (level % 2 == 0) {
                    evenSum += temp.data;
                } else {
                    oddSum += temp.data;
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
                size--;
            }
        }
        return (oddSum - evenSum);
    }

    // Driver code
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);
        System.out.println("diffence between sums is " + evenOddLevelDifference(root));
    }
}
