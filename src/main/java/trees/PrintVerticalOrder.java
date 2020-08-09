package trees;

import zobjects.Node;

/**
 * Created by gadzik on 08.08.20.
 */
public class PrintVerticalOrder {
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order/

    Node root;
    Values val = new Values();

    class Values {
        int max, min;
    }

    void findMinMax(Node node, Values min, Values max, int horizontalDistance) {
        if (node == null) {
            return;
        }

        if (horizontalDistance < min.min) {
            min.min = horizontalDistance;
        } else if (horizontalDistance > max.max) {
            max.max = horizontalDistance;
        }

        findMinMax(node.left, min, max, horizontalDistance - 1);
        findMinMax(node.right, min, max, horizontalDistance + 1);
    }

    void printVerticalLine(Node node, int line_no, int horizontalDistance) {
        if (node == null) {
            return;
        }

        if (horizontalDistance == line_no) {
            System.out.print(node.data + " ");
        }

        printVerticalLine(node.left, line_no, horizontalDistance - 1);
        printVerticalLine(node.right, line_no, horizontalDistance + 1);
    }

    void verticalOrder(Node node) {
        findMinMax(node, val, val, 0);

        for (int line_no = val.min; line_no <= val.max; line_no++) {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        PrintVerticalOrder tree = new PrintVerticalOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
}
