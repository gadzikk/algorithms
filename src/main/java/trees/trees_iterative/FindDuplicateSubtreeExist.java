package trees.trees_iterative;

import zobjects.NodeC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 08.08.20.
 */
public class FindDuplicateSubtreeExist {
    // https://www.geeksforgeeks.org/duplicate-subtree-in-binary-tree-set-2/

    static HashSet<String> subtrees = new HashSet<>();

    static boolean dupSubUtil(NodeC root) {

        Queue<NodeC> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            NodeC n = bfs.peek();
            bfs.remove();

            char left = ' ', right = ' ';

            if (n.left != null) {
                left = n.left.data;
                bfs.add(n.left);
            }

            if (n.right != null) {
                right = n.right.data;
                bfs.add(n.right);
            }

            String subt = "";
            subt += n.data;
            subt += left;
            subt += right;

            if (left != ' ' || right != ' ') {

                if (!subtrees.contains(subt)) {
                    return true;
                }
            }
        }
        return false;
    }

    static NodeC newNode(char key) {
        NodeC node = new NodeC();
        node.data = key;
        node.left = node.right = null;
        return node;
    }

    public static void main(String[] args) {
        NodeC root = newNode('A');
        root.left = newNode('B');
        root.right = newNode('C');
        root.left.left = newNode('D');
        root.left.right = newNode('E');
        root.right.right = newNode('B');
        root.right.right.right = newNode('E');
        root.right.right.left = newNode('D');
        if (dupSubUtil(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
