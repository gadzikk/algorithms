package trees;

import zobjects.NodeC;

import java.util.Stack;

/**
 * Created by gadzik on 31.07.20.
 */
public class Expression {
    // https://www.geeksforgeeks.org/expression-tree/
    // https://www.geeksforgeeks.org/evaluation-of-expression-tree/
    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    // Utility function to do inorder traversal
    void inorder(NodeC t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }

    // Returns root of constructed tree for given
    // postfix expression
    NodeC constructTree(char postfix[]) {
        Stack<NodeC> st = new Stack();
        NodeC t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new NodeC(postfix[i]);
                st.push(t);
            } else {
                // operator
                t = new NodeC(postfix[i]);

                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2); Add this subexpression to stack
                st.push(t);
            }
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String args[]) {
        Expression et = new Expression();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        NodeC root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);

    }
}
