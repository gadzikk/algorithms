package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class MergeTwoSorted2 {
    // https://www.geeksforgeeks.org/merge-two-sorted-lists-place/
    static class Node {
        int data;
        Node next;
    }

    // Function to create newNode in a linkedlist
    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    // A utility function to print linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Merges two lists with headers as h1 and h2.
    // It assumes that h1's data is smaller than
    // or equal to h2's data.
    static Node mergeUtil(Node h1, Node h2) {
        // if only one node in first list simply point its head to second list
        if (h1.next == null) {
            h1.next = h2;
            return h1;
        }

        Node curr1 = h1, next1 = h1.next;
        Node curr2 = h2, next2 = h2.next;

        while (next1 != null && curr2 != null) {
            // if curr2 lies in between curr1 and next1  then do curr1->curr2->next1
            if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
                // now let curr1 and curr2 to point  to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            } else {
                // if more nodes in first list
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                } else {
                    // else point the last node of first list to the remaining nodes of second list
                    next1.next = curr2;
                    return h1;
                }
            }
        }
        return h1;
    }

    static Node merge(Node h1, Node h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        if (h1.data < h2.data) {
            return mergeUtil(h1, h2);
        } else {
            return mergeUtil(h2, h1);
        }
    }

    public static void main(String[] args) {
        Node head1 = newNode(1);
        head1.next = newNode(3);
        head1.next.next = newNode(5);

        // 1->3->5 LinkedList created

        Node head2 = newNode(0);
        head2.next = newNode(2);
        head2.next.next = newNode(4);

        // 0->2->4 LinkedList created

        Node mergedhead = merge(head1, head2);

        printList(mergedhead);
    }
}
