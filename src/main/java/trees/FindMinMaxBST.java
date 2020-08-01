package trees;

import zobjects.Node;

/**
 * Created by gadzik on 30.07.20.
 */
public class FindMinMaxBST {
    // https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/

    static Node head;

    Node insert(Node node, int data) {

        if (node == null) {
            return (new Node(data));
        } else {

            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            return node;
        }
    }

    int minvalue(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }

    static int minValueRec(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return minValueRec(node.left);
    }

    int maxvalue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return (current.data);
    }

    static int maxValueRec(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return maxValueRec(node.left);
    }

    public static void main(String[] args) {
        FindMinMaxBST tree = new FindMinMaxBST();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("Minimum value of BST is " + tree.minvalue(root));
    }
}
