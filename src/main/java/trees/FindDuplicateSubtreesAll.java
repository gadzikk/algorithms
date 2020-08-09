package trees;

import zobjects.Node;

import java.util.HashMap;

/**
 * Created by gadzik on 08.08.20.
 */
public class FindDuplicateSubtreesAll {
    // https://www.geeksforgeeks.org/find-duplicate-subtrees/
    static HashMap<String, Integer> map;

    static String inorder(Node node) {
        if (node == null) {
            return "";
        }

        String str = "(";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.right);
        str += ")";

        if (map.get(str) != null && map.get(str) == 1) {
            System.out.print(node.data + " ");
        }

        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }


        return str;
    }

    static void printAllDups(Node root) {
        map = new HashMap<>();
        inorder(root);
    }

    public static void main(String args[]) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}
