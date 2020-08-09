package trees;

import zobjects.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 07.08.20.
 */
public class CheckArithmeticGeoHarProgression {
    // https://www.geeksforgeeks.org/check-whether-nodes-of-binary-tree-form-arithmetic-geometric-or-harmonic-progression
    static int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    static boolean checkIsAP(double[] arr, int n) {
        if (n == 1) {
            return true;
        }

        Arrays.sort(arr);
        double d = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIsGP(double[] arr, int n) {
        if (n == 1) {
            return true;
        }

        Arrays.sort(arr);
        double r = arr[1] / arr[0];

        for (int i = 2; i < n; i++) {
            if (arr[i] / arr[i - 1] != r) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIsHP(double[] arr, int n) {
        if (n == 1) {
            return true;
        }
        double[] rec = new double[n];

        for (int i = 0; i < n; i++) {
            rec[i] = ((1 / arr[i]));
        }

        Arrays.sort(rec);
        double d = (rec[1]) - (rec[0]);

        for (int i = 2; i < n; i++) {
            if (rec[i] - rec[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    static void checktype(Node root) {

        int n = size(root);
        double[] arr = new double[n];
        int i = 0;

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            Node node = q.poll();
            arr[i] = node.data;
            i++;

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }

        int flag = 0;

        if (checkIsAP(arr, n)) {
            System.out.println("Arithmetic Progression");
            flag = 1;
        } else if (checkIsGP(arr, n)) {
            System.out.println("Geometric Progression");
            flag = 1;
        } else if (checkIsHP(arr, n)) {
            System.out.println("Geometric Progression");
            flag = 1;
        } else if (flag == 0) {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {

        /* Constructed Binary tree is:
                 1
                / \
               2   3
              / \   \
             4   5   8
                    / \
                   6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        checktype(root);
    }
}
