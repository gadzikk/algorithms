package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 02.08.20.
 */
public class CheckMirrorOfTwo2 {
    // https://www.geeksforgeeks.org/iterative-method-check-two-trees-mirror/?ref=rp


    static String areMirrors(Node root1, Node root2) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        while (true) {
            while (root1 != null && root2 != null) {
                if (root1.data != root2.data) {
                    return "No";
                }

                st1.push(root1);
                st2.push(root2);
                root1 = root1.left;
                root2 = root2.right;
            }

            if (!(root1 == null && root2 == null)) {
                return "No";
            }

            if (!st1.isEmpty() && !st2.isEmpty()) {
                root1 = st1.peek();
                root2 = st2.peek();
                st1.pop();
                st2.pop();

                root1 = root1.right;
                root2 = root2.left;
            } else {
                break;
            }
        }
        return "Yes";
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        // 1st binary tree formation
        Node root1 = newNode(1);         /*         1         */
        root1.left = newNode(3);         /*     / \     */
        root1.right = newNode(2);         /*     3     2     */
        root1.right.left = newNode(5);     /*         / \     */
        root1.right.right = newNode(4); /*         5     4 */

        // 2nd binary tree formation
        Node root2 = newNode(1);         /*         1         */
        root2.left = newNode(2);         /*     / \     */
        root2.right = newNode(3);         /*     2     3     */
        root2.left.left = newNode(4);     /* / \         */
        root2.left.right = newNode(5);     /* 4 5         */

        System.out.println(areMirrors(root1, root2));
    }
}
