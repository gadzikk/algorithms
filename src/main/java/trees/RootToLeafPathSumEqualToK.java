package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class RootToLeafPathSumEqualToK {
    // https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
    Node root;

    boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return sum == 0;
        }
        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }

    /* Driver program to test the above functions */
    public static void main(String args[]) {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        RootToLeafPathSumEqualToK tree = new RootToLeafPathSumEqualToK();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (tree.hasPathSum(tree.root, sum)) {
            System.out.println("There is a root to leaf path with sum " + sum);
        }
        else {
            System.out.println("There is no root to leaf path with sum " + sum);
        }
    }

}
