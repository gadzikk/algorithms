package trees;

import zobjects.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gadzik on 01.08.20.
 */
public class VerticalWidth2 {
    // https://www.geeksforgeeks.org/vertical-width-binary-tree-set-2/
    Node root;

    void fillSet(Node root, Set<Integer> set, int horizontalDistnace) {
        if (root == null) {
            return;
        }
        fillSet(root.left, set, horizontalDistnace - 1);
        set.add(horizontalDistnace);
        fillSet(root.right, set, horizontalDistnace + 1);
    }


    int verticalWidth(Node root) {
        Set<Integer> set = new HashSet<>();

        fillSet(root, set, 0);
        return set.size();
    }

    public static void main(String args[]) {
        VerticalWidth2 tree = new VerticalWidth2();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        System.out.println(tree.verticalWidth(tree.root));

    }

}
