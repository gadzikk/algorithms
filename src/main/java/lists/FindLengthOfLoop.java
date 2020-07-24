package lists;

/**
 * Created by gadzik on 24.07.20.
 */
public class FindLengthOfLoop {
    // https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Returns count of nodes present in loop.
    static int countNodes(Node n) {
        int res = 1;
        Node temp = n;
        while (temp.next != n) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    /* This function detects and counts loop
    nodes in the list. If loop is not there
    in then returns 0 */
    static int countNodesinLoop(Node list) {
        Node slow_p = list, fast_p = list;

        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if (slow_p == fast_p) {
                return countNodes(slow_p);
            }
        }

        return 0;
    }

    static Node newNode(int key) {
        Node temp = new Node(key);

        return temp;
    }

    /* Driver program to test above function*/
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);

        head.next.next.next.next.next = head.next;

        System.out.println(countNodesinLoop(head));
    }

}
