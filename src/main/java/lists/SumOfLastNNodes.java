package lists;

import java.util.Stack;

/**
 * Created by gadzik on 22.07.20.
 */
public class SumOfLastNNodes {

    static class Node {
        int data;
        Node next;
    }

    ;

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static int sumOfLastN_NodesUtil(Node head, int n) {
        if (n <= 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<Integer>();
        int sum = 0;

        while (head != null) {
            st.push(head.data);
            head = head.next;
        }

        while (n-- > 0) {
            sum += st.peek();
            st.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Node head = null;

        // create linked list 10.6.8.4.12
        head = push(head, 12);
        head = push(head, 4);
        head = push(head, 8);
        head = push(head, 6);
        head = push(head, 10);

        int n = 2;
        System.out.print("Sum of last " + n + " nodes = "
                + sumOfLastN_NodesUtil(head, n));
    }
}
