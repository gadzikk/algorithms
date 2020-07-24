package lists;

import zobjects.NodeL;

import java.util.Stack;

/**
 * Created by gadzik on 23.07.20.
 */
public class ReverseInGroups {
    // https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/

    static NodeL head = null;

    /* Reverses the linked list in groups of size k
    and returns the pointer to the new head node. */
    static NodeL Reverse(NodeL head, int k) {
        // Create a stack of Node*
        Stack<NodeL> mystack = new Stack<>();
        NodeL current = head;
        NodeL prev = null;

        while (current != null) {

            // Terminate the loop whichever comes first
            // either current == NULL or count >= k
            int count = 0;
            while (current != null && count < k) {
                mystack.push(current);
                current = current.next;
                count++;
            }

            // Now pop the elements of stack one by one
            while (mystack.size() > 0) {
                // If final list has not been started yet.
                if (prev == null) {
                    prev = mystack.peek();
                    head = prev;
                    mystack.pop();
                } else {
                    prev.next = mystack.peek();
                    prev = prev.next;
                    mystack.pop();
                }
            }
        }

        prev.next = null;

        return head;
    }

    static void push(int new_data) {
        NodeL new_node = new NodeL();
        new_node.data = new_data;
        new_node.next = head;
        head = new_node;
    }

    static void printList(NodeL node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
    /* Created Linked list is 1->2->3->
    4->5->6->7->8->9 */
        push(9);
        push(8);
        push(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);

        System.out.println("Given linked list ");
        printList(head);
        head = Reverse(head, 3);
        System.out.println();

        System.out.println("Reversed Linked list ");
        printList(head);
    }
}
