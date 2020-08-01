package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenMultilevel {
    // https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/?ref=rp
    class Node {

        int data;
        Node next, child;

        Node(int d) {
            data = d;
            next = child = null;
        }
    }

    static Node head;

    Node createList(int arr[], int n) {
        Node node = null;
        Node p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.next = new Node(arr[i]);
                p = p.next;
            }
            p.next = p.child = null;
        }
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    Node createList() {
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = createList(arr1, arr1.length);
        Node head2 = createList(arr2, arr2.length);
        Node head3 = createList(arr3, arr3.length);
        Node head4 = createList(arr4, arr4.length);
        Node head5 = createList(arr5, arr5.length);
        Node head6 = createList(arr6, arr6.length);
        Node head7 = createList(arr7, arr7.length);
        Node head8 = createList(arr8, arr8.length);

        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;

        return head1;
    }

    /* The main function that flattens a multilevel linked list */
    void flattenList(Node node) {

        if (node == null) {
            return;
        }

        Node tmp = null;
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }

        // One by one traverse through all nodes of first level linked list till we reach the tail node
        Node cur = node;
        while (cur != tail) {
            if (cur.child != null) {
                // then append the child at the end of current list
                // and update the tail to new last node
                tail.next = cur.child;
                tmp = cur.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        FlattenMultilevel list = new FlattenMultilevel();
        head = list.createList();
        list.flattenList(head);
        list.printList(head);
    }

}
