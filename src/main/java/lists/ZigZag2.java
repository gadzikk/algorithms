package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class ZigZag2 {
    static class Node {
        int data;
        Node next;
    }

    static Node head;

    static Node zigZagList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node res = null;
        Node curr = head;
        Node prev = null;
        Node next;

        // to check if current element should
        // be less than or greater than.
        // ind = 0 -. less than
        // ind = 1 -. greater than
        int ind = 0;

        while (curr.next != null) {
            // If elements are not in zigzag fashion swap them.
            if ((ind == 0 && curr.data > curr.next.data) ||  (ind == 1 && curr.data < curr.next.data)) {
                if (res == null) {
                    res = curr.next;
                }
                // Store new next element of current node
                next = curr.next.next;

                // Previous node of current node will now point to next node of current node
                if (prev != null) {
                    prev.next = curr.next;
                }
                // Change next pointers of both adjacent nodes
                curr.next.next = curr;
                curr.next = next;

                if (prev != null) {
                    prev = prev.next;
                }
                else {
                    prev = res;
                }
            }

            // If already in zig zag form, then move to next element.
            else {
                if (res == null) {
                    res = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            // Update info whether next element should be less than or greater than.
            ind = 1 - ind;
        }
        return res;
    }

    static void push(Node head_ref, int new_data) {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = head_ref;
        head_ref = new_Node;
        head = head_ref;
    }

    static void printList(Node Node) {
        while (Node != null) {
            System.out.printf("%d->", Node.data);
            Node = Node.next;
        }
    }

    public static void main(String[] args) {
        head = null;

        // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
        // answer should be -> 3 7 4 8 2 6 1
        push(head, 1);
        push(head, 2);
        push(head, 6);
        push(head, 8);
        push(head, 7);
        push(head, 3);
        push(head, 4);

        System.out.printf("Given linked list \n");
        printList(head);

        head = zigZagList(head);

        System.out.printf("\nZig Zag Linked list \n");
        printList(head);
    }
}
