package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class RootToLeafPathSumEqualToKBST {
    // https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number-in-bst/

    static int checkThesum(Node root, int path[], int i, int sum) {
        int sum1 = 0, x, y, j;

        if (root == null) {
            return 0;
        }

        path[i] = root.data;

        if (root.left == null && root.right == null) {
            for (j = 0; j <= i; j++) {
                sum1 = sum1 + path[j];
            }

            if (sum == sum1) {
                return 1;
            } else {
                return 0;
            }
        }

        x = checkThesum(root.left, path, i + 1, sum);

        if (x == 1) {
            return 1;
        } else {
            return checkThesum(root.right, path, i + 1, sum);
        }
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    public static void main(String args[]) {
        int path[] = new int[100], sum = 164;
        Node root = newNode(45);
        root.left = newNode(38);
        root.left.left = newNode(33);
        root.left.left.left = newNode(31);
        root.left.left.right = newNode(35);
        root.left.right = newNode(41);
        root.left.right.left = newNode(40);
        root.left.right.right = newNode(44);
        root.right = newNode(50);
        root.right.left = newNode(47);
        root.right.left.left = newNode(46);
        root.right.left.right = newNode(48);
        root.right.right = newNode(52);
        root.right.right.left = newNode(51);
        root.right.right.right = newNode(55);

        if (checkThesum(root, path, 0, sum) == 1)
            System.out.print("YES\n");
        else
            System.out.print("NO\n");
    }
}
