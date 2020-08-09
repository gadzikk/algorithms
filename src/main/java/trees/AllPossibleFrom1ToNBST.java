package trees;

import zobjects.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 09.08.20.
 */
public class AllPossibleFrom1ToNBST {
    // https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
    static List<Node> constructTrees(int start, int end) {

        List<Node> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<Node> leftSubtree = constructTrees(start, i - 1);
            List<Node> rightSubtree = constructTrees(i + 1, end);

            for (int j = 0; j < leftSubtree.size(); j++) {
                Node left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    Node right = rightSubtree.get(k);
                    Node node = new Node(i);        // making value i as root
                    node.left = left;              // connect left subtree
                    node.right = right;            // connect right subtree
                    list.add(node);                // add this tree to list
                }
            }
        }
        return list;
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String args[]) {
        List<Node> totalTreesFrom1toN = constructTrees(1, 3);
        System.out.println("Preorder traversals of all constructed BSTs are ");
        for (int i = 0; i < totalTreesFrom1toN.size(); i++) {
            preorder(totalTreesFrom1toN.get(i));
            System.out.println();
        }
    }
}
