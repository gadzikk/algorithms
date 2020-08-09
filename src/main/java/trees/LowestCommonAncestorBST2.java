package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class LowestCommonAncestorBST2 {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    Node root;

    /* Function to find LCA of n1 and n2.
    The function assumes that both
    n1 and n2 are present in BST */
    static Node lca(Node root, int n1, int n2) {
        while (root != null) {
            if (root.data > n1 && root.data > n2) {
                root = root.left;
            } else if (root.data < n1 && root.data < n2) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }


    /* Driver program to test lca() */
    public static void main(String args[]) {
        LowestCommonAncestorBST2 tree = new LowestCommonAncestorBST2();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
}
