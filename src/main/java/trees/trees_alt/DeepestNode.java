package trees.trees_alt;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class DeepestNode {
    // https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
    static int maxLevel = -1;
    static int res = -1;

    static void find(Node root, int level) {
        if (root != null) {
            find(root.left, ++level);

            if (level > maxLevel) {
                res = root.data;
                maxLevel = level;
            }

            find(root.right, level);
        }
    }

    static int deepestNode(Node root) {
        find(root, 0);
        return res;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        System.out.println(deepestNode(root));
    }
}
