package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class MaxWidth {
    // https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
    Node root;

    int getMaxWidth(Node node) {
        int maxWidth = 0;
        int height = height(node);
        int i;

        for (i = 1; i <= height; i++) {
            int width = getWidth(node, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    /* Get width of a given level */
    int getWidth(Node node, int level) {
        if (node == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        } else if (level > 1) {
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        }
        return 0;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);

    }

    public static void main(String args[]) {
        MaxWidth tree = new MaxWidth();

        /*
        Constructed bunary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8
                 /  \
                6   7
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);

        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
    }
}
