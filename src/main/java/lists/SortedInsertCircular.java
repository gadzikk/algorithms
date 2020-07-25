package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class SortedInsertCircular {
    // https://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
    NodeL head;

    SortedInsertCircular() {
        head = null;
    }

    void sortedInsert(NodeL new_node) {
        NodeL current = head;

        // Case 1 of the above algo
        if (current == null) {
            new_node.next = new_node;
            head = new_node;

        }

        // Case 2 of the above algo
        else if (current.data >= new_node.data) {
            /* If value is smaller than head's value then  we need to change next of last node */
            while (current.next != head) {
                current = current.next;
            }

            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }

        // Case 3 of the above algo
        else {
            /* Locate the node before the point of insertion */
            while (current.next != head && current.next.data < new_node.data) {
                current = current.next;
            }

            new_node.next = current.next;
            current.next = new_node;
        }
    }

    void printList() {
        if (head != null) {
            NodeL temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }

    public static void main(String[] args) {
        SortedInsertCircular list = new SortedInsertCircular();

        // Creating the linkedlist
        int arr[] = new int[]{12, 56, 2, 11, 1, 90};

        NodeL temp = null;

        /* Create linked list from the array arr[]. Created linked list will be 1->2->11->12->56->90*/
        for (int i = 0; i < 6; i++) {
            temp = new NodeL(arr[i]);
            list.sortedInsert(temp);
        }

        list.printList();
    }
}
