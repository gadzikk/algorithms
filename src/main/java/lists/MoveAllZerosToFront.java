package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 24.07.20.
 */
public class MoveAllZerosToFront {
    static NodeL push(NodeL head_ref, int new_data) {
        NodeL new_node = new NodeL();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return new_node;
    }

    /* moving zeroes to the beginning in linked list */
    static NodeL moveZeroes(NodeL head) {
        if (head == null) {
            return null;
        }

        NodeL temp = (head).next;
        NodeL prev = head;
        while (temp != null) {
            // If current node is 0, move to beginning of linked list
            if (temp.data == 0) {
                // Disconnect node from its  current position
                NodeL curr = temp;
                temp = temp.next;
                prev.next = temp;

                // Move to beginning
                curr.next = (head);
                head = curr;
            } else {
                prev = temp;
                temp = temp.next;
            }

        }
        return head;
    }

    // function to displaying nodes
    static void display(NodeL head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        NodeL head = null;

        /* Use push() to conbelow list
        0.0.1.0.1.0.2.0.3.0 */
        head = push(head, 0);
        head = push(head, 3);
        head = push(head, 0);
        head = push(head, 2);
        head = push(head, 0);
        head = push(head, 1);
        head = push(head, 0);
        head = push(head, 1);
        head = push(head, 0);
        head = push(head, 0);

        System.out.print("Linked list before rearrangement\n");
        display(head);

        head = moveZeroes(head);

        System.out.print("\n Linked list after rearrangement \n");
        display(head);

    }
}
