package lists;

import zobjects.NodeD;

/**
 * Created by gadzik on 22.07.20.
 */
public class DeleteNodeFromDoubly {
    // https://www.geeksforgeeks.org/delete-doubly-linked-list-node-given-position/
    static NodeD deleteNode(NodeD head, NodeD del) {
        // base case
        if (head == null || del == null) {
            return null;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        del = null;

        return head;
    }

    static void deleteNodeAtGivenPos(NodeD head, int n) {
        /* if list in NULL or invalid position is given */
        if (head == null || n <= 0) {
            return;
        }

        NodeD current = head;
        int i;

        //* traverse up to the node at position 'n' from the beginning
        for (i = 1; current != null && i < n; i++) {
            current = current.next;
        }
        // if 'n' is greater than the number of nodes in the doubly linked list
        if (current == null) {
            return;
        }
        // delete the node pointed to by 'current'
        deleteNode(head, current);
    }

    // Function to insert a node
    // at the beginning of the Doubly Linked List
    static NodeD push(NodeD head, int new_data) {
        NodeD new_node = new NodeD();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = head;
        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
        return head;
    }

    static void printList(NodeD temp) {
        if (temp == null) {
            System.out.print("Doubly Linked list empty");
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeD head = null;

        // Create the doubly linked list:
        // 2<->2<->10<->8<->4<->2<->5<->2

        head = push(head, 2);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 8);
        head = push(head, 10);

        System.out.println("Doubly linked list before deletion:");
        printList(head);

        int n = 2;

        deleteNodeAtGivenPos(head, n);
        System.out.println("Doubly linked list after deletion:");
        printList(head);
    }
}