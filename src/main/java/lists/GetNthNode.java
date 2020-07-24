package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 23.07.20.
 */
public class GetNthNode {
    NodeL head;

    public int GetNth(int index) {
        NodeL current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        return 0;
    }

    public void push(int new_data) {
        NodeL new_Node = new NodeL(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public static void main(String[] args) {
        GetNthNode llist = new GetNthNode();
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        System.out.println("Element at index 3 is " + llist.GetNth(3));
    }
}
