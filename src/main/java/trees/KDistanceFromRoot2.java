package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromRoot2 {
    // https://www.geeksforgeeks.org/print-nodes-k-distance-root-iterative/
    static Node newNode(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.left = newnode.right = null;
        return newnode;
    }

    static boolean printKDistant(Node root, int klevel) {
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        boolean flag = false;
        q.add(root);

        q.add(null);
        while (q.size() > 0) {
            Node temp = q.peek();

            if (level == klevel && temp != null) {
                flag = true;
                System.out.print(temp.data + " ");
            }
            q.remove();
            if (temp == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                level += 1;

                if (level > klevel) {
                    break;
                }
            } else {
                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        System.out.println();
        return flag;
    }

    // Driver code
    public static void main(String srga[]) {
        // create a binary tree
        Node root = newNode(20);
        root.left = newNode(10);
        root.right = newNode(30);
        root.left.left = newNode(5);
        root.left.right = newNode(15);
        root.left.right.left = newNode(12);
        root.right.left = newNode(25);
        root.right.right = newNode(40);

        System.out.print("data at level 1 : ");
        boolean ret = printKDistant(root, 1);
        if (ret == false)
            System.out.print("Number exceeds total " +
                    "number of levels\n");

        System.out.print("data at level 2 : ");
        ret = printKDistant(root, 2);
        if (ret == false)
            System.out.print("Number exceeds total " +
                    "number of levels\n");

        System.out.print("data at level 3 : ");
        ret = printKDistant(root, 3);
        if (ret == false)
            System.out.print("Number exceeds total " +
                    "number of levels\n");

        System.out.print("data at level 6 : ");
        ret = printKDistant(root, 6);
        if (ret == false)
            System.out.print("Number exceeds total" +
                    "number of levels\n");

    }
}
