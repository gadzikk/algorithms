package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class LowestCommonAncestor {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    Node root;

    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    Node findLCA(Node node, int n1, int n2)
    {
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node leftLca = findLCA(node.left, n1, n2);
        Node rightLca = findLCA(node.right, n1, n2);

        if (leftLca!=null && rightLca!=null) {
            return node;
        }

        return (leftLca != null) ? leftLca : rightLca;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
    }
}
