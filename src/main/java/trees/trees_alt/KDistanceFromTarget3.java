package trees.trees_alt;

import zobjects.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromTarget3 {
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
    List<Integer> ans;
    Node target;
    int K;

    public List<Integer> distanceK(Node root, Node target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(Node node) {
        if (node == null) {
            return -1;
        } else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int left = dfs(node.left);
            int right = dfs(node.right);
            if (left != -1) {
                if (left == K) {
                    ans.add(node.data);
                }
                subtree_add(node.right, left + 1);
                return left + 1;
            } else if (right != -1) {
                if (right == K) {
                    ans.add(node.data);
                }
                subtree_add(node.left, right + 1);
                return right + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(Node node, int dist) {
        if (node == null) {
            return;
        }
        if (dist == K) {
            ans.add(node.data);
        } else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
