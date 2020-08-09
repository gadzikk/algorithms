package trees;

import zobjects.Node;

import java.util.Vector;

/**
 * Created by gadzik on 09.08.20.
 */
public class TripletForSumBST {
    // https://www.geeksforgeeks.org/check-if-a-triplet-with-given-sum-exists-in-bst/

    static boolean checkForTriplet(Node root, int sum) {
        Vector<Integer> vec = new Vector<Integer>();
        inorder(root, vec);
        int left, right;

        for (int i = 0; i < vec.size() - 2; i++) {
            left = i + 1;
            right = vec.size() - 1;
            while (left < right) {
                if (vec.get(i) + vec.get(left) + vec.get(right) == sum) {
                    return true;
                } else if (vec.get(i) + vec.get(left) + vec.get(right) < sum) {
                    left++;
                } else {
                    right--;
                }
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

    static void inorder(Node root, Vector<Integer> vec) {
        if (root != null) {
            inorder(root.left, vec);
            vec.add(root.data);
            inorder(root.right, vec);
        }
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
    /* Let us create following BST
        50
        /     \
    30     70
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

        int sum = 120;

        if (checkForTriplet(root, sum)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
