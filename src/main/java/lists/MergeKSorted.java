package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 24.07.20.
 */
public class MergeKSorted {
    // https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

    public static NodeL SortedMerge(NodeL a, NodeL b) {
        NodeL result = null;
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        } else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;
    }

    public static NodeL mergeKLists(NodeL arr[], int last) {
        // repeat until only one list is left
        while (last != 0) {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);
                // consider next pair
                i++;
                j--;
                // If all pairs are merged, update last
                if (i >= j) {
                    last = j;
                }
            }
        }

        return arr[0];
    }

    /* Function to print nodes in a given linked list */
    public static void printList(NodeL node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        NodeL arr[] = new NodeL[k];

        arr[0] = new NodeL(1);
        arr[0].next = new NodeL(3);
        arr[0].next.next = new NodeL(5);
        arr[0].next.next.next = new NodeL(7);

        arr[1] = new NodeL(2);
        arr[1].next = new NodeL(4);
        arr[1].next.next = new NodeL(6);
        arr[1].next.next.next = new NodeL(8);

        arr[2] = new NodeL(0);
        arr[2].next = new NodeL(9);
        arr[2].next.next = new NodeL(10);
        arr[2].next.next.next = new NodeL(11);

        // Merge all lists
        NodeL head = mergeKLists(arr, k - 1);
        printList(head);
    }
}
