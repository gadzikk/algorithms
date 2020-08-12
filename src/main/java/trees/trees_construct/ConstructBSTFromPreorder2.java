package trees.trees_construct;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 31.07.20.
 */
public class ConstructBSTFromPreorder2 {
    // https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2
    Node constructTree(int pre[], int size) {

        Node root = new Node(pre[0]);
        Stack<Node> s = new Stack<>();
        s.push(root);

        for (int i = 1; i < size; ++i) {
            Node temp = null;

            /* Keep on popping while the next value is greater than stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            } else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        ConstructBSTFromPreorder2 tree = new ConstructBSTFromPreorder2();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}
