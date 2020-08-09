package trees;

import zobjects.NodeC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by gadzik on 07.08.20.
 */
public class ReverseAlternateLevels3 {
    // https://www.geeksforgeeks.org/reverse-alternate-levels-of-a-perfect-binary-tree-using-stack/

    static NodeC newNode(char key) {
        NodeC temp = new NodeC();
        temp.data = key;
        temp.left = temp.right = null;
        return (temp);
    }

    static void inorder(NodeC root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void reverseAlternate(NodeC root) {
        Queue<NodeC> q = new LinkedList<>();
        q.add(root);
        NodeC temp;

        int n;
        int level = 1;

        Stack<Character> s = new Stack<>();
        while (!q.isEmpty()) {
            n = q.size();
            while (n != 0) {
                if (!q.isEmpty()) {
                    temp = q.peek();
                    q.remove();
                } else {
                    temp = null;
                }

                if (level % 2 != 0) {
                    if (temp != null && temp.left != null) {
                        q.add(temp.left);
                        s.push(temp.left.data);
                    }

                    if (temp != null && temp.right != null) {
                        q.add(temp.right);
                        s.push(temp.right.data);
                    }
                } else {
                    temp.data = s.peek();
                    s.pop();

                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
                n--;
            }

            level++;
        }
    }

    public static void main(String[] args) {
        NodeC root = newNode('a');
        root.left = newNode('b');
        root.right = newNode('c');
        root.left.left = newNode('d');
        root.left.right = newNode('e');
        root.right.left = newNode('f');
        root.right.right = newNode('g');
        root.left.left.left = newNode('h');
        root.left.left.right = newNode('i');
        root.left.right.left = newNode('j');
        root.left.right.right = newNode('k');
        root.right.left.left = newNode('l');
        root.right.left.right = newNode('m');
        root.right.right.left = newNode('n');
        root.right.right.right = newNode('o');

        System.out.println("Inorder Traversal of given tree");
        inorder(root);

        reverseAlternate(root);

        System.out.println("\nInorder Traversal of modified tree");
        inorder(root);
    }
}
