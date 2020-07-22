package lists;

/**
 * Created by gadzik on 22.07.20.
 */
public class AddOne {
    // https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /* Adds one to a linked lists and return the head node of resultant list */
    static Node addOneUtil(Node head) {
        Node res = head;
        Node temp = null, prev = null;

        int carry = 1;
        int sum;

        while (head != null) {
            sum = carry + head.data;
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            head.data = sum;

            temp = head;
            head = head.next;
        }

        // if some carry is still there, add a new node to result list.
        if (carry > 0) {
            temp.next = newNode(carry);
        }

        // return head of the resultant list
        return res;
    }

    // This function mainly uses addOneUtil().
    static Node addOne(Node head) {
        head = reverse(head);
        // Add one from left to right of reversed list
        head = addOneUtil(head);
        // Reverse the modified list
        return reverse(head);
    }

    // A utility function to print a linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);

        System.out.print("List is ");
        printList(head);

        head = addOne(head);
        System.out.println();
        System.out.print("Resultant list is ");
        printList(head);
    }
}
