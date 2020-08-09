package trees;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * Created by gadzik on 06.08.20.
 */
public class LeafPrintRemove {
    // https://www.geeksforgeeks.org/print-the-nodes-of-binary-tree-as-they-become-the-leaf-node

    static class Node {
        int data;
        int order;
        Node left;
        Node right;
    }

    static class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    static Vector<Pair> v = new Vector<Pair>();

    static void Postorder(Node node) {
        if (node == null) {
            return;
        }

        Postorder(node.left);
        Postorder(node.right);

        if (node.right == null && node.left == null) {
            node.order = 1;
            v.add(new Pair(node.order, node.data));
        } else {
            node.order = Math.max((node.left).order, (node.right).order) + 1;
            v.add(new Pair(node.order, node.data));
        }
    }

    static class Sort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.first != b.first) {
                return (a.first - b.first);
            } else {
                return (a.second - b.second);
            }
        }
    }

    static void printLeafNodes(int n) {
        Collections.sort(v, new Sort());
        for (int i = 0; i < v.size(); i++) {
            if (i != v.size() - 1 && v.get(i).first == v.get(i + 1).first) {
                System.out.print(v.get(i).second + " ");
            } else {
                System.out.print(v.get(i).second + "\n");
            }
        }
    }

    static Node newNode(int data, int order) {
        Node node = new Node();
        node.data = data;
        node.order = order;
        node.left = null;
        node.right = null;

        return (node);
    }

    public static void main(String args[]) {
        Node root = newNode(8, 0);
        root.left = newNode(3, 0);
        root.right = newNode(10, 0);
        root.left.left = newNode(1, 0);
        root.left.right = newNode(6, 0);
        root.right.left = newNode(14, 0);
        root.right.right = newNode(4, 0);
        root.left.left.left = newNode(7, 0);
        root.left.left.right = newNode(13, 0);

        int n = 9;

        Postorder(root);
        printLeafNodes(n);
    }
}
