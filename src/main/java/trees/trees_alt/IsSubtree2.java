package trees.trees_alt;

import zobjects.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 04.08.20.
 */
public class IsSubtree2 {
    // https://www.techiedelight.com/determine-given-binary-tree-is-subtree-of-another-binary-tree-not/
    public static void inorder(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    public static void postorder(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node);
    }

    public static boolean checkSubtree(Node tree, Node subtree) {

        if (tree == subtree) {
            return true;
        }

        if (tree == null) {
            return false;
        }

        List<Node> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);

        if (first.toString().contains(second.toString())) {
            return false;
        }

        first.clear();
        second.clear();

        postorder(tree, first);
        postorder(subtree, second);

        if (first.toString().contains(second.toString())) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        /* Construct below tree
				  1
			   /	 \
			  2	   3
			 / \	 / \
			4   5   6   7
		*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
