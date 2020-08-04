package trees;

/**
 * Created by gadzik on 04.08.20.
 */
public class PredecessorPreorder {
    // https://www.geeksforgeeks.org/preorder-predecessor-node-binary-tree/
    static class Node {
        Node left, right, parent;
        int value;
    }

    static Node newNode(int value) {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.parent = null;
        temp.value = value;
        return temp;
    }

    static Node preorderPredecessor(Node root, Node n) {
        if (n == root) {
            return null;
        }

        Node parent = n.parent;
        if (parent.left == null || parent.left == n) {
            return parent;
        }

        Node curr = parent.left;
        while (curr.right != null) {
            curr = curr.right;
        }

        return curr;
    }

    // Driver code
    public static void main(String[] args) {
        Node root = newNode(20);
        root.parent = null;
        root.left = newNode(10);
        root.left.parent = root;
        root.left.left = newNode(4);
        root.left.left.parent = root.left;
        root.left.right = newNode(18);
        root.left.right.parent = root.left;
        root.right = newNode(26);
        root.right.parent = root;
        root.right.left = newNode(24);
        root.right.left.parent = root.right;
        root.right.right = newNode(27);
        root.right.right.parent = root.right;
        root.left.right.left = newNode(14);
        root.left.right.left.parent = root.left.right;
        root.left.right.left.left = newNode(13);
        root.left.right.left.left.parent = root.left.right.left;
        root.left.right.left.right = newNode(15);
        root.left.right.left.right.parent = root.left.right.left;
        root.left.right.right = newNode(19);
        root.left.right.right.parent = root.left.right;

        Node res = preorderPredecessor(root, root.left.right.right);
        if (res != null) {
            System.out.println("Preorder predecessor of " + root.left.right.right.value + " is " + res.value);
        } else {
            System.out.println("Preorder predecessor of " + root.left.right.right.value + " is null");
        }

    }
}
