package lists;

/**
 * Created by gadzik on 23.07.20.
 */
public class PrintNodesFromSortedIndexed {
    // https://www.geeksforgeeks.org/print-nodes-of-linked-list-at-given-indexes/
    static class Node {
        int data;
        Node next;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();

        new_node.data = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    static void printSecondList(Node l1, Node l2) {
        Node sortedIndexes = l1;
        Node unsortedData = l2;

        while (sortedIndexes != null) {
            int i = 1;

            while (i < sortedIndexes.data) {
                unsortedData = unsortedData.next;
                i++;
            }

            System.out.print(unsortedData.data + " ");
            sortedIndexes = sortedIndexes.next;
            unsortedData = l2;
        }
    }

    public static void main(String args[]) {
        Node l1 = null, l2 = null;

        // Creating 1st list
        // 2 . 5
        l1 = push(l1, 5);
        l1 = push(l1, 2);

        // Creating 2nd list
        // 4 . 5 . 6 . 7 . 8
        l2 = push(l2, 8);
        l2 = push(l2, 7);
        l2 = push(l2, 6);
        l2 = push(l2, 5);
        l2 = push(l2, 4);

        printSecondList(l1, l2);
    }
}
