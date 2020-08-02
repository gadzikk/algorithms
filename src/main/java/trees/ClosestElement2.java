package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class ClosestElement2 {
    // https://www.geeksforgeeks.org/find-the-closest-element-in-binary-search-tree-space-efficient-method/
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static Node closestNodeUsingMorrisTraversal(Node root, int key) {
        int diff = Integer.MAX_VALUE;
        Node curr = root;
        Node closest = null;

        while (curr != null) {
            if (curr.left == null) {
                if (diff > Math.abs(curr.data - key)) {
                    diff = Math.abs(curr.data - key);
                    closest = curr;
                }
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;

                    if (diff > Math.abs(curr.data - key)) {
                        diff = Math.abs(curr.data - key);
                        closest = curr;
                    }

                    curr = curr.right;
                }
            }
        }

        return closest;
    }

    // Driver Code
    public static void main(String[] args) {
    /* Constructed binary tree is
        5
        / \
    3     9
    / \ / \
    1 2 8 12 */
        Node root = newNode(5);
        root.left = newNode(3);
        root.right = newNode(9);
        root.left.left = newNode(1);
        root.left.right = newNode(2);
        root.right.left = newNode(8);
        root.right.right = newNode(12);

        System.out.println(closestNodeUsingMorrisTraversal(root, 10).data);
    }
}
