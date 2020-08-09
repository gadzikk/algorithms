package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class SumAllBoundary {
    // https://www.geeksforgeeks.org/sum-of-all-the-boundary-nodes-of-a-binary-tree/

    static int sum_of_boundary_nodes = 0;

    static Node newNode(int data) {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = data;
        return temp;
    }

    static void LeftBoundary(Node root) {
        if (root != null) {

            if (root.left != null) {
                sum_of_boundary_nodes += root.data;
                LeftBoundary(root.left);
            } else if (root.right != null) {
                sum_of_boundary_nodes += root.data;
                LeftBoundary(root.right);
            }
        }
    }

    static void RightBoundary(Node root) {
        if (root != null) {

            if (root.right != null) {
                RightBoundary(root.right);
                sum_of_boundary_nodes += root.data;
            } else if (root.left != null) {
                RightBoundary(root.left);
                sum_of_boundary_nodes += root.data;
            }
        }
    }

    static void Leaves(Node root) {
        if (root != null) {
            Leaves(root.left);

            if ((root.left == null) && (root.right == null)) {
                sum_of_boundary_nodes += root.data;
            }

            Leaves(root.right);
        }
    }

    // Function to return the sum of all the
// boundary nodes of the given binary tree
    static int sumOfBoundaryNodes(Node root) {
        if (root != null) {

            sum_of_boundary_nodes = root.data;
            LeftBoundary(root.left);
            Leaves(root.left);
            Leaves(root.right);
            RightBoundary(root.right);
            return sum_of_boundary_nodes;
        }

        return 0;
    }

    public static void main(String args[]) {
        Node root = newNode(10);
        root.left = newNode(2);
        root.right = newNode(5);
        root.left.left = newNode(8);
        root.left.right = newNode(14);
        root.right.left = newNode(11);
        root.right.right = newNode(3);
        root.left.right.left = newNode(12);
        root.right.left.right = newNode(1);
        root.right.left.left = newNode(7);

        System.out.println(sumOfBoundaryNodes(root));
    }
}
