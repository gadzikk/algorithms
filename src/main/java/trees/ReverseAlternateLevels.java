package trees;

import zobjects.NodeC;

/**
 * Created by gadzik on 07.08.20.
 */
public class ReverseAlternateLevels {
    // https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
    class Index {
        int index;
    }

    NodeC root;
    Index index_obj = new Index();

    void storeAlternate(NodeC node, char arr[], Index index, int level) {
        if (node == null) {
            return;
        }

        storeAlternate(node.left, arr, index, level + 1);

        if (level % 2 != 0) {
            arr[index.index] = node.data;
            index.index++;
        }

        storeAlternate(node.right, arr, index, level + 1);
    }

    void modifyTree(NodeC node, char arr[], Index index, int level) {

        if (node == null) {
            return;
        }

        modifyTree(node.left, arr, index, level + 1);

        if (level % 2 != 0) {
            node.data = arr[index.index];
            (index.index)++;
        }

        modifyTree(node.right, arr, index, level + 1);
    }

    void reverse(char arr[], int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    void reverseAlternate() {
        reverseAlternate(root);
    }

    void reverseAlternate(NodeC node) {
        char[] arr = new char[100];
        storeAlternate(node, arr, index_obj, 0);
        reverse(arr, index_obj.index);
        index_obj.index = 0;
        modifyTree(node, arr, index_obj, 0);
    }

    void printInorder() {
        printInorder(root);
    }

    void printInorder(NodeC node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        ReverseAlternateLevels tree = new ReverseAlternateLevels();
        tree.root = new NodeC('a');
        tree.root.left = new NodeC('b');
        tree.root.right = new NodeC('c');
        tree.root.left.left = new NodeC('d');
        tree.root.left.right = new NodeC('e');
        tree.root.right.left = new NodeC('f');
        tree.root.right.right = new NodeC('g');
        tree.root.left.left.left = new NodeC('h');
        tree.root.left.left.right = new NodeC('i');
        tree.root.left.right.left = new NodeC('j');
        tree.root.left.right.right = new NodeC('k');
        tree.root.right.left.left = new NodeC('l');
        tree.root.right.left.right = new NodeC('m');
        tree.root.right.right.left = new NodeC('n');
        tree.root.right.right.right = new NodeC('o');
        System.out.println("Inorder Traversal of given tree");
        tree.printInorder();

        tree.reverseAlternate();
        System.out.println("");
        System.out.println("");
        System.out.println("Inorder Traversal of modified tree");
        tree.printInorder();
    }
}
