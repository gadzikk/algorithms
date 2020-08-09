package trees;

/**
 * Created by gadzik on 09.08.20.
 */
public class RightSiblingWithParentPointers {
    // https://www.geeksforgeeks.org/find-right-sibling-binary-tree-parent-pointers/
    static class Node {
        int data;
        Node left, right, parent;

        public Node(int data, Node parent) {
            this.data = data;
            left = null;
            right = null;
            this.parent = parent;
        }
    }

    ;

    static Node findRightSibling(Node node, int level) {
        if (node == null || node.parent == null) {
            return null;
        }

        while (node.parent.right == node || (node.parent.right == null && node.parent.left == node)) {
            if (node.parent == null) {
                return null;
            }

            node = node.parent;
            level--;
        }

        node = node.parent.right;

        while (level < 0) {
            if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                break;
            }

            level++;
        }

        if (level == 0) {
            return node;
        }

        return findRightSibling(node, level);
    }

    public static void main(String args[]) {
        Node root = new Node(1, null);
        root.left = new Node(2, root);
        root.right = new Node(3, root);
        root.left.left = new Node(4, root.left);
        root.left.right = new Node(6, root.left);
        root.left.left.left = new Node(7, root.left.left);
        root.left.left.left.left = new Node(10, root.left.left.left);
        root.left.right.right = new Node(9, root.left.right);
        root.right.right = new Node(5, root.right);
        root.right.right.right = new Node(8, root.right.right);
        root.right.right.right.right = new Node(12, root.right.right.right);
        System.out.println(findRightSibling(root.left.left.left.left, 0).data);
    }
}
