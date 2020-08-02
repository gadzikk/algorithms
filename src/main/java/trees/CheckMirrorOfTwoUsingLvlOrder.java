package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 02.08.20.
 */
public class CheckMirrorOfTwoUsingLvlOrder {
    // https://www.geeksforgeeks.org/check-if-two-trees-are-mirror-of-each-other-using-level-order-traversal/?ref=rp
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static String areMirrors(Node a, Node b) {

        if (a == null && b == null) {
            return "Yes";
        }

        if (a == null || b == null) {
            return "No";
        }

        Queue<Node> q = new LinkedList<>();
        q.add(a);
        q.add(b);

        while (q.size() > 0) {
            a = q.peek();
            q.remove();
            b = q.peek();
            q.remove();

            if (a.data != b.data) {
                return "No";
            }

            if (a.left != null && b.right != null) {
                q.add(a.left);
                q.add(b.right);
            } else if (a.left != null || b.right != null) {
                return "No";
            }

            if (a.right != null && b.left != null) {
                q.add(a.right);
                q.add(b.left);
            } else if (a.right != null || b.left != null) {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String args[]) {
        // 1st binary tree formation
    /*
            1
        / \
        3 2
            / \
            5 4
        */
        Node root1 = newNode(1);
        root1.left = newNode(3);
        root1.right = newNode(2);
        root1.right.left = newNode(5);
        root1.right.right = newNode(4);

        // 2nd binary tree formation
    /*
            1
        / \
        2 3
        / \
        4 5
        */
        Node root2 = newNode(1);
        root2.left = newNode(2);
        root2.right = newNode(3);
        root2.left.left = newNode(4);
        root2.left.right = newNode(5);

        System.out.print(areMirrors(root1, root2));
    }
}
