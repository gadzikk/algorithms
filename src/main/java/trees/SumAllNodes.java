package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class SumAllNodes {
    // https://www.geeksforgeeks.org/sum-nodes-binary-tree/

    static int addBT(Node root) {
        if (root == null) {
            return 0;
        }
        return (root.data + addBT(root.left) + addBT(root.right));
    }

    static Node newNode(int key) {
        Node node = new Node();
        node.data = key;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left.right = newNode(8);

        int sum = addBT(root);
        System.out.println("Sum of all the elements is: " + sum);
    }
}
