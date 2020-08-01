package lists;

/**
 * Created by gadzik on 01.08.20.
 */
public class FlattenMultilevel2 {
    // https://www.geeksforgeeks.org/flatten-a-multi-level-linked-list-set-2-depth-wise/?ref=rp
    static Node last;

    static class Node {
        public int data;
        public Node next, down;

        public Node(int data) {
            this.data = data;
            next = null;
            down = null;
        }
    }

    // Flattens a multi-level linked list depth wise
    public static Node flattenList(Node node) {
        if (node == null) {
            return null;
        }

        // To keep track of last visited node (NOTE: This is static)
        last = node;

        // Store next pointer
        Node next = node.next;

        // If down list exists, process it first Add down list as next of current node
        if (node.down != null) {
            node.next = flattenList(node.down);
        }

        // If next exists, add it after the next of last added node
        if (next != null) {
            last.next = flattenList(next);
        }

        return node;
    }

    // Utility method to print a linked list
    public static void printFlattenNodes(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }

    // Utility function to create a new node
    public static Node push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = null;
        newNode.down = null;
        return newNode;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.down = new Node(7);
        head.next.down.down = new Node(9);
        head.next.down.down.down = new Node(14);
        head.next.down.down.down.down = new Node(15);
        head.next.down.down.down.down.next = new Node(23);
        head.next.down.down.down.down.next.down = new Node(24);
        head.next.down.next = new Node(8);
        head.next.down.next.down = new Node(16);
        head.next.down.next.down.down = new Node(17);
        head.next.down.next.down.down.next = new Node(18);
        head.next.down.next.down.down.next.next = new Node(19);
        head.next.down.next.down.down.next.next.next
                = new Node(20);
        head.next.down.next.down.down.next.next.next.down
                = new Node(21);
        head.next.down.next.next = new Node(10);
        head.next.down.next.next.down = new Node(11);
        head.next.down.next.next.next = new Node(12);

        head = flattenList(head);
        printFlattenNodes(head);
    }
}


