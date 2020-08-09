package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gadzik on 09.08.20.
 */
public class LowestCommonAncestorParent {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer

    class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            left = right = parent = null;
        }
    }

    Node root, n1, n2, lca;

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
            node.left.parent = node;
        } else if (key > node.key) {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }

        return node;
    }

    Node LCA(Node n1, Node n2) {
        Map<Node, Boolean> ancestors = new HashMap<>();

        while (n1 != null) {
            ancestors.put(n1, Boolean.TRUE);
            n1 = n1.parent;
        }

        while (n2 != null) {
            if (ancestors.containsKey(n2) != ancestors.isEmpty()) {
                return n2;
            }
            n2 = n2.parent;
        }

        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorParent tree = new LowestCommonAncestorParent();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.left;
        tree.lca = tree.LCA(tree.n1, tree.n2);

        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
    }

}
