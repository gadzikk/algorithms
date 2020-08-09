package trees;

import zobjects.Node;

/**
 * Created by gadzik on 08.08.20.
 */
public class DeadEnd {
    // https://www.geeksforgeeks.org/simple-recursive-solution-check-whether-bst-contains-dead-end/
    Node root;

    DeadEnd() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    boolean deadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }

        if (min == max) {
            return true;
        }

        return deadEnd(root.left, min, root.data - 1) || deadEnd(root.right, root.data + 1, max);
    }


    // Driver Program
    public static void main(String[] args) {
        DeadEnd tree = new DeadEnd();

        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(7);
        tree.insert(11);
        tree.insert(4);

        if (tree.deadEnd(tree.root, 1, Integer.MAX_VALUE) == true) {
            System.out.println("Yes ");
        } else {
            System.out.println("No ");
        }
    }
}
