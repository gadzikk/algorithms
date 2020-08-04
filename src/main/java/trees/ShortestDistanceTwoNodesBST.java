package trees;

import zobjects.Node;

/**
 * Created by gadzik on 04.08.20.
 */
public class ShortestDistanceTwoNodesBST {
    // https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/


    static int distanceFromRoot(Node root, int x) {
        if (root.data == x) {
            return 0;
        } else if (x < root.data) {
            return 1 + distanceFromRoot(root.left, x);
        }
        return 1 + distanceFromRoot(root.right, x);
    }

    static int distanceBetween2(Node root, int a, int b) {
        if (root == null)
            return 0;

        if (root.data > a && root.data > b) {
            return distanceBetween2(root.left, a, b);
        }

        if (root.data < a && root.data < b) {
            return distanceBetween2(root.right, a, b);
        }

        if (root.data >= a && root.data <= b) {
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        }

        return 0;
    }

    static int findDistWrapper(Node root, int a, int b) {
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        return distanceBetween2(root, a, b);
    }

    static Node newNode(int key) {
        Node ptr = new Node();
        ptr.data = key;
        ptr.left = null;
        ptr.right = null;
        return ptr;
    }

    static Node insert(Node root, int key) {
        if (root == null)
            root = newNode(key);
        else if (root.data > key)
            root.left = insert(root.left, key);
        else if (root.data < key)
            root.right = insert(root.right, key);
        return root;
    }

    // Driver code
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 30);
        insert(root, 25);
        insert(root, 35);
        System.out.println(findDistWrapper(root, 5, 35));
    }
}
