package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 31.07.20.
 */
public class LevelWithMaxNumberOfNodes {
    // https://www.geeksforgeeks.org/level-maximum-number-nodes/


    static int maxNodeLevel(Node root) {
        if (root == null) {
            return -1;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int currentLevel = 0;
        int maxNodes = Integer.MIN_VALUE;
        int level_no = 0;

        while (true) {
            int NodeCount = q.size();

            if (NodeCount == 0) {
                break;
            }

            if (maxNodes < NodeCount) {
                maxNodes = NodeCount;
                level_no = currentLevel;
            }

            while (NodeCount > 0) {
                Node Node = q.peek();
                q.remove();
                if (Node.left != null) {
                    q.add(Node.left);
                }
                if (Node.right != null) {
                    q.add(Node.right);
                }
                NodeCount--;
            }
            currentLevel++;
        }

        return level_no;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return (node);
    }

    // Driver program to test above
    public static void main(String[] args) {
        // binary tree formation
        Node root = newNode(2);     /*     2     */
        root.left = newNode(1);     /*     / \ */
        root.right = newNode(3);     /*     1     3     */
        root.left.left = newNode(4);     /* / \ \ */
        root.left.right = newNode(6);     /* 4     6 8 */
        root.right.right = newNode(8); /*     /     */
        root.left.right.left = newNode(5);/*     5     */

        System.out.println("Level having maximum number of Nodes : " + maxNodeLevel(root));
    }
}
