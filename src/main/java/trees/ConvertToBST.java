package trees;

import zobjects.Node;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by gadzik on 02.08.20.
 */
public class ConvertToBST {
    // https://www.techiedelight.com/convert-binary-tree-to-bst-maintaining-original-structure/

    public static void extractKeys(Node root, Set<Integer> set) {
        if (root == null) {
            return;
        }

        extractKeys(root.left, set);
        set.add(root.data);
        extractKeys(root.right, set);
    }

    public static void convertToBST(Node root, Iterator<Integer> it) {
        if (root == null) {
            return;
        }

        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);
    }

    public static void doConversion(Node root) {
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);

        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /* Construct below tree
				  8
				/   \
		       /     \
		      3       5
		     / \     / \
		    /   \   /   \
		   10    2 4     6
		*/

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        doConversion(root);
        inorder(root);
    }
}
