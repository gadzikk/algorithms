package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class CommonAncestors {
    // https://www.geeksforgeeks.org/print-common-nodes-path-root-common-ancestors/
    static Node root;

    static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = findLCA(root.left, n1, n2);
        Node rightLca = findLCA(root.right, n1, n2);

        if (leftLca != null && rightLca != null) {
            return root;
        }

        return (leftLca != null) ? leftLca : rightLca;
    }

    static boolean printAncestors(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            System.out.print(root.data + " ");
            return true;
        }

        if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

    static boolean findCommonNodes(Node root, int first, int second) {
        Node LCA = findLCA(root, first, second);
        if (LCA == null) {
            return false;
        }

        printAncestors(root, LCA.data);
        return true;
    }

    public static void main(String args[]) {
        CommonAncestors tree = new CommonAncestors();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(10);

        if (findCommonNodes(root, 9, 7) == false)
            System.out.println("No Common nodes");

    }
}
