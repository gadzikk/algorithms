package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class RemoveCommons {
    // https://www.geeksforgeeks.org/remove-the-common-nodes-in-two-singly-linked-lists
    static void printList(NodeL p) {
        if (p == null) {
            System.out.print("[]");
        }

        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
    }

    static NodeL push(NodeL head_ref, int new_data) {
        NodeL new_node = new NodeL();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static NodeL traverse(NodeL head3, NodeL temp1, NodeL temp2) {
        // Traverse the first linked list
        while (temp1 != null) {
            // Value of current node
            int val = temp1.data;
            NodeL t = temp2;
            int x = 0;
            // Traverse the second list
            while (t != null) {
                if (t.data == val) {
                    x = 1;
                    break;
                }
                t = t.next;
            }

            // If element is not common then insert it in the resultant linked list
            if (x == 0) {
                head3 = push(head3, temp1.data);
            }

            temp1 = temp1.next;
        }
        return head3;
    }

    static void removeCommonNodes(NodeL head1, NodeL head2) {
        NodeL head3 = null;
        // Find the node common between linked list taking head1 as first linked list
        head3 = traverse(head3, head1, head2);
        // Find the node common between  linked list taking head2 as first linked list
        head3 = traverse(head3, head2, head1);
        // Print the resultant linked list
        printList(head3);
    }

    public static void main(String[] args) {
        NodeL head1 = new NodeL();
        head1 = push(head1, 20);
        head1 = push(head1, 5);
        head1 = push(head1, 15);
        head1 = push(head1, 10);

        NodeL head2 = new NodeL();
        head2 = push(head2, 10);
        head2 = push(head2, 20);
        head2 = push(head2, 15);
        head2 = push(head2, 8);

        removeCommonNodes(head1, head2);
    }
}
