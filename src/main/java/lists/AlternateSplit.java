package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 24.07.20.
 */
public class AlternateSplit {
    public static NodeL head = null;
    public static NodeL headA = null; //linked List 1
    public static NodeL headB = null; // Linked List 2

    public void Altersplit() {
        NodeL currNode = head;
        if (currNode == null || currNode.next == null) {
            return;
        }
        headA = currNode;
        headB = currNode.next;
        while (currNode != null && currNode.next != null) {

            NodeL t = currNode.next;
            currNode.next = t.next; // set the next node for first linked list
            if (currNode.next != null && currNode.next.next != null) {
                t.next = currNode.next.next; // set the next node for second linked list
            } else {
                // we have reached to the end
                t.next = null;
                return;
            }
            currNode = currNode.next;
        }

    }

    public void print(NodeL x) {
        System.out.println("");
        NodeL curr = x;
        while (curr != null) {
            System.out.print("->" + curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        head = new NodeL(1);
        head.next = new NodeL(2);
        head.next.next = new NodeL(1);
        head.next.next.next = new NodeL(2);
        head.next.next.next.next = new NodeL(1);
        head.next.next.next.next.next = new NodeL(2);

        AlternateSplit i = new AlternateSplit();
        i.print(head);
        i.Altersplit();
        i.print(headA);
        i.print(headB);

    }
}

