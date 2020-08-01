package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 01.08.20.
 */
public class GetLevelOfNode2 {
    // https://www.geeksforgeeks.org/get-level-node-binary-tree-iterative-approach/
    static int getLevel(Node root, int data) {
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);

        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                level += 1;
            } else {
                if (temp.data == data) {
                    return level;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.left.right.left = new Node(12);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        // return level of node
        int level = getLevel(root, 30);
        if (level != 0)
            System.out.println("level of node 30 is " + level);
        else
            System.out.println("node 30 not found");

        level = getLevel(root, 12);
        if (level != 0)
            System.out.println("level of node 12 is " + level);
        else
            System.out.println("node 12 not found");

        level = getLevel(root, 25);
        if (level != 0)
            System.out.println("level of node 25 is " + level);
        else
            System.out.println("node 25 not found");

        level = getLevel(root, 27);
        if (level != 0)
            System.out.println("level of node 27 is " + level);
        else
            System.out.println("node 27 not found");
    }
}
