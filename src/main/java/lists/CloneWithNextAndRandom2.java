package lists;

import zobjects.NodeRn;

/**
 * Created by gadzik on 23.07.20.
 */
public class CloneWithNextAndRandom2 {
    static void print(NodeRn start) {
        NodeRn ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data + ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    static NodeRn clone(NodeRn start) {
        NodeRn curr = start, temp = null;

        // insert additional node after every node of original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new NodeRn(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = start;

        // adjust the random pointers of the newly added nodes
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            }

            // move to the next newly added node by
            // skipping an original node
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }

        NodeRn original = start, copy = start.next;
        // save the start of copied linked list
        temp = copy;

        // now separate the original list and copied list
        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : original.next;

            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        NodeRn start = new NodeRn(1);
        start.next = new NodeRn(2);
        start.next.next = new NodeRn(3);
        start.next.next.next = new NodeRn(4);
        start.next.next.next.next = new NodeRn(5);
        // 1's random points to 3
        start.random = start.next.next;
        // 2's random points to 1
        start.next.random = start;
        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;
        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        NodeRn cloned_list = clone(start);
        print(cloned_list);

    }
}
