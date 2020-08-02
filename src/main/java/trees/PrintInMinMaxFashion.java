package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintInMinMaxFashion {
    static int index;

    static void printMinMaxOrderUtil(Node root, int inOrder[]) {
        if (root == null) {
            return;
        }

        printMinMaxOrderUtil(root.left, inOrder);
        inOrder[index] = root.data;
        index++;
        printMinMaxOrderUtil(root.right, inOrder);
    }

    static void printMinMaxOrder(Node root) {
        int numNode = sizeOfTree(root);
        int[] inOrder = new int[numNode + 1];
        printMinMaxOrderUtil(root, inOrder);
        int i = 0;
        index--;
        while (i < index) {
            System.out.print(inOrder[i++] + " " + inOrder[index--] + " ");
        }
        if (i == index) {
            System.out.println(inOrder[i]);
        }
    }

    static int sizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);

        return (left + right + 1);
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        printMinMaxOrder(root);
    }
}
