package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 24.07.20.
 */
public class SwapKthFromBeginningAndEnd {
    // https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
    NodeL head;

    // insert a node at the beginning
    void push(int new_data) {
        NodeL new_node = new NodeL(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        NodeL node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    int countNodes() {
        int count = 0;
        NodeL s = head;
        while (s != null) {
            count++;
            s = s.next;
        }
        return count;
    }

    void swapKth(int k) {
        int n = countNodes();
        if (n < k) {
            return;
        }
        if (2 * k - 1 == n) {
            return;
        }

        // Find the kth node from beginning of linked list. We also find previous of kth node because we need
        // to update next pointer of the previous.
        NodeL x = head;
        NodeL x_prev = null;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        // Similarly, find the kth node from end and its previous. kth node from end is (n-k+1)th node
        // from beginning
        NodeL y = head;
        NodeL y_prev = null;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if (x_prev != null) {
            x_prev.next = y;
        }

        // Same thing applies to y_prev
        if (y_prev != null) {
            y_prev.next = x;
        }

        // Swap next pointers of x and y. These statements also break self loop if x->next is y or y->next
        // is x
        NodeL temp = x.next;
        x.next = y.next;
        y.next = temp;

        // Change head pointers when k is 1 or n
        if (k == 1) {
            head = y;
        }

        if (k == n) {
            head = x;
        }
    }

    // Driver code to test above
    public static void main(String[] args) {
        SwapKthFromBeginningAndEnd llist = new SwapKthFromBeginningAndEnd();
        for (int i = 8; i >= 1; i--) {
            llist.push(i);
        }

        System.out.print("Original linked list: ");
        llist.printList();
        System.out.println("");

        for (int i = 1; i < 9; i++) {
            llist.swapKth(i);
            System.out.println("Modified List for k = " + i);
            llist.printList();
            System.out.println("");
        }
    }
}
