package trees.trees_iterative;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class BoundaryLevelOrderTravesal {
    // https://www.geeksforgeeks.org/boundary-level-order-traversal-of-a-binary-tree/
    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.left = temp.right = null;
        return (temp);
    }

    static void printLevelUtil(Node queue[], int index, int size) {
        while (index < size) {
            System.out.print(queue[index++].data + " " + queue[size--].data + " ");
        }

        if (index == size) {
            System.out.print(queue[index].data + " ");
        }

        System.out.println();
    }

    static void printLevel(Node node, Node queue[], int index, int size) {
        System.out.print(queue[index].data + "\n");

        while (index < size) {
            int curr_size = size;
            while (index < curr_size) {
                Node temp = queue[index];

                if (temp.left != null) {
                    queue[size++] = temp.left;
                }

                if (temp.right != null) {
                    queue[size++] = temp.right;
                }

                index++;
            }

            printLevelUtil(queue, index, size - 1);
        }
    }

    static int findSize(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + findSize(node.left) + findSize(node.right);
    }

    static void printLevelInStartEndFashion(Node node) {
        int t_size = findSize(node);
        Node[] queue = new Node[t_size];
        queue[0] = node;
        printLevel(node, queue, 0, 1);
    }

    public static void main(String[] args) {
    /*     10
           / \
         13   13
          /     \
        14       15
        / \     / \
       21 22   22 21
                  /
                 8 */

        // Create Binary Tree as shown
        Node root = newNode(10);
        root.left = newNode(13);
        root.right = newNode(13);

        root.right.left = newNode(14);
        root.right.right = newNode(15);

        root.right.left.left = newNode(21);
        root.right.left.right = newNode(22);
        root.right.right.left = newNode(22);
        root.right.right.right = newNode(21);
        root.right.right.right.left = newNode(8);

        // Print Levels In Start End Fashion
        printLevelInStartEndFashion(root);

    }
}
