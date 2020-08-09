package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 07.08.20.
 */
public class AncestorNode2 {
    // https://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
    static void printAncestors(Node root, int key) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (true) {
            while (root != null && root.data != key) {
                stack.push(root);
                root = root.left;
            }

            if (root != null && root.data == key) {
                break;
            }

            if (stack.peek().right == null) {
                root = stack.peek();
                stack.pop();

                while (stack.empty() == false && stack.peek().right == root) {
                    root = stack.peek();
                    stack.pop();
                }
            }

            root = stack.empty() ? null : stack.peek().right;
        }

        while (!stack.empty()) {
            System.out.print(stack.peek().data + " ");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);

        System.out.println("Following are all keys and their ancestors");
        for (int key = 1; key <= 10; key++) {
            System.out.print(key + ": ");
            printAncestors(root, key);
            System.out.println();
        }
    }
}
