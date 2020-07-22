package lists;

import zobjects.NodeL;

import java.util.HashSet;

/**
 * Created by gadzik on 22.07.20.
 */
public class IntersectionPointOfTwo2 {
    // https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

    public static NodeL MegeNode(NodeL n1, NodeL n2) {
        HashSet<NodeL> hs = new HashSet<>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }

    public static void Print(NodeL n) {
        NodeL cur = n;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeL n1 = new NodeL(1);
        n1.next = new NodeL(2);
        n1.next.next = new NodeL(3);
        n1.next.next.next = new NodeL(4);
        n1.next.next.next.next = new NodeL(5);
        n1.next.next.next.next.next = new NodeL(6);
        n1.next.next.next.next.next.next = new NodeL(7);
        NodeL n2 = new NodeL(10);
        n2.next = new NodeL(9);
        n2.next.next = new NodeL(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.println(MegeNode(n1, n2).data);
    }


}
