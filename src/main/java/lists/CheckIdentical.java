package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class CheckIdentical {
    // https://www.geeksforgeeks.org/identical-linked-lists/
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean areIdentical(CheckIdentical listb) {
        Node a = this.head, b = listb.head;
        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }

            a = a.next;
            b = b.next;
        }

        // If linked lists are identical, then 'a' and 'b' must
        // be null at this point.
        return (a == null && b == null);
    }

    /* UTILITY FUNCTIONS TO TEST fun1() and fun2() */
    /*  Given a reference (pointer to pointer) to the head
        of a list and an int, push a new node on the front
        of the list. */

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }


    /* Driver program to test above functions */
    public static void main(String args[]) {
        CheckIdentical llist1 = new CheckIdentical();
        CheckIdentical llist2 = new CheckIdentical();

        /* The constructed linked lists are :
           llist1: 3->2->1
           llist2: 3->2->1 */

        llist1.push(1);
        llist1.push(2);
        llist1.push(3);

        llist2.push(1);
        llist2.push(2);
        llist2.push(3);

        if (llist1.areIdentical(llist2) == true)
            System.out.println("Identical ");
        else
            System.out.println("Not identical ");

    }
}
