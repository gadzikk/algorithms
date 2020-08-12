package trees.trees_hard;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class FindMinMaxWithoutRecStackQueue {
    // https://www.geeksforgeeks.org/find-maximum-and-minimum-element-in-binary-tree-without-using-recursion-or-stack-or-queue/
    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.left = temp.right = null;
        return (temp);
    }


    // Function to print a maximum and minimum elementin a tree without recursion without stack
    static void printMinMax(Node root) {

        if (root == null) {
            System.out.print("Tree is empty");
            return;
        }

        Node current = root;
        Node pre;

        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;


        while (current != null) {
            // If left child does nor exists
            if (current.left == null) {
                max_value = Math.max(max_value, current.data);
                min_value = Math.min(min_value, current.data);

                current = current.right;
            } else {

                // Find the inorder predecessor of current
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                // Revert the changes made in the 'if' part to restore the original tree i.e., fix the
                // right child of predecessor
                else {
                    pre.right = null;

                    max_value = Math.max(max_value, current.data);
                    min_value = Math.min(min_value, current.data);

                    current = current.right;
                }
            }
        }

        System.out.print("Max Value is : " + max_value + "\n");
        System.out.print("Min Value is : " + min_value + "\n");
    }

    // Driver Code
    public static void main(String[] args) {
        Node root = newNode(15);
        root.left = newNode(19);
        root.right = newNode(11);

        root.right.left = newNode(25);
        root.right.right = newNode(5);

        root.right.left.left = newNode(17);
        root.right.left.right = newNode(3);
        root.right.right.left = newNode(23);
        root.right.right.right = newNode(24);

        printMinMax(root);
    }
}
