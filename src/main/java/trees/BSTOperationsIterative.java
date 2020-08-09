package trees;

import zobjects.Node;

/**
 * Created by gadzik on 09.08.20.
 */
public class BSTOperationsIterative {
    // https://www.geeksforgeeks.org/iterative-searching-binary-search-tree/
    // https://www.geeksforgeeks.org/insert-a-node-in-binary-search-tree-iteratively/
    // https://www.netjstech.com/2019/03/delete-node-from-binary-search-tree-java.html

    Node root;

    static boolean iterativeSearch(Node root, int key) {
        while (root != null) {
            if (key > root.data) {
                root = root.right;
            } else if (key < root.data) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node root, int key) {
        Node newnode = newNode(key);
        Node x = root;
        Node y = null;

        while (x != null) {
            y = x;
            if (key < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            y = newnode;
        } else if (key < y.data) {
            y.left = newnode;
        } else {
            y.right = newnode;
        }

        return y;
    }

    public boolean delete(int value) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.data != value) {
            parent = current;
            if (value < current.data) {
                current = current.left;
                isLeftChild = true;
            } else {

                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }


        if (current.left == null && current.right == null) {
            System.out.println("Leaf node deletion case");

            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            System.out.println("One right child deletion case");

            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            System.out.println("One left child deletion case");
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            System.out.println("Two children deletion case");
            Node successor = findSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node findSuccessor(Node node) {
        Node successor = node;
        Node successorParent = node;
        Node current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    public static void main(String args[]) {
        /* Let us create following BST
            50
            / \
        30 70
        / \ / \
    20 40 60 80 */
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        if (iterativeSearch(root, 15)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
