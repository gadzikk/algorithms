package trees;

import zobjects.Node;

import java.util.Arrays;

/**
 * Created by gadzik on 09.08.20.
 */
public class BoundaryRootToLeafPath {
    // https://www.geeksforgeeks.org/boundary-root-to-leaf-path-traversal-of-a-binary-tree/

    static int row;
    static int count = 0;

    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.left = temp.right = null;
        return (temp);
    }

    static int lengthOfLongestPath(Node node) {
        if (node == null) {
            return 0;
        }

        int left = lengthOfLongestPath(node.left);
        int right = lengthOfLongestPath(node.right);
        return 1 + (left > right ? left : right);
    }

    static void copyPath(int[] path, int index, int[][] mtrx, int r) {

        for (int i = 0; i < index; i++) {
            mtrx[r][i] = path[i];
        }
    }

    static void storePath(Node node, int[] path, int index, int[][] mtrx) {

        if (node == null) {
            return;
        }

        path[index] = node.data;

        storePath(node.left, path, index + 1, mtrx);
        storePath(node.right, path, index + 1, mtrx);

        if (node.left == null && node.right == null) {
            row = row + 1;
            copyPath(path, index + 1, mtrx, row);
        }
    }

    static int totalPath(Node node) {
        if (node == null) {
            return count;
        }

        if (node.left == null && node.right == null) {
            return count + 1;
        }
        count = totalPath(node.left);
        return totalPath(node.right);
    }

    static void traverse_matrix(int[][] mtrx, int height, int width) {
        int j = 0, k1 = 0, k2 = 0;
        int k3 = height - 1;
        int k4 = width - 1;

        for (int round = 0; round < height / 2; round++) {
            for (j = k2; j < width; j++) {
                if (mtrx[k1][j] != Integer.MAX_VALUE) {
                    System.out.print(mtrx[k1][j] + " ");
                }
            }
            System.out.println();
            k2 = 0;
            k1++;
            for (j = k4; j >= 0; j--) {
                if (mtrx[k3][j] != Integer.MAX_VALUE) {
                    System.out.print(mtrx[k3][j] + " ");
                }
            }
            System.out.println();
            k4 = width - 1;
            k3--;
        }

        if (height % 2 != 0) {
            for (j = k2; j < width; j++) {
                if (mtrx[k1][j] != Integer.MAX_VALUE) {
                    System.out.print(mtrx[k1][j] + " ");
                }
            }
        }
    }

    static void PrintPath(Node node) {
        int max_len = lengthOfLongestPath(node);
        int total_path = totalPath(node);
        int[] path = new int[max_len];
        Arrays.fill(path, 0);
        int[][] mtrx = new int[total_path][max_len];
        for (int i = 0; i < total_path; i++) {
            for (int j = 0; j < max_len; j++) {
                mtrx[i][j] = Integer.MAX_VALUE;
            }
        }
        row = -1;
        storePath(node, path, 0, mtrx);
        traverse_matrix(mtrx, total_path, max_len);
    }

    public static void main(String[] args) {

    /* 10
      /  \
     13  11
        /  \
       19   23
      / \   / \
     21 29 43  15
              /
             7 */

        // Create Binary Tree as shown
        Node root = newNode(10);
        root.left = newNode(13);
        root.right = newNode(11);

        root.right.left = newNode(19);
        root.right.right = newNode(23);

        root.right.left.left = newNode(21);
        root.right.left.right = newNode(29);
        root.right.right.left = newNode(43);
        root.right.right.right = newNode(15);
        root.right.right.right.left = newNode(7);
        PrintPath(root);
    }
}
