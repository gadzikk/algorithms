package lists;

import zobjects.NodeL;

import java.util.Objects;

/**
 * Created by gadzik on 16.07.20.
 */
public class DeleteNodeWithoutHead {
    // https://www.geeksforgeeks.org/delete-a-node-from-linked-list-without-head-pointer/
    // https://stackoverflow.com/questions/17539326/delete-a-last-node-of-linked-list-given-pointer-to-that-node
    public static void deleteNode(NodeL n) {
        if (n == null || n.next == null) {
            System.out.println("Delete not possible");
            return;
        }

        n.data = n.next.data;
        NodeL tmp = n.next;
        n.next = n.next.next;
        tmp.next = null;

        System.out.println("Node Deleted");
    }

    public static void removeWithoutHead(NodeL node) {

        NodeL prev = null;
        while (!Objects.isNull(node.getNext())) {
            node.setData(node.getNext().getData());
            prev = node;
            node = node.getNext();
        }

        prev.setNext(null);
    }


    public static void main(String[] args) {
        NodeL node1 = new NodeL(1);
        NodeL node2 = new NodeL(2);
        NodeL node3 = new NodeL(3);
        NodeL node4 = new NodeL(4);
        NodeL node5 = new NodeL(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        DeleteNodeWithoutHead.removeWithoutHead(node3);
        DeleteNodeWithoutHead.removeWithoutHead(node3);

    }
}
