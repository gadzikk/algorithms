package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class ZigZag {
    // https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static int temp = 0;

    static void zigZagList(Node head) {
        // If flag is true, then next node should be greater
        boolean flag = true;

        Node current = head;
        while (current != null && current.next != null) {
            if (flag == true)  {
                /* "<" relation expected */
                /* If we have a situation like A > B > C
            where A, B and C are consecutive Nodes  in list we get A > B < C by swapping B  and C */
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else  {
                /* ">" relation expected */
                /* If we have a situation like A < B < C where
            A, B and C are consecutive Nodes in list we get A < C > B by swapping B and C */
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }

            current = current.next;

            flag = !(flag);
        }
    }

    static void push(int new_data) {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = (head);
        (head) = new_Node;
    }

    static void printList(Node Node) {
        while (Node != null) {
            System.out.print(Node.data + "->");
            Node = Node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
        // answer should be -> 3 7 4 8 2 6 1
        push(1);
        push(2);
        push(6);
        push(8);
        push(7);
        push(3);
        push(4);

        System.out.println("Given linked list ");
        printList(head);

        zigZagList(head);

        System.out.println("Zig Zag Linked list ");
        printList(head);
    }
}
