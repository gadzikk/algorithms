package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class SortedIntersect {
    // https://www.techiedelight.com/intersection-two-given-sorted-linked-lists/
    public static void printList(String msg, NodeL head) {
        System.out.print(msg);

        NodeL ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    public static NodeL SortedIntersect(NodeL a, NodeL b) {
        NodeL head = null, tail = null;

        while (a != null && b != null) {
            if (a.data == b.data) {
                if (head == null) {
                    tail = head = new NodeL(a.data, head);
                } else {
                    tail = tail.next = new NodeL(a.data, tail.next);
                }

                a = a.next;
                b = b.next;
            } else if (a.data < b.data) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        NodeL a = null;
        for (int i = keys.length - 1; i >= 0; i = i - 3) {
            a = new NodeL(keys[i], a);
        }

        NodeL b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            b = new NodeL(keys[i], b);
        }

        printList("First List  : ", a);
        printList("Second List : ", b);

        NodeL head = SortedIntersect(a, b);
        printList("After Intersection : ", head);
    }
}
