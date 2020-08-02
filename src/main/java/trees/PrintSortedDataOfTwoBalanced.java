package trees;

import zobjects.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 02.08.20.
 */
public class PrintSortedDataOfTwoBalanced {
// https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
    Node root;

    PrintSortedDataOfTwoBalanced() {
        root = null;
    }

    void inorder() {
        inorderUtil(this.root);
    }

    void inorderUtil(Node node) {
        if (node == null) {
            return;
        }

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }


    // A Utility Method that stores inorder traversal of a tree
    public List<Integer> storeInorderUtil(Node node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        storeInorderUtil(node.left, list);
        list.add(node.data);
        storeInorderUtil(node.right, list);

        return list;
    }

    // Method that stores inorder traversal of a tree
    List<Integer> storeInorder(Node node) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = storeInorderUtil(node, list1);
        return list2;
    }

    List<Integer> merge(List<Integer> list1, List<Integer> list2, int m, int n) {

        List<Integer> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < m) {
            list3.add(list1.get(i));
            i++;
        }

        while (j < n) {
            list3.add(list2.get(j));
            j++;
        }

        return list3;
    }

    Node ALtoBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(list.get(mid));

        node.left = ALtoBST(list, start, mid - 1);
        node.right = ALtoBST(list, mid + 1, end);

        return node;
    }

    Node mergeTrees(Node node1, Node node2) {
        List<Integer> list1 = storeInorder(node1);
        List<Integer> list2 = storeInorder(node2);
        List<Integer> list3 = merge(list1, list2, list1.size(), list2.size());
        Node node = ALtoBST(list3, 0, list3.size() - 1);
        return node;
    }

    public static void main(String[] args) {

        /* Creating following tree as First balanced BST
                100
                / \
                50 300
                / \
               20 70
        */

        PrintSortedDataOfTwoBalanced tree1 = new PrintSortedDataOfTwoBalanced();
        tree1.root = new Node(100);
        tree1.root.left = new Node(50);
        tree1.root.right = new Node(300);
        tree1.root.left.left = new Node(20);
        tree1.root.left.right = new Node(70);

        /* Creating following tree as second balanced BST
                80
                / \
              40 120
        */

        PrintSortedDataOfTwoBalanced tree2 = new PrintSortedDataOfTwoBalanced();
        tree2.root = new Node(80);
        tree2.root.left = new Node(40);
        tree2.root.right = new Node(120);

        PrintSortedDataOfTwoBalanced tree = new PrintSortedDataOfTwoBalanced();
        tree.root = tree.mergeTrees(tree1.root, tree2.root);
        System.out.println("The Inorder traversal of the merged BST is: ");
        tree.inorder();
    }
}
