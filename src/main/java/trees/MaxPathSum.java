package trees;

import zobjects.Node;
import zobjects.Res;

/**
 * Created by gadzik on 31.07.20.
 */
public class MaxPathSum {
    // https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    Node root;

    int findMaxUtil(Node node, Res res) {

        if (node == null) {
            return 0;
        }

        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        // Max Top represents the sum when the Node under consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);
        res.val = Math.max(res.val, max_top);
        return max_single;
    }

    int findMaxSum() {
        return findMaxSum(root);
    }

    int findMaxSum(Node node) {

        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxUtil(node, res);
        return res.val;
    }

    public static void main(String args[]) {
        MaxPathSum tree = new MaxPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " + tree.findMaxSum());
    }

}
