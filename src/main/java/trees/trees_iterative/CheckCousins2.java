package trees.trees_iterative;

import zobjects.Node;
import zobjects.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 06.08.20.
 */
public class CheckCousins2 {
    // https://www.geeksforgeeks.org/check-if-two-nodes-are-cousins-in-a-binary-tree-set-2/
    Node root;

    boolean isCousin(Node node, Node a, Node b) {
        if (node == null) {
            return false;
        }

        Node parA = null;
        Node parB = null;
        Queue<Pair<Node, Node>> q = new LinkedList<>();

        Node tmp = new Node(-1);
        Pair<Node, Node> ele;
        q.add(new Pair<Node, Node>(node, tmp));

        int levelSize;

        while (!q.isEmpty()) {

            levelSize = q.size();
            while (levelSize != 0) {
                ele = q.peek();
                q.remove();

                if (ele.getKey().data == a.data) {
                    parA = ele.getValue();
                }

                if (ele.getKey().data == b.data) {
                    parB = ele.getValue();
                }

                if (ele.getKey().left != null) {
                    q.add(new Pair<Node, Node>(ele.getKey().left, ele.getKey()));
                }

                if (ele.getKey().right != null) {
                    q.add(new Pair<Node, Node>(ele.getKey().right, ele.getKey()));
                }

                levelSize--;

                if (parA != null && parB != null) {
                    break;
                }
            }

            if (parA != null && parB != null) {
                return parA != parB;
            }

            if ((parA != null && parB == null) || (parB != null && parA == null)) {
                return false;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        CheckCousins2 tree = new CheckCousins2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        Node Node1, Node2;
        Node1 = tree.root.left.right.right;
        Node2 = tree.root.right.left.right;
        if (tree.isCousin(tree.root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
