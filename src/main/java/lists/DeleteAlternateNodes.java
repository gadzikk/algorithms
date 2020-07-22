package lists;

/**
 * Created by gadzik on 21.07.20.
 */
public class DeleteAlternateNodes {
    // https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
    public Node head;  // head of list

    public class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteAlt() {
        if (head == null) {
            return;
        }

        Node prev = head;
        Node now = head.next;

        while (prev != null && now != null) {
           /* Change next link of previus node */
            prev.next = now.next;
           /* Free node */
            now = null;
           /*Update prev and now */
            prev = prev.next;
            if (prev != null) {
                now = prev.next;
            }
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DeleteAlternateNodes llist = new DeleteAlternateNodes();

        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling deleteAlt() ");
        llist.printList();

        llist.deleteAlt();

        System.out.println("Linked List after calling deleteAlt() ");
        llist.printList();
    }
}
