package lists;

import java.util.HashSet;

/**
 * Created by gadzik on 23.07.20.
 */
public class DetectAndRemoveLoop3 {
    // https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static boolean removeLoop(Node h) {
        HashSet<Node> s = new HashSet<Node>();
        Node prev = null;
        while (h != null) {
            if (s.contains(h)) {
                prev.next = null;
                return true;
            } else {
                s.add(h);
                prev = h;
                h = h.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectAndRemoveLoop3 llist = new DetectAndRemoveLoop3();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (removeLoop(head)) {
            System.out.println("Linked List after removing loop");
            llist.printList(head);
        } else
            System.out.println("No Loop found");
    }
}
