package trees.trees_alt;

import zobjects.NodeC;

/**
 * Created by gadzik on 07.08.20.
 */
public class ReverseAlternateLevels2 {
    // https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
    static void preorder(NodeC root1, NodeC root2, int level) {
        if (root1 == null || root2 == null) {
            return;
        }

        if (level % 2 == 0) {
            char temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;
        }

        preorder(root1.left, root2.right, level + 1);
        preorder(root1.right, root2.left, level + 1);
    }

    static void reverseAlternate(NodeC root) {
        preorder(root.left, root.right, 0);
    }

    static void printInorder(NodeC root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static NodeC newNode(int key) {
        NodeC temp = new NodeC();
        temp.left = temp.right = null;
        temp.data = (char) key;
        return temp;
    }

    public static void main(String args[]) {
        NodeC root = newNode('a');
        root.left = newNode('b');
        root.right = newNode('c');
        root.left.left = newNode('d');
        root.left.right = newNode('e');
        root.right.left = newNode('f');
        root.right.right = newNode('g');
        root.left.left.left = newNode('h');
        root.left.left.right = newNode('i');
        root.left.right.left = newNode('j');
        root.left.right.right = newNode('k');
        root.right.left.left = newNode('l');
        root.right.left.right = newNode('m');
        root.right.right.left = newNode('n');
        root.right.right.right = newNode('o');

        System.out.print("Inorder Traversal of given tree\n");
        printInorder(root);

        reverseAlternate(root);

        System.out.print("\n\nInorder Traversal of modified tree\n");
        printInorder(root);

    }
}
