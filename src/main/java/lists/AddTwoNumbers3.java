package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 21.07.20.
 */
public class AddTwoNumbers3 {
    // https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists-set-3
    NodeL head;

    void traverse(NodeL head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    void insert(int x) {
        NodeL temp = new NodeL(x);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public static NodeL reverse(NodeL head) {
        if (head == null || head.next == null) return head;

        NodeL prev = null;
        NodeL curr = head;
        while (curr != null) {
            NodeL temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

    public static NodeL sum(NodeL l1, NodeL l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        // storing head whose reverse is to be returned This is where which will be final node
        NodeL head = l1;
        NodeL prev = null;
        int c = 0, sum;
        while (l1 != null && l2 != null) {
            sum = c + l1.data + l2.data;
            l1.data = sum % 10;
            c = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            if (l2 != null) {
                prev.next = l2;
            }
            l1 = prev.next;
            while (l1 != null) {
                sum = c + l1.data;
                l1.data = sum % 10;
                c = sum / 10;
                prev = l1;
                l1 = l1.next;
            }
        }
        if (c > 0) {
            prev.next = new NodeL(c);
        }
        return reverse(head);
    }

    // Driver Code
    public static void main(String[] args) {
        AddTwoNumbers3 l1 = new AddTwoNumbers3();
        l1.insert(3);
        l1.insert(6);
        l1.insert(5);
        AddTwoNumbers3 l2 = new AddTwoNumbers3();
        l2.insert(2);
        l2.insert(4);
        l2.insert(8);
        AddTwoNumbers3 l3 = new AddTwoNumbers3();
        NodeL head = sum(l1.head, l2.head);
        l3.traverse(head);
        System.out.print("Null");
    }
}
