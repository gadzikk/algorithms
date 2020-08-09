package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class LargestPerfectSubtree {
    // https://www.geeksforgeeks.org/find-the-largest-perfect-subtree-in-a-given-binary-tree/
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    static class returnType {
        boolean isPerfect;
        int height;
        Node rootTree;
    }

    static returnType findPerfectBinaryTree(Node root) {
        returnType rt = new returnType();

        if (root == null) {
            rt.isPerfect = true;
            rt.height = 0;
            rt.rootTree = null;
            return rt;
        }

        returnType leftResult = findPerfectBinaryTree(root.left);
        returnType rightResult = findPerfectBinaryTree(root.right);

        if (leftResult.isPerfect && rightResult.isPerfect && leftResult.height == rightResult.height) {
            rt.height = leftResult.height + 1;
            rt.isPerfect = true;
            rt.rootTree = root;
            return rt;
        }

        rt.isPerfect = false;
        rt.height = Math.max(leftResult.height, rightResult.height);
        rt.rootTree = (leftResult.height > rightResult.height ? leftResult.rootTree : rightResult.rootTree);
        return rt;
    }

    static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);

        returnType ans = findPerfectBinaryTree(root);
        int h = ans.height;

        System.out.println("Size : " + (Math.pow(2, h) - 1));

        System.out.print("Inorder Traversal : ");
        inorderPrint(ans.rootTree);
    }
}
