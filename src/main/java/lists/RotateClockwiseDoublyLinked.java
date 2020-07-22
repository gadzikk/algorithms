package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class RotateClockwiseDoublyLinked {
    // https://www.geeksforgeeks.org/clockwise-rotation-of-doubly-linked-list-by-n-places/
    static class Node {
        char data;
        Node prev;
        Node next;
    }

    static int size(Node head_ref) {
        Node curr = head_ref;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    static void printList(Node node) {
        while (node.next != null) {
            System.out.print(node.data + " " + "<=>" + " ");
            node = node.next;
        }
        System.out.print(node.data);
    }

    static Node push(Node head_ref,
                     char new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = head_ref;
        if (head_ref != null) {
            head_ref.prev = new_node;
        }
        head_ref = new_node;
        return head_ref;
    }

    static Node rotate(Node head_ref,
                       int N, int size) {

    /* If N is greater than the size of doubly Linked List, we have to deduce it in the range of Doubly linked list size
    by taking modulo with the length of the list.*/
        N = N % size;

    /* We will update N by subtracting it's value length of the list. After this the question will
    reduce to counter clockwise rotation of linked list to N places*/
        N = size - N;

        if (N == 0) {
            return null;
        }

        Node current = head_ref;

        // current will either point to Nth or null after this loop. Current
        // will point to node 'b' in the above example
        int count = 1;
        while (count < N && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return null;
        }

        // current points to Nth node. Store it in a variable. NthNode points to node 'b' in the above example
        Node NthNode = current;

        // current will point to last node after this loop current will point to node 'e' in the above example
        while (current.next != null)
            current = current.next;

        // Change next of last node to previous head. Next of 'e' is now changed to node 'a'
        current.next = head_ref;

        // Change prev of Head node to current Prev of 'a' is now changed to node 'e'
        head_ref.prev = current;

        // Change head to (N+1)th node head is now changed to node 'c'
        head_ref = NthNode.next;

        // Change prev of New Head node to null Because Prev of Head Node in Doubly linked list is null
        head_ref.prev = null;

        // Change next of Nth node to null next of 'b' is now null
        NthNode.next = null;
        return head_ref;
    }

    public static void main(String[] args) {
        Node head = null;

    /* Create the doubly linked list a<->b<->c<->d<->e */
        head = push(head, 'e');
        head = push(head, 'd');
        head = push(head, 'c');
        head = push(head, 'b');
        head = push(head, 'a');

        int N = 2;
        int size = size(head);

        System.out.println("Given Doubly linked list ");
        printList(head);
        head = rotate(head, N, size);

        System.out.println("\nRotated Linked list clockwise ");
        printList(head);
    }
}
