package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 02.08.20.
 */
public class ZigZagTravesal {
    // https://www.geeksforgeeks.org/zigzag-tree-traversal/
    Node rootNode;

    void printZigZagTraversal() {
        if (rootNode == null) {
            return;
        }

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        currentLevel.push(rootNode);
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {

            Node node = currentLevel.pop();
            System.out.print(node.data + " ");
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.right != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        ZigZagTravesal tree = new ZigZagTravesal();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(7);
        tree.rootNode.left.right = new Node(6);
        tree.rootNode.right.left = new Node(5);
        tree.rootNode.right.right = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
