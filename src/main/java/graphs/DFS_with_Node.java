package graphs;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 17.06.20.
 */
public class DFS_with_Node {

    public void DFS(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (s.isEmpty() == false) {
            Node x = s.pop();
            if (x.right != null) {
                s.add(x.right);
            }
            if (x.left != null) {
                s.add(x.left);
            }
            System.out.print(" " + x.data);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        DFS_with_Node b = new DFS_with_Node();
        System.out.println("Depth-First-Search : ");
        b.DFS(root);
    }
}
