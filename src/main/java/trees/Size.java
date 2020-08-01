package trees;

import zobjects.Node;

/**
 * Created by gadzik on 30.07.20.
 */
public class Size {
    Node root;

    int size() {
        return size(root);
    }

    int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        Size tree = new Size();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The size of binary tree is : "
                + tree.size());
    }
}
