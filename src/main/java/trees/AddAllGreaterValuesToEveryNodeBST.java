package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class AddAllGreaterValuesToEveryNodeBST {
    // https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
    Node root;



    Node insertRec(Node node, int data) {
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        if (data <= node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    public class Sum {
        int sum = 0;
    }

    void modifyBSTUtil(Node node, Sum S) {
        if (node == null) {
            return;
        }

        this.modifyBSTUtil(node.right, S);

        S.sum = S.sum + node.data;
        node.data = S.sum;

        this.modifyBSTUtil(node.left, S);
    }

    void modifyBST(Node node) {
        Sum S = new Sum();
        this.modifyBSTUtil(node, S);
    }

    AddAllGreaterValuesToEveryNodeBST() {
        root = null;
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void insert(int data) {
        this.root = this.insertRec(this.root, data);
    }

    public static void main(String[] args) {
        AddAllGreaterValuesToEveryNodeBST tree = new AddAllGreaterValuesToEveryNodeBST();

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

        tree.modifyBST(tree.root);
        tree.inOrder(tree.root);
    }
}
