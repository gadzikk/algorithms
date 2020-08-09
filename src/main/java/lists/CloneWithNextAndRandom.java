package lists;

import zobjects.NodeRn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gadzik on 23.07.20.
 */
public class CloneWithNextAndRandom {
    // https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/

    NodeRn head;

    public CloneWithNextAndRandom(NodeRn head) {
        this.head = head;
    }

    public void push(int data) {
        NodeRn node = new NodeRn(data);
        node.next = this.head;
        this.head = node;
    }

    void print() {
        NodeRn temp = head;
        while (temp != null) {
            NodeRn random = temp.random;
            int randomData = (random != null) ? random.data : -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = " + randomData);
            temp = temp.next;
        }
    }

    public CloneWithNextAndRandom clone() {
        NodeRn origCurr = this.head;
        NodeRn cloneCurr = null;

        Map<NodeRn, NodeRn> map = new HashMap<>();

        // Traverse the original list and make a copy of that in the clone linked list.
        while (origCurr != null) {
            cloneCurr = new NodeRn(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        // Adjusting the original list reference again.
        origCurr = this.head;

        // Traversal of original list again to adjust the next and random references of clone list using hash map.
        while (origCurr != null) {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }

        //return the head reference of the clone list.
        return new CloneWithNextAndRandom(map.get(this.head));
    }

    public static void main(String[] args) {

        CloneWithNextAndRandom list = new CloneWithNextAndRandom(new NodeRn(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        CloneWithNextAndRandom clone = list.clone();

        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }
}
