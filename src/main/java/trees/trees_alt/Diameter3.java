package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class Diameter3 {
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
    static class A {
        int ans = Integer.MIN_VALUE;
    }

    /* Function to find height of a tree */
    static int height(Node root, A a) {
        if (root == null) {
            return 0;
        }

        int left_height = height(root.left, a);
        int right_height = height(root.right, a);

        a.ans = Math.max(a.ans, 1 + left_height + right_height);
        return 1 + Math.max(left_height, right_height);
    }

    /* Computes the diameter of binary
    tree with given root. */
    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        A a = new A();
        int height_of_tree = height(root, a);
        return a.ans;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return (node);
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Diameter is " + diameter(root));
    }
}
