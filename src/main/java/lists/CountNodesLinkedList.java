package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 16.07.20.
 */
public class CountNodesLinkedList {
    // https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
    NodeL head;

    public void push(int new_data) {
        NodeL new_node = new NodeL(new_data);
        new_node.next = head;
        head = new_node;
    }

    public int getCount() {
        NodeL temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int getCountRec(NodeL node)
    {
        if (node == null) {
            return 0;
        }
        return 1 + getCountRec(node.next);
    }

    public int countRec()
    {
        return getCountRec(head);
    }

    public static void main(String[] args) {
        CountNodesLinkedList llist = new CountNodesLinkedList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Count of nodes is " + llist.getCount());
//        System.out.println("Count of nodes is " + llist.countRec());
    }
}
