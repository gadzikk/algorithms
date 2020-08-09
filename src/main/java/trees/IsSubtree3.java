package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 04.08.20.
 */
public class IsSubtree3 {
    // https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree-using-preorder-traversal-iterative

    static boolean areTreeIdentical(Node t1, Node t2) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node temp1;
        Node temp2;
        s1.add(t1);
        s2.add(t2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            temp1 = s1.peek();
            temp2 = s2.peek();
            s1.pop();
            s2.pop();

            if (temp1 == null && temp2 == null) {
                continue;
            }

            if ((temp1 == null && temp2 != null) || (temp1 != null && temp2 == null)) {
                return false;
            }

            if (temp1.data != temp2.data) {
                return false;
            }

            s1.add(temp1.right);
            s2.add(temp2.right);

            s1.add(temp1.left);
            s2.add(temp2.left);
        }

        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isSubTree(Node s, Node t) {
        Stack<Node> stk = new Stack<Node>();
        Node temp;
        stk.add(t);
        while (!stk.isEmpty()) {
            temp = stk.peek();
            stk.pop();

            if (temp.data == s.data) {
                if (areTreeIdentical(s, temp)) {
                    return true;
                }
            }
            if (temp.right != null) {
                stk.add(temp.right);
            }
            if (temp.left != null) {
                stk.add(temp.left);
            }
        }
        return false;
    }

    static Node newNode(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
    /*
            1
           / \
          2      3
         / \ / \
        4  5 6  7
    */
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
    /*
         2
        / \
       4   5
    */

        Node root2 = newNode(2);
        root2.left = newNode(4);
        root2.right = newNode(5);
        if (isSubTree(root2, root))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

}
