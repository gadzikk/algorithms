package trees;

import zobjects.Node;

/**
 * Created by gadzik on 01.08.20.
 */
public class SumRightLeafs {
    // https://www.geeksforgeeks.org/find-sum-right-leaves-given-binary-tree/
    static int sum = 0;

    static void rightLeafSum(Node root) {
        if (root == null) {
            return;
        }


        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                sum += root.right.data;
            }
        }

        rightLeafSum(root.left);
        rightLeafSum(root.right);
    }

    static Node addNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String args[]) {

        Node root = addNode(1);
        root.left = addNode(2);
        root.left.left = addNode(4);
        root.left.right = addNode(5);
        root.left.left.right = addNode(2);
        root.right = addNode(3);
        root.right.right = addNode(8);
        root.right.right.left = addNode(6);
        root.right.right.right = addNode(7);

        sum = 0;
        rightLeafSum(root);
        System.out.println(sum);
    }
}
