package trees;

import zobjects.Node;

/**
 * Created by gadzik on 04.08.20.
 */
public class ConstructFullFromPrePost {
    // https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
    static int preindex;

    static Node constructTreeUtil(int pre[], int post[], int low, int high, int size) {

        if (preindex >= size || low > high) {
            return null;
        }

        Node root = new Node(pre[preindex]);
        preindex++;

        if (low == high || preindex >= size) {
            return root;
        }

        int i;
        for (i = low; i <= high; i++) {
            if (post[i] == pre[preindex]) {
                break;
            }
        }
        if (i <= high) {
            root.left = constructTreeUtil(pre, post, low, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, high, size);
        }

        return root;
    }

    static Node constructTree(int pre[], int post[], int size) {
        preindex = 0;
        return constructTreeUtil(pre, post, 0, size - 1, size);
    }

    static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        int size = pre.length;
        Node root = constructTree(pre, post, size);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}
