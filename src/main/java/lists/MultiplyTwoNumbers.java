package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class MultiplyTwoNumbers {
    // https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists/
    static NodeL newNode(int data) {
        NodeL new_node = new NodeL();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    static NodeL push(NodeL head_ref, int new_data) {
        NodeL new_node = newNode(new_data);
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    // Multiply contents of two linked lists
    static long multiplyTwoLists(NodeL first, NodeL second) {
        int num1 = 0, num2 = 0;

        while (first != null || second != null) {
            if (first != null) {
                num1 = num1 * 10 + first.data;
                first = first.next;
            }
            if (second != null) {
                num2 = num2 * 10 + second.data;
                second = second.next;
            }
        }
        return num1 * num2;
    }

    static void printList(NodeL node) {
        while (node != null) {
            System.out.printf("%d", node.data);
            if (node.next != null) {
                System.out.printf("->");
            }
            node = node.next;
        }
        System.out.printf("\n");
    }

    public static void main(String args[]) {
        NodeL first = null;
        NodeL second = null;

        // create first list 9.4.6
        first = push(first, 6);
        first = push(first, 4);
        first = push(first, 9);
        System.out.printf("First List is: ");
        printList(first);

        // create second list 8.4
        second = push(second, 4);
        second = push(second, 8);
        System.out.printf("Second List is: ");
        printList(second);

        // Multiply the two lists and see result
        System.out.printf("Result is: ");
        System.out.println(multiplyTwoLists(first, second));
    }
}
