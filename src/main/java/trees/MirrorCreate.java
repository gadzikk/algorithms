package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class MirrorCreate {
    // https://www.geeksforgeeks.org/create-a-mirror-tree-from-the-given-binary-tree/

    static Node mirrorify(Node root) {
        if (root == null) {
            return null;
        }

        Node mirror = createNode(root.data);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }

    static Node createNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void main(String args[]) {
        Node tree = createNode(5);
        tree.left = createNode(3);
        tree.right = createNode(6);
        tree.left.left = createNode(2);
        tree.left.right = createNode(4);

        System.out.print("Inorder of original tree: ");
        inorder(tree);
        Node mirror = null;
        mirror = mirrorify(tree);

        System.out.print("\nInorder of mirror tree: ");
        inorder(mirror);
    }
}
