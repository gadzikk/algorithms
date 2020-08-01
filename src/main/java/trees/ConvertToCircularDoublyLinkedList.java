package trees;

import zobjects.Node;

/**
 * Created by gadzik on 31.07.20.
 */
public class ConvertToCircularDoublyLinkedList {
    // https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
    Node root;

    public Node concatenate(Node leftList, Node rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        // Store the last Node of left List
        // Store the last Node of right List
        Node lastLeftNode = leftList.left;
        Node lastRightNode = rightList.left;

        // Connect the last node of Left List with the first Node of the right List
        lastLeftNode.right = rightList;
        rightList.left = lastLeftNode;

        // left of first node refers to the last node in the list
        // Right of last node refers to the first node of the List
        leftList.left = lastRightNode;
        lastRightNode.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    public Node bTreeToCList(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively convert left and right subtrees
        Node left = bTreeToCList(root.left);
        Node right = bTreeToCList(root.right);

        // Make a circular linked list of single node (or root). To do so, make the right and left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the right List)
        return concatenate(concatenate(left, root), right);
    }

    // Display Circular Link List
    public void display(Node head) {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }

    public ConvertToCircularDoublyLinkedList() {
        root = null;
    }

    public static void main(String args[]) {
        ConvertToCircularDoublyLinkedList tree = new ConvertToCircularDoublyLinkedList();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node head = tree.bTreeToCList(tree.root);
        tree.display(head);
    }
}
