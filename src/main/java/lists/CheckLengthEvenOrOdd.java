package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 21.07.20.
 */
public class CheckLengthEvenOrOdd {
    // https://www.geeksforgeeks.org/check-whether-the-length-of-given-linked-list-is-even-or-odd/
    static int LinkedListLength(NodeL head) {
        while (head != null && head.next != null) {
            head = head.next.next;
        }
        if (head == null) {
            return 0;
        }
        return 1;
    }

    // Push function
    static void push(NodeL head, int info) {
        // Allocating node
        NodeL node = new NodeL();
        // Info into node
        node.data = info;
        // Next of new node to head
        node.next = (head);
        // head points to new node
        (head) = node;
    }

    // Driver code
    public static void main(String[] args) {
        NodeL head = null;

        // Adding elements to Linked List
        push(head, 4);
        push(head, 5);
        push(head, 7);
        push(head, 2);
        push(head, 9);
        push(head, 6);
        push(head, 1);
        push(head, 2);
        push(head, 0);
        push(head, 5);
        push(head, 5);
        int check = LinkedListLength(head);

        // Checking for length of
        // linklist
        if (check == 0) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
