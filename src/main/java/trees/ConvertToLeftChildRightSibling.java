package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class ConvertToLeftChildRightSibling {
    // https://www.techiedelight.com/convert-normal-binary-tree-left-child-right-sibling-binary-tree/
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void convert(Node root) {
        if (root == null) {
            return;
        }

        convert(root.left);
        convert(root.right);

        if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else {
            root.left.right = root.right;
            root.right = null;
        }
    }

    public static void main(String[] args) {
        /* Construct below Tree
	              1
	            /  \
	           /    \
	          2      3
	         / \    /
	        4   5  6
	              / \
	             7   8
	    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        convert(root);
        preorder(root);
    }
}
