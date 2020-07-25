package lists;

/**
 * Created by gadzik on 24.07.20.
 */
public class DeleteNodesGreaterOnRightRec {
    // https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side-using-recursion/
    static class Node {
        int data;
        Node next;
    }

    static Node head;
    static int max;

    static int maxVal(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static Node delNodes(Node head) {
        if (head == null) {
            return head;
        }

        head.next = delNodes(head.next);
        if (head.data < max) {
            return head.next;
        }
        max = maxVal(head.data, max);
        return head;
    }

    /* Utility function to insert a node at the beginning */
    static void push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        head = head_ref;
    }

    /* Utility function to print a linked list */
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        head = null;

    /* Create following linked list
    12.15.10.11.5.6.2.3 */
        push(head, 3);
        push(head, 2);
        push(head, 6);
        push(head, 5);
        push(head, 11);
        push(head, 10);
        push(head, 15);
        push(head, 12);

        System.out.println("Given Linked List");
        printList(head);
        max = Integer.MIN_VALUE;
        head = delNodes(head);

        System.out.println("Modified Linked List");
        printList(head);
    }
}
