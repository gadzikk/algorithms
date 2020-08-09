package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class ParentNode {
    //
    static void findParent(Node node, int val, int parent) {
        if (node == null) {
            return;
        }

        if (node.data == val) {
            System.out.print(parent);
        } else {
            findParent(node.left, val, node.data);
            findParent(node.right, val, node.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int node = 3;

        findParent(root, node, -1);
    }
}
