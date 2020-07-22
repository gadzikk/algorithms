package lists;

/**
 * Created by gadzik on 16.07.20.
 */
public class QuickSortOnDoublyLinkedList {
    // https://www.geeksforgeeks.org/quicksort-for-linked-list/
    Node head;

    static class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    Node lastNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }


    /* Considers last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than
       pivot) to left of pivot and all greater elements to right of pivot */
    Node partition(Node low, Node high) {
        // set pivot as high element
        int x = high.data;
        // similar to i = low-1 for array implementation
        Node i = low.prev;
        // Similar to "for (int j = low; j <= high- 1; j++)"
        for (Node j = low; j != high; j = j.next) {
            if (j.data <= x) {
                // Similar to i++ for array
                i = (i == null) ? low : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? low : i.next;  // Similar to i++
        int temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }

    /* A recursive implementation of quicksort for linked list */
    void _quickSort(Node low, Node high) {
        if (high != null && low != high && low != high.next) {
            Node temp = partition(low, high);
            _quickSort(low, temp.prev);
            _quickSort(temp.next, high);
        }
    }

    // The main function to sort a linked list. It mainly calls _quickSort()
    public void quickSort(Node node) {
        Node head = lastNode(node);
        _quickSort(node, head);
    }

    // A utility function to print contents of arr
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(int new_Data) {
        Node new_Node = new Node(new_Data);
        // if head is null, head = new_Node
        if (head == null) {
            head = new_Node;
            return;
        }
        /* link the old list off the new node */
        new_Node.next = head;
        /* change prev of head node to new node */
        head.prev = new_Node;
        /* since we are adding at the beginning, prev is always NULL */
        new_Node.prev = null;
        /* move the head to point to the new node */
        head = new_Node;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        QuickSortOnDoublyLinkedList list = new QuickSortOnDoublyLinkedList();

        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);

        System.out.println("Linked List before sorting ");
        list.printList(list.head);
        System.out.println("\nLinked List after sorting");
        list.quickSort(list.head);
        list.printList(list.head);
    }
}
