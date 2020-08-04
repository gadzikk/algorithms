package trees;

/**
 * Created by gadzik on 04.08.20.
 */
public class SuccessorPreorder {
    // https://www.geeksforgeeks.org/preorder-successor-node-binary-tree/
    static class Node {
        Node left, right, parent;
        int key;
    }

    static Node newNode(int key) {
        Node temp = new Node();
        temp.left = temp.right = temp.parent = null;
        temp.key = key;
        return temp;
    }

    static Node preorderSuccessor(Node n) {

        if (n.left != null) {
            return n.left;
        }

        Node curr = n, parent = curr.parent;
        while (parent != null && parent.right == curr) {
            curr = curr.parent;
            parent = parent.parent;
        }

        if (parent == null)
            return null;

        return parent.right;
    }

    public static void main(String args[]) {
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

        Node res = preorderSuccessor(root.left.right.right);

        if (res != null) {
            System.out.printf("Preorder successor of %d is %d\n",
                    root.left.right.right.key, res.key);
        } else {
            System.out.printf("Preorder successor of %d is null\n",
                    root.left.right.right.key);
        }
    }
}
