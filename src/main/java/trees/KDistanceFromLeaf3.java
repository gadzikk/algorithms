package trees;

import zobjects.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromLeaf3 {
    // https://www.techiedelight.com/find-all-nodes-at-given-distance-from-leaf-nodes-in-a-binary-tree/
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void leafNodeDistance(Node node, List<Node> path, Set<Node> set, int dist) {
        if (node == null) {
            return;
        }

        if (isLeaf(node) && path.size() >= dist) {
            set.add(path.get(path.size() - dist));
            return;
        }

        path.add(node);

        leafNodeDistance(node.left, path, set, dist);
        leafNodeDistance(node.right, path, set, dist);

        path.remove(node);
    }

    public static void leafNodeDistance(Node node, int dist) {
        List<Node> path = new ArrayList<>();
        Set<Node> set = new HashSet<>();

        leafNodeDistance(node, path, set, dist);

        for (Node e : set) {
            System.out.print(e.data + " ");
        }
    }

    public static void main(String[] args) {
        /* Construct below tree
                  15
		        /    \
		       /      \
		      10       20
		     / \      /  \
		    8   12   16  25
		            /
		           18
		*/

        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.left.left = new Node(18);

        int dist = 1;
        leafNodeDistance(root, dist);
    }
}
