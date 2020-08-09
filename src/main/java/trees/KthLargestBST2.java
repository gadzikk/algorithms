package trees;

import zobjects.Node;

/**
 * Created by gadzik on 07.08.20.
 */
public class KthLargestBST2 {
    // https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
    Node root;

    KthLargestBST2() {
        root = null;
    }

    public void insert(int data) {
        this.root = this.insertRec(this.root, data);
    }

    Node insertRec(Node node, int data) {
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        if (data == node.data) {
            return node;
        }

        if (data < node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    public class Counter {
        int c = 0;
    }

    void kthLargestUtil(Node node, int k, Counter counter) {
        if (node == null || counter.c >= k) {
            return;
        }

        this.kthLargestUtil(node.right, k, counter);
        counter.c++;

        if (counter.c == k) {
            System.out.println(k + "th largest element is " + node.data);
            return;
        }

        this.kthLargestUtil(node.left, k, counter);
    }

    void kthLargest(int k) {
        Counter c = new Counter();
        this.kthLargestUtil(this.root, k, c);
    }

    public static void main(String[] args) {
        KthLargestBST2 tree = new KthLargestBST2();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }

}
