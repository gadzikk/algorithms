package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class ConvertToDDL4 {
    // https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
    Node root;
    Node head;

    void BToDLL(Node root) {
        if (root == null) {
            return;
        }

        BToDLL(root.right);
        root.right = head;
        if (head != null) {
            (head).left = root;
        }

        head = root;
        BToDLL(root.left);
    }

    void printList(Node head) {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    public static void main(String[] args) {
        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9  */

        ConvertToDDL4 tree = new ConvertToDDL4();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        tree.BToDLL(tree.root);
        tree.printList(tree.head);
    }
}
