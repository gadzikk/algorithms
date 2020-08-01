package trees;

import zobjects.Node;

/**
 * Created by gadzik on 30.07.20.
 */
public class CountLeafRec {
    // https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
    Node root;

    /* Function to get the count of leaf nodes in a binary tree*/
    int getLeafCount() {
        return getLeafCount(root);
    }

    int getLeafCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        /* create a tree */
        CountLeafRec tree = new CountLeafRec();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : "
                + tree.getLeafCount());
    }
}
