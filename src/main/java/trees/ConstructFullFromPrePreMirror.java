package trees;

import zobjects.Node;

/**
 * Created by gadzik on 04.08.20.
 */
public class ConstructFullFromPrePreMirror {
    // https://www.geeksforgeeks.org/construct-full-binary-tree-using-preorder-traversal-preorder-traversal-mirror-tree/
    static class INT {
        int a;

        INT(int a) {
            this.a = a;
        }
    }

    static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.printf("%d ", node.data);
        printInorder(node.right);
    }

    static Node conBinaryTreeUtil(int pre[], int preM[], INT preIndex, int low, int high, int size) {
        if (preIndex.a >= size || low > high) {
            return null;
        }

        Node root = newNode(pre[preIndex.a]);
        ++preIndex.a;

        if (low == high) {
            return root;
        }

        int i;
        for (i = low; i <= high; ++i) {
            if (pre[preIndex.a] == preM[i]) {
                break;
            }
        }

        if (i <= high) {
            root.left = conBinaryTreeUtil(pre, preM, preIndex, i, high, size);
            root.right = conBinaryTreeUtil(pre, preM, preIndex, low + 1, i - 1, size);
        }

        return root;
    }

    static void conBinaryTree(Node root, int pre[], int preMirror[], int size) {
        INT preIndex = new INT(0);

        root = conBinaryTreeUtil(pre, preMirror, preIndex, 0, size - 1, size);
        printInorder(root);
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String args[]) {
        int preOrder[] = {1, 2, 4, 5, 3, 6, 7};
        int preOrderMirror[] = {1, 3, 7, 6, 2, 5, 4};

        int size = preOrder.length;
        Node root = new Node();
        conBinaryTree(root, preOrder, preOrderMirror, size);
    }
}
