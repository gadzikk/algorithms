package trees;

import zobjects.NodeC;

/**
 * Created by gadzik on 30.07.20.
 */
public class ConvertTernaryExpressionRec {
    // https://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/

    NodeC convertExpression(char[] expression, int i) {
        if (i >= expression.length)
            return null;

        // store current character of expression_string [ 'a' to 'z']
        NodeC root = new NodeC(expression[i]);
        ++i;

        if (i < expression.length && expression[i] == '?') {
            // if current character of ternary expression is '?' then we add next character as a left child of current node
            root.left = convertExpression(expression, i + 1);

        } else if (i < expression.length) {
            // else we have to add it as a right child of current node expression.at(0) == ':'
            root.right = convertExpression(expression, i + 1);
        }
        return root;
    }

    public void printTree(NodeC root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String args[]) {
        String exp = "a?b?c:d:e";
        ConvertTernaryExpressionRec tree = new ConvertTernaryExpressionRec();
        char[] expression = exp.toCharArray();
        NodeC root = tree.convertExpression(expression, 0);
        tree.printTree(root);
    }
}
