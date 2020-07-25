package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class RotateClockwise {
    // https://www.geeksforgeeks.org/clockwise-rotation-of-linked-list/
    static NodeL push(NodeL head_ref, int new_data) {
        NodeL new_node = new NodeL();
        new_node.data = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    static void printList(NodeL node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }

    // Function that rotates the given linked list
// clockwise by k and returns the updated
// head pointer
    static NodeL rightRotate(NodeL head, int k) {
        if (head == null) {
            return head;
        }

        // tmp will point to the last node after this loop
        NodeL tmp = head;
        int length = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }

        if (k > length) {
            k = k % length;
        }

        // Subtract from length to convert it into left rotation
        k = length - k;

        // If no rotation needed then return the head node
        if (k == 0 || k == length) {
            return head;
        }

        // current will either point to
        // kth or null after this loop
        NodeL current = head;
        int cnt = 1;
        while (cnt < k && current != null) {
            current = current.next;
            cnt++;
        }

        // If current is null then k is equal to the
        // count of nodes in the list
        // Don't change the list in this case
        if (current == null) {
            return head;
        }

        // current points to the kth node
        NodeL kthnode = current;
        // Change next of last node to previous head
        tmp.next = head;
        // Change head to (k+1)th node
        head = kthnode.next;
        // Change next of kth node to null
        kthnode.next = null;
        // Return the updated head pointer
        return head;
    }

    // Driver code
    public static void main(String args[]) {

    /* The constructed linked list is:
    1.2.3.4.5 */
        NodeL head = null;
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        int k = 2;

        NodeL updated_head = rightRotate(head, k);
        printList(updated_head);
    }
}
