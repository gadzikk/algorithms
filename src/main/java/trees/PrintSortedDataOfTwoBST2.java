package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintSortedDataOfTwoBST2 {
    // https://www.techiedelight.com/merge-two-bsts-into-doubly-linked-list-sorted-order/
    public static Node convertBSTtoDLL(Node root, Node head) {
        if (root == null) {
            return head;
        }

        head = convertBSTtoDLL(root.right, head);
        head = push(root, head);
        head = convertBSTtoDLL(root.left, head);

        return head;
    }

    public static Node mergeDDLs(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.data < b.data) {
            a.right = mergeDDLs(a.right, b);
            a.right.left = a;
            return a;
        } else {
            b.right = mergeDDLs(a, b.right);
            b.right.left = b;
            return b;
        }
    }

    public static Node merge(Node a, Node b) {
        Node first = null;
        first = convertBSTtoDLL(a, first);

        Node second = null;
        second = convertBSTtoDLL(b, second);

        return mergeDDLs(first, second);
    }

    public static void printDoublyList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.right;
        }
        System.out.print("null");
    }

    public static Node push(Node root, Node head) {
        root.right = head;

        if (head != null) {
            head.left = root;
        }

        head = root;
        return head;
    }

    public static void main(String[] args) {
        /*
        Construct first BST
			  20
			 /  \
			10  30
			   /  \
			  25  100
		*/

        Node a = new Node(20);
        a.left = new Node(10);
        a.right = new Node(30);
        a.right.left = new Node(25);
        a.right.right = new Node(100);

		/*
		Construct second BST
			  50
			 /  \
			5   70
		*/

        Node b = new Node(50);
        b.left = new Node(5);
        b.right = new Node(70);

        Node root = merge(a, b);
        printDoublyList(root);
    }
}
