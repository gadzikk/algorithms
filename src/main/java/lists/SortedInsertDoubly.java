package lists;

import zobjects.NodeD;

/**
 * Created by gadzik on 25.07.20.
 */
public class SortedInsertDoubly {
    // https://www.geeksforgeeks.org/insert-value-sorted-way-sorted-doubly-linked-list/
    static NodeD createNode(int data) {
        NodeD newNode = new NodeD();
        newNode.data = data;
        newNode.prev = newNode.next = null;
        return newNode;

    }

    // function to insert a new node in sorted way in
    // a sorted doubly linked list
    static NodeD sortedInsert(NodeD head, NodeD newNode) {
        NodeD current;

        // if list is empty
        if (head == null) {
            head = newNode;
        }

        // if the node is to be inserted at the beginning
        // of the doubly linked list
        else if (newNode.data <= head.data) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else {
            current = head;
            // locate the node after which the new node is to be inserted
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }

            newNode.next = current.next;

            // if the new node is not inserted at the end of the list
            if (current.next != null) {
                newNode.next.prev = newNode;
            }

            current.next = newNode;
            newNode.prev = current;

        }
        return head;
    }

    // function to print the doubly linked list
    static void printList(NodeD head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

    public static void main(String args[]) {
        NodeD head = null;
        NodeD new_node = createNode(8);
        head = sortedInsert(head, new_node);
        new_node = createNode(5);
        head = sortedInsert(head, new_node);
        new_node = createNode(3);
        head = sortedInsert(head, new_node);
        new_node = createNode(10);
        head = sortedInsert(head, new_node);
        new_node = createNode(12);
        head = sortedInsert(head, new_node);
        new_node = createNode(9);
        head = sortedInsert(head, new_node);

        System.out.println("Created Doubly Linked List");
        printList(head);
    }
}
