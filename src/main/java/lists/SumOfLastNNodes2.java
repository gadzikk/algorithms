package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class SumOfLastNNodes2 {
    // https://www.geeksforgeeks.org/find-sum-last-n-nodes-given-linked-list/
    static class Node {
        int data;
        Node next;
    }

    ;
    static Node head;

    static void push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        head = head_ref;
    }

    static void reverseList(Node head_ref) {
        Node current, prev, next;
        current = head_ref;
        prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head_ref = prev;
        head = head_ref;
    }

    // utility function to find the sum of last 'n' nodes
    static int sumOfLastN_NodesUtil(int n) {
        if (n <= 0) {
            return 0;
        }

        // reverse the linked list
        reverseList(head);

        int sum = 0;
        Node current = head;

        while (current != null && n-- > 0) {
            sum += current.data;
            current = current.next;
        }

        // reverse back the linked list
        reverseList(head);
        return sum;
    }

    // Driver code
    public static void main(String[] args) {

        // create linked list 10.6.8.4.12
        push(head, 12);
        push(head, 4);
        push(head, 8);
        push(head, 6);
        push(head, 10);

        int n = 2;
        System.out.println("Sum of last " + n + " nodes = "
                + sumOfLastN_NodesUtil(n));
    }
}
