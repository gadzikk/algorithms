package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 09.08.20.
 */
public class CountPairsSumEqualToXBST {
    // https://www.geeksforgeeks.org/count-pairs-from-two-bsts-whose-sum-is-equal-to-a-given-value-x/
    static Node root1;
    static Node root2;

    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null) {
            return 0;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node top1, top2;

        int count = 0;

        while (true) {

            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }

            if (st1.empty() || st2.empty()) {
                break;
            }

            top1 = st1.peek();
            top2 = st2.peek();

            if ((top1.data + top2.data) == x) {
                count++;

                st1.pop();
                st2.pop();

                root1 = top1.right;
                root2 = top2.left;
            } else if ((top1.data + top2.data) < x) {
                st1.pop();
                root1 = top1.right;
            } else {
                st2.pop();
                root2 = top2.left;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        root1 = new Node(5);       /*             5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8    */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // formation of BST 2
        root2 = new Node(10);        /*           10         */
        root2.left = new Node(6); /*           /   \        */
        root2.right = new Node(15); /*        6     15      */
        root2.left.left = new Node(3); /*    / \   /  \     */
        root2.left.right = new Node(8); /*  3  8  11  18    */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;
        System.out.println("Pairs = " + countPairs(root1, root2, x));
    }
}
