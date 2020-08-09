package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by gadzik on 08.08.20.
 */
public class TopView4 {
    // https://www.geeksforgeeks.org/print-nodes-in-the-top-view-of-binary-tree-set-3/
    static class Pair {
        Node first;
        int second;

        Pair(Node n, int a) {
            first = n;
            second = a;
        }
    }

    ;

    // function to create a new node
    static Node newNode(int key) {
        Node node = new Node();
        node.left = node.right = null;
        node.data = key;
        return node;
    }

    static void topView(Node root) {
        if (root == null) {
            return;
        }

        Node temp = null;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        q.add(new Pair(root, 0));

        // BFS
        while (q.size() > 0) {
            temp = q.peek().first;
            int d = q.peek().second;
            q.remove();

            if (treeMap.get(d) == null) {
                treeMap.put(d, temp.data);
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, d - 1));
            }

            if (temp.right != null) {
                q.add(new Pair(temp.right, d + 1));
            }
        }

        for (Integer data : treeMap.values()) {
            System.out.print(data + " ");
        }
    }

    public static void main(String args[]) {
    /* Create following Binary Tree
         1
        / \
        2 3
        \
         4
          \
           5
            \
             6*/
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.left.right.right = newNode(5);
        root.left.right.right.right = newNode(6);
        System.out.println("Following are nodes in top view of Binary Tree\n");
        topView(root);
    }
}
