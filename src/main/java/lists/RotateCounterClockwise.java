package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class RotateCounterClockwise {
    // https://www.geeksforgeeks.org/rotate-a-linked-list/
    NodeL head;

    void rotate(int k) {
        if (k == 0) return;

        // Let us understand the below code for example k = 4
        // and list = 10->20->30->40->50->60.
        NodeL current = head;

        // current will either point to kth or NULL after this
        // loop. current will point to node 40 in the above example
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if (current == null) {
            return;
        }

        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        NodeL kthNode = current;

        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while (current.next != null) {
            current = current.next;
        }

        // Change next of last node to previous head
        // Next of 60 is now changed to node 10

        current.next = head;

        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;

        // change next of kth node to null
        kthNode.next = null;

    }

    void push(int new_data) {
        NodeL new_node = new NodeL(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        NodeL temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        RotateCounterClockwise llist = new RotateCounterClockwise();

        // create a list 10->20->30->40->50->60
        for (int i = 60; i >= 10; i -= 10) {
            llist.push(i);
        }

        System.out.println("Given list");
        llist.printList();

        llist.rotate(4);

        System.out.println("Rotated Linked List");
        llist.printList();
    }
}
