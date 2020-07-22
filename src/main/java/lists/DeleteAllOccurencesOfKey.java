package lists;

/**
 * Created by gadzik on 23.07.20.
 */
public class DeleteAllOccurencesOfKey {

    static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    void deleteKey(int key) {
        Node temp = head, prev = null;


        while (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            temp = head;         // Change Temp
        }

        // Delete occurrences other than head
        while (temp != null) {
            // Search for the key to be deleted,
            // keep track of the previous node
            // as we need to change 'prev->next'
            while (temp != null && temp.data != key) {
                prev = temp;
                temp = temp.next;
            }

            // If key was not present in linked list
            if (temp == null) return;

            // Unlink the node from linked list
            prev.next = temp.next;

            //Update Temp for next iteration of outer loop
            temp = prev.next;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        DeleteAllOccurencesOfKey llist = new DeleteAllOccurencesOfKey();

        llist.push(7);
        llist.push(2);
        llist.push(3);
        llist.push(2);
        llist.push(8);
        llist.push(1);
        llist.push(2);
        llist.push(2);

        int key = 2; // key to delete

        System.out.println("Created Linked list is:");
        llist.printList();

        llist.deleteKey(key);

        System.out.println("\nLinked List after Deletion is:");
        llist.printList();
    }
}
