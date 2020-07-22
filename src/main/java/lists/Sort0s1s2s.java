package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class Sort0s1s2s {
    // https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void sortList() {
        int count[] = {0, 0, 0};
        Node ptr = head;

       /* count total number of '0', '1' and '2'
        * count[0] will store total number of '0's
        * count[1] will store total number of '1's
        * count[2] will store total number of '2's  */

        while (ptr != null) {
            count[ptr.data]++;
            ptr = ptr.next;
        }

        int i = 0;
        ptr = head;

        while (ptr != null) {
            if (count[i] == 0) {
                i++;
            } else {
                ptr.data = i;
                --count[i];
                ptr = ptr.next;
            }
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Sort0s1s2s llist = new Sort0s1s2s();

        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        System.out.println("Linked List before sorting");
        llist.printList();

        llist.sortList();

        System.out.println("Linked List after sorting");
        llist.printList();
    }
}
