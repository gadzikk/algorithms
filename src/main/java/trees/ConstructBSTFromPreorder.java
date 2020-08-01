package trees;

import zobjects.Index;
import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class ConstructBSTFromPreorder {
    // https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
    Index index = new Index();

    // A recursive function to construct Full from pre[]. preIndex is used
    // to keep track of index in pre[].
    Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {

        if (preIndex.index >= size || low > high) {
            return null;
        }

        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        if (low == high) {
            return root;
        }

        int i;
        for (i = low; i <= high; ++i) {
            if (root.data < pre[i]) {
                break;
            }
        }

        // Use the index of element found in preorder to divide preorder array in two parts. Left subtree and right subtree
        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);

        return root;
    }

    Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        ConstructBSTFromPreorder tree = new ConstructBSTFromPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}
