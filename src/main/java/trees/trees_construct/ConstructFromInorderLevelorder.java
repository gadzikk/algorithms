package trees.trees_construct;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class ConstructFromInorderLevelorder {
    // https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
    Node root;

    Node buildTree(int in[], int level[]) {
        Node startnode = null;
        return constructTree(startnode, level, in, 0, in.length - 1);
    }

    Node constructTree(Node startNode, int[] levelOrder, int[] inOrder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        if (inStart == inEnd) {
            return new Node(inOrder[inStart]);
        }

        boolean found = false;
        int index = 0;

        for (int i = 0; i < levelOrder.length - 1; i++) {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) {
                if (data == inOrder[j]) {
                    startNode = new Node(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found == true)
                break;
        }

        startNode.left = (constructTree(startNode, levelOrder, inOrder, inStart, index - 1));
        startNode.right = (constructTree(startNode, levelOrder, inOrder, index + 1, inEnd));
        return startNode;
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        ConstructFromInorderLevelorder tree = new ConstructFromInorderLevelorder();
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        int n = in.length;
        Node node = tree.buildTree(in, level);
        System.out.print("Inorder traversal of the constructed tree is ");
        tree.printInorder(node);
    }
}
