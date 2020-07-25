package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class CompareNumbers {
    // https://www.geeksforgeeks.org/compare-numbers-represented-by-linked-lists/?ref=rp

    static NodeL removeLeadingZeros(NodeL a) {
        if (a != null && a.data == 0)
            return removeLeadingZeros(a.next);
        else
            return a;
    }

    static int getSize(NodeL a) {
        int size = 0;
        while (a != null) {
            a = a.next;
            size++;
        }
        return size;
    }

    static NodeL push(NodeL head_ref, int new_data) {
        NodeL new_node = new NodeL();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static int compare(NodeL a, NodeL b) {

        a = removeLeadingZeros(a);
        b = removeLeadingZeros(b);

        int lenA = getSize(a);
        int lenB = getSize(b);

        if (lenA > lenB) {
            return 1;
        } else if (lenB > lenA) {
            return -1;
        }

        while (a != null && b != null) {
            if (a.data > b.data) {
                return 1;
            } else if (a.data < b.data) {
                return -1;
            }

        /* If we reach here, then a and b are  not null and their data is same, so move to next nodes in both lists */
            a = a.next;
            b = b.next;
        }

        return 0;
    }

    public static void main(String[] args) {

    /* The constructed linked lists are :
    a: 5->6->7
    b: 2->3->3 */
        NodeL a = null;
        a = push(a, 7);
        a = push(a, 6);
        a = push(a, 5);

        NodeL b = null;
        b = push(b, 3);
        b = push(b, 3);
        b = push(b, 2);

        System.out.println(compare(a, b));
    }
}
