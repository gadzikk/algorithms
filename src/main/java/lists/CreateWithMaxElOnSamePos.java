package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 25.07.20.
 */
public class CreateWithMaxElOnSamePos {
    // https://www.geeksforgeeks.org/create-a-linked-list-from-two-linked-lists-by-choosing-max-element-at-each-position/?ref=rp
    static NodeL insert(NodeL root, int item) {
        NodeL ptr, temp;
        temp = new NodeL();
        temp.data = item;
        temp.next = null;

        if (root == null)
            root = temp;
        else {
            ptr = root;
            while (ptr.next != null)
                ptr = ptr.next;

            ptr.next = temp;
        }
        return root;
    }

    // Function to print the
// nodes of a linked list
    static void display(NodeL root) {
        while (root != null) {
            System.out.print(root.data + " - > ");
            root = root.next;
        }
        System.out.print("null");
    }

    // Function to generate the required
// linked list and return its head
    static NodeL newList(NodeL root1, NodeL root2) {
        NodeL ptr1 = root1, ptr2 = root2;
        NodeL root = null;

        // While there are nodes left
        while (ptr1 != null) {

            // Maximum node at current position
            int currMax = ((ptr1.data < ptr2.data) ? ptr2.data : ptr1.data);

            // If current node is the first node
            // of the newly linked list being
            // generated then assign it to the root
            if (root == null) {
                NodeL temp = new NodeL();
                temp.data = currMax;
                temp.next = null;
                root = temp;
            }

            // Else insert the newly
            // created node in the end
            else {
                root = insert(root, currMax);
            }

            // Get to the next nodes
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Return the head of the
        // generated linked list
        return root;
    }

    // Driver code
    public static void main(String args[]) {
        NodeL root1 = null, root2 = null, root = null;

        // First linked list
        root1 = insert(root1, 5);
        root1 = insert(root1, 2);
        root1 = insert(root1, 3);
        root1 = insert(root1, 8);

        // Second linked list
        root2 = insert(root2, 1);
        root2 = insert(root2, 7);
        root2 = insert(root2, 4);
        root2 = insert(root2, 5);

        // Generate the new linked list
        // and get its head
        root = newList(root1, root2);

        // Display the nodes of the generated list
        display(root);

    }
}
