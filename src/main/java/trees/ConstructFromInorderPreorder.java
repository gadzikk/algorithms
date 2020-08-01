package trees;

import zobjects.NodeC;

/**
 * Created by gadzik on 31.07.20.
 */
public class ConstructFromInorderPreorder {

    NodeC root;
    static int preIndex = 0;

    NodeC buildTree(char in[], char pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex  and increment preIndex */
        NodeC tNode = new NodeC(pre[preIndex]);
        preIndex++;

        /* If this node has no children then return */
        if (inStrt == inEnd) {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    int search(char arr[], int start, int end, char value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(NodeC node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[]) {
        ConstructFromInorderPreorder tree = new ConstructFromInorderPreorder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        NodeC root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
