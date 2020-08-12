package trees.trees_iterative;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 08.08.20.
 */
public class NextRightNode2 {
    // https://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
    Node root;

    Node nextRight(Node first, int k) {
        if (first == null) {
            return null;
        }

        Queue<Node> queueNodes = new LinkedList<>();
        Queue<Integer> queueLevels = new LinkedList<>();

        int level = 0;

        queueNodes.add(first);
        queueLevels.add(level);

        while (queueNodes.size() != 0) {
            Node node = queueNodes.peek();
            level = queueLevels.peek();
            queueNodes.remove();
            queueLevels.remove();

            if (node.data == k) {
                if (queueLevels.size() == 0 || queueLevels.peek() != level) {
                    return null;
                }

                return queueNodes.peek();
            }

            if (node.left != null) {
                queueNodes.add(node.left);
                queueLevels.add(level + 1);
            }
            if (node.right != null) {
                queueNodes.add(node.right);
                queueLevels.add(level + 1);
            }
        }

        return null;
    }

    void test(Node node, int k) {
        Node nr = nextRight(root, k);
        if (nr != null) {
            System.out.println("Next Right of " + k + " is " + nr.data);
        }
        else {
            System.out.println("No next right node found for " + k);
        }
    }

    public static void main(String args[]) {
        NextRightNode2 tree = new NextRightNode2();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.right.right = new Node(5);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(4);

        tree.test(tree.root, 10);
        tree.test(tree.root, 2);
        tree.test(tree.root, 6);
        tree.test(tree.root, 5);
        tree.test(tree.root, 8);
        tree.test(tree.root, 4);

    }
}
