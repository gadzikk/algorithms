package trees;

import zobjects.Node;

import java.util.Vector;

/**
 * Created by gadzik on 08.08.20.
 */
public class KthAncestor3 {
    // https://www.geeksforgeeks.org/k-th-ancestor-of-a-node-in-binary-tree-set-3/

    static boolean RootToNode(Node root, int key, Vector<Integer> v) {
        if (root == null) {
            return false;
        }

        v.add(root.data);

        if (root.data == key) {
            return true;
        }

        if (RootToNode(root.left, key, v) || RootToNode(root.right, key, v)) {
            return true;
        }

        v.removeElementAt(v.size() - 1);
        return false;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.left = temp.right = null;
        temp.data = data;
        return temp;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);

        int target = 4;

        Vector<Integer> v = new Vector<>();
        RootToNode(root, target, v);

        int k = 2;

        if (k > v.size() - 1 || k <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(v.get(v.size() - 1 - k));
        }
    }
}
