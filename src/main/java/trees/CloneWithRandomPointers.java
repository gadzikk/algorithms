package trees;

import zobjects.NodeR;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gadzik on 30.07.20.
 */
public class CloneWithRandomPointers {
    // https://www.techiedelight.com/clone-a-binary-tree-with-random-pointers/

    public static void preorder(NodeR root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " -> (");
        System.out.print((root.left != null ? root.left.data : "X") + ", ");
        System.out.print((root.right != null ? root.right.data : "X") + ", ");
        System.out.println((root.random != null ? root.random.data : "X") + ")");
        preorder(root.left);
        preorder(root.right);
    }

    // Recursive function to copy random pointers from the original binary tree
    // into the cloned binary tree using the map
    public static void updateRandomPointers(NodeR root, Map<NodeR, NodeR> map)
    {
        if (map.get(root) == null) {
            return;
        }

        map.get(root).random = map.get(root.random);
        updateRandomPointers(root.left, map);
        updateRandomPointers(root.right, map);
    }

    // Recursive function to clone the data, left and right pointers for
    // each node of a binary tree into a given map
    public static NodeR cloneLeftRightPointers(NodeR root, Map<NodeR, NodeR> map)
    {
        if (root == null) {
            return null;
        }

        // clone all fields of the root node except the random pointer
        // create a new node with same data as root node
        map.put(root, new NodeR(root.data));
        map.get(root).left = cloneLeftRightPointers(root.left, map);
        map.get(root).right = cloneLeftRightPointers(root.right, map);
        return map.get(root);
    }

    // Main function to clone a special binary tree with random pointers
    public static NodeR cloneSpecialBinaryTree(NodeR root)
    {
        Map<NodeR, NodeR> map = new HashMap<>();
        cloneLeftRightPointers(root, map);
        updateRandomPointers(root, map);
        return map.get(root);
    }

    public static void main(String[] args)
    {
        NodeR root = new NodeR(1);
        root.left = new NodeR(2);
        root.right = new NodeR(3);
        root.left.left = new NodeR(4);
        root.left.right = new NodeR(5);
        root.right.left = new NodeR(6);
        root.right.right = new NodeR(7);

        root.random = root.right.left.random;
        root.left.left.random = root.right;
        root.left.right.random = root;
        root.right.left.random = root.left.left;
        root.random = root.left;

        System.out.println("Preorder traversal of the original tree:");
        preorder(root);

        NodeR clone = cloneSpecialBinaryTree(root);

        System.out.println("\nPreorder traversal of the cloned tree:");
        preorder(clone);
    }
}
