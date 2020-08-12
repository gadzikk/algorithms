package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 07.08.20.
 */
public class KSumPaths2 {
    // https://www.geeksforgeeks.org/print-all-k-sum-levels-in-a-binary-tree/

    static Vector<Integer> level = new Vector<>();


    static void display(boolean flag) {
        if (flag) {
            for (Integer x : level) {
                System.out.print(x + " ");
            }
        } else {
            System.out.print("Not Possible\n");
        }
    }

    static void SumlevelOrder(Node root, int k) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (q.isEmpty() == false) {
            int nodeCount = q.size();
            int Present_level_sum = 0;
            while (nodeCount > 0) {
                Node node = q.peek();
                Present_level_sum += node.data;
                level.add(node.data);
                q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                nodeCount--;
            }

            if (Present_level_sum == k) {
                flag = true;
                break;
            }

            level.clear();
        }

        display(flag);
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Driver code
    public static void main(String[] args) {
        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.right = newNode(6);

        int K = 15;

        SumlevelOrder(root, K);

    }
}
