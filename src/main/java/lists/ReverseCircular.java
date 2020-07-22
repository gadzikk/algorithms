package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class ReverseCircular {
    // https://www.geeksforgeeks.org/reverse-circular-linked-list/
    static class Node {
        int data;
        Node next;
    }

    // function to get a new node
    static Node getNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }

    static Node reverse(Node head_ref) {
        if (head_ref == null) {
            return null;
        }

        // reverse procedure same as reversing a singly linked list
        Node prev = null;
        Node current = head_ref;
        Node next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != (head_ref));

        // adjutsing the links so as to make the last node point to the first node
        (head_ref).next = prev;
        head_ref = prev;
        return head_ref;
    }

    // Function to print circular linked list
    static void printList(Node head) {
        if (head == null)
            return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    // Driver code
    public static void main(String args[]) {
        // Create a circular linked list
        // 1.2.3.4.1
        Node head = getNode(1);
        head.next = getNode(2);
        head.next.next = getNode(3);
        head.next.next.next = getNode(4);
        head.next.next.next.next = head;

        System.out.print("Given circular linked list: ");
        printList(head);

        head = reverse(head);

        System.out.print("\nReversed circular linked list: ");
        printList(head);

    }
}
