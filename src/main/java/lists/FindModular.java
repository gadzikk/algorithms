package lists;

/**
 * Created by gadzik on 23.07.20.
 */
public class FindModular {
    // https://www.geeksforgeeks.org/find-modular-node-linked-list/
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to find modular node in the linked list
    static Node modularNode(Node head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }

        int i = 1;
        Node modularNode = null;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (i % k == 0) {
                modularNode = temp;
            }

            i++;
        }
        return modularNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int k = 2;
        Node answer = modularNode(head, k);
        System.out.print("Modular node is ");
        if (answer != null)
            System.out.println(answer.data);
        else
            System.out.println("null");
    }
}
