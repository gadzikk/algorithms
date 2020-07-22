package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 16.07.20.
 */
public class CountNodesCircularLinkedList {
    // https://www.geeksforgeeks.org/count-nodes-circular-linked-list/
    static NodeL push(NodeL head_ref, int data) {
        NodeL ptr1 = new NodeL();
        NodeL temp = head_ref;
        ptr1.data = data;
        ptr1.next = head_ref;

        if (head_ref != null) {
            while (temp.next != head_ref) {
                temp = temp.next;
            }
            temp.next = ptr1;
        } else {
            ptr1.next = ptr1;
        }

        head_ref = ptr1;
        return head_ref;
    }

    /* Function to print nodes in a given Circular
    linked list */
    static int countNodes(NodeL head) {
        NodeL temp = head;
        int result = 0;
        if (head != null) {
            do {
                temp = temp.next;
                result++;
            } while (temp != head);
        }

        return result;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
    /* Initialize lists as empty */
        NodeL head = null;
        head = push(head, 12);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);

        System.out.printf("%d", countNodes(head));
    }
}
