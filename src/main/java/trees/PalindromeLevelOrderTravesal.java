package trees;

import zobjects.NodeC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by gadzik on 09.08.20.
 */
public class PalindromeLevelOrderTravesal {
    // https://www.geeksforgeeks.org/check-if-the-level-order-traversal-of-a-binary-tree-results-in-a-palindrome
    static NodeC add(char data) {
        NodeC newnode = new NodeC();
        newnode.data = data;
        newnode.left = newnode.right = null;
        return newnode;
    }

    static void findInv(NodeC root, Stack<NodeC> S) {
        if (root == null) {
            return;
        }

        Queue<NodeC> Q = new LinkedList<>();
        Q.add(root);
        while (Q.size() > 0) {
            NodeC temp = Q.peek();
            Q.remove();
            S.add(temp);

            if (temp.left != null) {
                Q.add(temp.left);
            }

            if (temp.right != null) {
                Q.add(temp.right);
            }
        }
    }

    static boolean isPalindrome(Stack<NodeC> S, NodeC root) {
        Queue<NodeC> Q = new LinkedList<>();
        Q.add(root);
        while (Q.size() > 0) {

            NodeC temp = Q.peek();

            NodeC temp1 = S.peek();
            S.pop();
            Q.remove();

            if (temp.data != temp1.data) {
                return false;
            }

            if (temp.left != null) {
                Q.add(temp.left);
            }

            if (temp.right != null) {
                Q.add(temp.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NodeC root = add('R');
        root.left = add('A');
        root.right = add('D');
        root.left.left = add('A');
        root.left.right = add('R');

        Stack<NodeC> S = new Stack<NodeC>();
        findInv(root, S);

        if (isPalindrome(S, root))
            System.out.print("Yes");
        else
            System.out.print("NO");
    }
}
