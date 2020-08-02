package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class LevelOrderTravesalReverse {
    // https://www.geeksforgeeks.org/reverse-level-order-traversal/

    Node root;

    void reverseLevelOrder(Node node) {
        int h = height(node);
        int i;
        for (i = h; i >= 1; i--) {
            printGivenLevel(node, i);
        }
    }

    void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lheight = height(node.left);
            int rheight = height(node.right);

            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    public static void main(String args[]) {
        LevelOrderTravesalReverse tree = new LevelOrderTravesalReverse();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level Order traversal of binary tree is : ");
        tree.reverseLevelOrder(tree.root);
    }
}
