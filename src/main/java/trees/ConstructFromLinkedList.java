package trees;

import zobjects.Node;
import zobjects.NodeL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 01.08.20.
 */
public class ConstructFromLinkedList {
    // https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
    NodeL head;
    Node root;

    Node convertList2Binary(Node node) {
        Queue<Node> q = new LinkedList<Node>();

        if (head == null) {
            node = null;
            return null;
        }

        node = new Node(head.data);
        q.add(node);

        head = head.next;

        while (head != null) {
            // 2.a) take the parent node from the q and
            //      remove it from q
            Node parent = q.peek();
            q.poll();

            // 2.c) take next two nodes from the linked list.
            // We will add them as children of the current
            // parent node in step 2.b. Push them into the
            // queue so that they will be parents to the
            // future nodes
            Node leftChild = null;
            Node rightChild = null;

            leftChild = new Node(head.data);
            q.add(leftChild);
            head = head.next;
            if (head != null) {
                rightChild = new Node(head.data);
                q.add(rightChild);
                head = head.next;
            }

            parent.left = leftChild;
            parent.right = rightChild;
        }

        return node;
    }

    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void push(int new_data) {
        NodeL new_node = new NodeL(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String[] args) {
        ConstructFromLinkedList tree = new ConstructFromLinkedList();
        tree.push(36);
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10);
        Node node = tree.convertList2Binary(tree.root);

        System.out.println("Inorder Traversal of the" + " constructed Binary Tree is:");
        tree.inorderTraversal(node);
    }
}
