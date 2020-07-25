package lists;

/**
 * Created by gadzik on 25.07.20.
 */
public class DecimalEquivalent {
    // https://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/
    static class Node {
        boolean data;
        Node next;
    }

    static int decimalValue(Node head) {
        int res = 0;

        // Traverse linked list
        while (head != null) {
            // Multiply result by 2 and add head's data
            res = (res << 1) + (head.data ? 1 : 0);
            head = head.next;
        }
        return res;
    }

    // Utility function to create a new node.
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = (data == 1 ? true : false);
        temp.next = null;
        return temp;
    }

    // Driver code/
    public static void main(String args[]) {
        Node head = newNode(1);
        head.next = newNode(0);
        head.next.next = newNode(1);
        head.next.next.next = newNode(1);

        System.out.print("Decimal value is " + decimalValue(head));
    }
}
