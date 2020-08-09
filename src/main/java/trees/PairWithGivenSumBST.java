package trees;

import zobjects.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gadzik on 09.08.20.
 */
public class PairWithGivenSumBST {
    // https://www.geeksforgeeks.org/find-pair-given-sum-bst
    static Node insert(Node root, int key) {
        if (root == null) {
            return NewNode(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static boolean findpairUtil(Node root, int sum, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (findpairUtil(root.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - root.data)) {
            System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        } else {
            set.add(root.data);
        }

        return findpairUtil(root.right, sum, set);
    }

    static void findPair(Node root, int sum) {
        Set<Integer> set = new HashSet<>();
        if (!findpairUtil(root, sum, set)) {
            System.out.print("Pairs do not exit" + "\n");
        }
    }

    static Node NewNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 15);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 12);
        root = insert(root, 16);
        root = insert(root, 25);
        root = insert(root, 10);

        int sum = 33;
        findPair(root, sum);

    }
}
