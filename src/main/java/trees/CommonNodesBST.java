package trees;

import zobjects.Node;

import java.util.Stack;

/**
 * Created by gadzik on 02.08.20.
 */
public class CommonNodesBST {
    // https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/

    static void printCommon(Node root1, Node root2) {

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        while (true) {
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            } else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();

                if (root1.data == root2.data) {
                    System.out.print(root1.data + " ");
                    s1.pop();
                    s2.pop();

                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data < root2.data) {
                    s1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else if (root1.data > root2.data) {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            } else {
                break;
            }
        }
    }

    // A utility function to do inorder traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static Node newNode(int ele) {
        Node temp = new Node();
        temp.data = ele;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public static void main(String[] args) {
        Node root1 = null;
        root1 = insert(root1, 5);
        root1 = insert(root1, 1);
        root1 = insert(root1, 10);
        root1 = insert(root1, 0);
        root1 = insert(root1, 4);
        root1 = insert(root1, 7);
        root1 = insert(root1, 9);

        // Create second tree as shown in example
        Node root2 = null;
        root2 = insert(root2, 10);
        root2 = insert(root2, 7);
        root2 = insert(root2, 20);
        root2 = insert(root2, 4);
        root2 = insert(root2, 9);

        System.out.print("Tree 1 : " + "\n");
        inorder(root1);
        System.out.println();
        System.out.print("Tree 2 : " + "\n");
        inorder(root2);
        System.out.println();
        System.out.println("Common Nodes: ");

        printCommon(root1, root2);

    }
}
