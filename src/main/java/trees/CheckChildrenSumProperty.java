package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class CheckChildrenSumProperty {
    // https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
    Node root;

    int isSumProperty(Node node) {

        int left_data = 0, right_data = 0;

        if (node == null || (node.left == null && node.right == null)) {
            return 1;
        } else {
            if (node.left != null) {
                left_data = node.left.data;
            }

            if (node.right != null) {
                right_data = node.right.data;
            }

            if ((node.data == left_data + right_data) && (isSumProperty(node.left) != 0) && isSumProperty(node.right) != 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        CheckChildrenSumProperty tree = new CheckChildrenSumProperty();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        if (tree.isSumProperty(tree.root) != 0) {
            System.out.println("The given tree satisfies children" + " sum property");
        } else {
            System.out.println("The given tree does not satisfy children" + " sum property");
        }
    }
}
