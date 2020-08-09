package lists;

/**
 * Created by gadzik on 21.07.20.
 */
public class DeleteNodesSmallerThanK {
    // https://www.geeksforgeeks.org/delete-all-the-nodes-from-a-doubly-linked-list-that-are-smaller-than-a-given-value
    static class Node {
        int data;
        Node prev, next;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;

        // since we are adding at the beginning, prev is always null
        new_node.prev = null;
        // link the old list off the new node
        new_node.next = (head_ref);
        // change prev of head node to new node
        if ((head_ref) != null) {
            (head_ref).prev = new_node;
        }

        // move the head to point to the new node
        (head_ref) = new_node;

        return head_ref;
    }

    static Node deleteNode(Node head_ref, Node del) {
        // base case
        if (head_ref == null || del == null)
            return null;

        // If node to be deleted is head node
        if (head_ref == del) {
            head_ref = del.next;
        }

        // Change next only if node to be deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        return head_ref;
    }

    static Node deletesmallerNodes(Node head_ref, int K) {
        Node ptr = head_ref;
        Node next;

        while (ptr != null) {
            next = ptr.next;

            if (ptr.data < K) {
                deleteNode(head_ref, ptr);
            }
            ptr = next;
        }
        return head_ref;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        Node head = null;

        // 15 <. 16 <. 10 <. 9 <. 6 <. 7 <. 17
        head = push(head, 17);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 9);
        head = push(head, 10);
        head = push(head, 16);
        head = push(head, 15);

        int K = 10;

        System.out.print("Original List: ");
        printList(head);

        head = deletesmallerNodes(head, K);

        System.out.print("\nModified List: ");
        printList(head);
    }
}
