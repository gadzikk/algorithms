package lists;

/**
 * Created by gadzik on 24.07.20.
 */
public class AlternateSplitRec {
    // https://www.geeksforgeeks.org/recursive-approach-alternating-split-linked-list/
    static class Node {
        int data;
        Node next;
    }

    static Node push(Node head, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (head);
        (head) = new_node;
        return head;
    }

    static Node a = null, b = null;

    // We basically remove link between 'a' and its next. Similarly we remove link between 'b' and its next.
    // Then we recur for remaining lists.
    static void moveNode(Node a, Node b) {
        if (b == null || a == null) {
            return;
        }

        if (a.next != null) {
            a.next = a.next.next;
        }

        if (b.next != null) {
            b.next = b.next.next;
        }

        moveNode(a.next, b.next);
    }

    static void alternateSplitLinkedList(Node head) {
        Node curr = head;
        a = curr;
        b = curr.next;
        Node aRef = a, bRef = b;
        moveNode(aRef, bRef);
    }

    static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.printf("%d ", curr.data);
            curr = curr.next;
        }
    }

    public static void main(String args[]) {
        Node head = null;
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        alternateSplitLinkedList(head);

        System.out.printf("a : ");
        display(a);
        System.out.printf("\nb : ");
        display(b);
    }
}
