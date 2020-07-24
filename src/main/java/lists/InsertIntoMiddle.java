package lists;

/**
 * Created by gadzik on 23.07.20.
 */
public class InsertIntoMiddle {
    static Node head; // head of list

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void insertAtMid(int x) {

        if (head == null) {
            head = new Node(x);
        } else {
            Node newNode = new Node(x);
            Node ptr = head;
            int len = 0;

            // calculate length of the linked list i.e, the number of nodes
            while (ptr != null) {
                len++;
                ptr = ptr.next;
            }

            // 'count' the number of nodes after which the new node is to be inserted
            int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2;
            ptr = head;

            // 'ptr' points to the node after which the new node is to be inserted
            while (count-- > 1) {
                ptr = ptr.next;
            }

            // insert the 'newNode' and adjust the required links
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Creating the list 1.2.4.5
        head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        System.out.println("Linked list before " +
                "insertion: ");
        display();

        int x = 3;
        insertAtMid(x);

        System.out.println("\nLinked list after" +
                " insertion: ");
        display();
    }
}
