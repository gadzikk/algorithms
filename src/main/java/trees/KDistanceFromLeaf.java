package trees;

import zobjects.Node;

/**
 * Created by gadzik on 06.08.20.
 */
public class KDistanceFromLeaf {
    // https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/

    Node root;

    void kDistantFromLeafUtil(Node node, int paths[], boolean visited[], int pathLength, int k) {
        // Base case
        if (node == null) {
            return;
        }

        paths[pathLength] = node.data;
        visited[pathLength] = false;
        pathLength++;

        if (node.left == null && node.right == null && pathLength - k - 1 >= 0 && visited[pathLength - k - 1] == false) {
            System.out.print(paths[pathLength - k - 1] + " ");
            visited[pathLength - k - 1] = true;
            return;
        }

        kDistantFromLeafUtil(node.left, paths, visited, pathLength, k);
        kDistantFromLeafUtil(node.right, paths, visited, pathLength, k);
    }

    void printKDistantfromLeaf(Node node, int k) {
        int path[] = new int[1000];
        boolean visited[] = new boolean[1000];
        kDistantFromLeafUtil(node, path, visited, 0, k);
    }

    public static void main(String args[]) {
        KDistanceFromLeaf tree = new KDistanceFromLeaf();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 2 are :");
        tree.printKDistantfromLeaf(tree.root, 2);
    }
}
