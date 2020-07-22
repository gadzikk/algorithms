package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 22.07.20.
 */
public class Sort0s1s2sByChangingLinks {
    // https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
    public static NodeL sortList(NodeL head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Create three dummy nodes to point to
        // beginning of three linked lists. These
        // dummy nodes are created to avoid many
        // null checks.
        NodeL zeroD = new NodeL(0);
        NodeL oneD = new NodeL(0);
        NodeL twoD = new NodeL(0);

        // Initialize current pointers for three
        // lists and whole list.
        NodeL zero = zeroD, one = oneD, two = twoD;
        // Traverse list
        NodeL curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
                curr = curr.next;
            } else {
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }
        // Attach three lists
        zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next);
        one.next = twoD.next;
        two.next = null;
        // Updated head
        head = zeroD.next;
        return head;
    }

    public static NodeL newNode(int data) {
        NodeL newNode = new NodeL(data);
        newNode.next = null;
        return newNode;
    }

    public static void printList(NodeL node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        NodeL head = new NodeL(1);
        head.next = new NodeL(2);
        head.next.next = new NodeL(0);
        head.next.next.next = new NodeL(1);
        printList(head);
        System.out.println(" ");
        head = sortList(head);
        printList(head);
    }
}


