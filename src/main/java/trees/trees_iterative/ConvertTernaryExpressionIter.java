package trees.trees_iterative;

import zobjects.NodeC;

import java.util.Stack;

/**
 * Created by gadzik on 30.07.20.
 */
public class ConvertTernaryExpressionIter {
    // https://stackoverflow.com/questions/28487831/how-to-convert-a-ternary-expression-to-a-binary-tree-structure
    public NodeC tenaryToTree(String s) {
        if (s.length() == 0) {
            return null;
        }

        NodeC root = new NodeC(s.charAt(0));
        Stack<NodeC> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                NodeC node = stack.peek();
                node.left = new NodeC(s.charAt(i + 1));
                stack.push(node.left);
            } else if (s.charAt(i) == ':') {
                stack.pop();
                NodeC node = stack.pop();
                node.right = new NodeC(s.charAt(i + 1));
                stack.push(node.right);
            }
        }

        return root;
    }

}
