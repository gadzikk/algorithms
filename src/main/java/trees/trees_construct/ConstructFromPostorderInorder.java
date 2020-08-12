package trees.trees_construct;

import zobjects.Index;
import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class ConstructFromPostorderInorder {
    // https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
    Node buildUtil(int inorder[], int postorder[], int inStart, int inEnd, Index pIndex) {

        if (inStart > inEnd) {
            return null;
        }

        Node node = new Node(postorder[pIndex.index]);
        pIndex.index--;

        if (inStart == inEnd) {
            return node;
        }

        int iIndex = search(inorder, inStart, inEnd, node.data);

        node.right = buildUtil(inorder, postorder, iIndex + 1, inEnd, pIndex);
        node.left = buildUtil(inorder, postorder, inStart, iIndex - 1, pIndex);

        return node;
    }

    Node buildTree(int in[], int post[], int n) {
        Index pIndex = new Index();
        pIndex.index = n - 1;
        return buildUtil(in, post, 0, n - 1, pIndex);
    }

    int search(int arr[], int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                break;
            }
        }
        return i;
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        ConstructFromPostorderInorder tree = new ConstructFromPostorderInorder();
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        Node root = tree.buildTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}
