package trees;

import zobjects.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by gadzik on 09.08.20.
 */
public class DiagonalTravesal {
    // https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

    static void diagonalPrintUtil(Node root, int distance, HashMap<Integer, Vector<Integer>> diagonalPrint) {

        if (root == null) {
            return;
        }

        Vector<Integer> k = diagonalPrint.get(distance);

        if (k == null) {
            k = new Vector<>();
            k.add(root.data);
        } else {
            k.add(root.data);
        }

        diagonalPrint.put(distance, k);
        diagonalPrintUtil(root.left, distance + 1, diagonalPrint);
        diagonalPrintUtil(root.right, distance, diagonalPrint);
    }

    static void diagonalPrint(Node root) {
        HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();
        diagonalPrintUtil(root, 0, diagonalPrint);

        System.out.println("Diagonal Traversal of Binnary Tree");
        for (Map.Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        diagonalPrint(root);
    }
}
