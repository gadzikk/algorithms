package trees.trees_iterative;

import zobjects.Node;

import java.util.*;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromTarget2 {
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
    Map<Node, Node> parent;

    public List<Integer> distanceK(Node root, Node target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<Node> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<Node> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (Node n : queue) {
                        ans.add(n.data);
                    }
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                Node par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(Node node, Node par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
