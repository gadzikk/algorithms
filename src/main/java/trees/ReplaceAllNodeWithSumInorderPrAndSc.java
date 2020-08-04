package trees;

import zobjects.Node;

import java.util.Vector;

/**
 * Created by gadzik on 04.08.20.
 */
public class ReplaceAllNodeWithSumInorderPrAndSc {
    // https://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor
    static class INT {
        int data;
    }


    static void storeInorderTraversal(Node root, Vector<Integer> arr) {
        if (root == null) {
            return;
        }

        storeInorderTraversal(root.left, arr);
        arr.add(root.data);
        storeInorderTraversal(root.right, arr);
    }

    static void replaceNodeWithSum(Node root,
                                   Vector<Integer> arr, INT i) {
        if (root == null) {
            return;
        }

        replaceNodeWithSum(root.left, arr, i);
        root.data = arr.get(i.data - 1) + arr.get(i.data + 1);

        i.data++;
        replaceNodeWithSum(root.right, arr, i);
    }

    static void replaceNodeWithSumUtil(Node root) {
        if (root == null) {
            return;
        }

        Vector<Integer> arr = new Vector<>();

        arr.add(0);
        storeInorderTraversal(root, arr);
        arr.add(0);

        INT counter = new INT();
        counter.data = 1;
        replaceNodeWithSum(root, arr, counter);
    }

    static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static Node getNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.left = new_node.right = null;
        return new_node;
    }

    public static void main(String args[]) {
        Node root = getNode(1);       //         1
        root.left = getNode(2);        //       /   \
        root.right = getNode(3);       //     2      3
        root.left.left = getNode(4);  //    /  \  /   \
        root.left.right = getNode(5); //   4   5  6   7
        root.right.left = getNode(6);
        root.right.right = getNode(7);

        System.out.println("Preorder Traversal before tree modification:");
        preorderTraversal(root);

        replaceNodeWithSumUtil(root);

        System.out.println("\nPreorder Traversal after tree modification:");
        preorderTraversal(root);

    }


}
