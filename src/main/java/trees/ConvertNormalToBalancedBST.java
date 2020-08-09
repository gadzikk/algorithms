package trees;

import zobjects.Node;

import java.util.Vector;

/**
 * Created by gadzik on 09.08.20.
 */
public class ConvertNormalToBalancedBST {
    // https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
    Node root;

    void storeBSTNodes(Node root, Vector<Node> nodes) {
        if (root == null) {
            return;
        }

        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    Node buildTreeUtil(Vector<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
        return node;
    }

    Node buildTree(Node root) {
        Vector<Node> nodes = new Vector<>();
        storeBSTNodes(root, nodes);
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
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
         /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        ConvertNormalToBalancedBST tree = new ConvertNormalToBalancedBST();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }
}
