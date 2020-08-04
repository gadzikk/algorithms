package trees;

import zobjects.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 04.08.20.
 */
public class CheckLevelorder {
    // https://www.geeksforgeeks.org/check-given-array-can-represent-level-order-traversal-binary-search-tree/
    static class NodeDetails {
        int data;
        int min, max;
    }

    static boolean levelOrderIsOfBST(int arr[], int n) {

        if (n == 0) {
            return true;
        }

        Queue<NodeDetails> q = new LinkedList<>();

        int i = 0;

        NodeDetails newNode = new NodeDetails();
        newNode.data = arr[i];
        i++;
        newNode.min = Integer.MIN_VALUE;
        newNode.max = Integer.MAX_VALUE;
        q.add(newNode);

        while (i != n && q.size() > 0) {
            NodeDetails temp = q.peek();
            q.remove();
            newNode = new NodeDetails();
            if (i < n && (arr[i] < temp.data && arr[i] > temp.min)) {
                newNode.data = arr[i];
                i++;
                newNode.min = temp.min;
                newNode.max = temp.data;
                q.add(newNode);
            }

            newNode = new NodeDetails();
            if (i < n && (arr[i] > temp.data && arr[i] < temp.max)) {
                newNode.data = arr[i];
                i++;
                newNode.min = temp.data;
                newNode.max = temp.max;
                q.add(newNode);
            }
        }

        if (i == n) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n = arr.length;
        if (levelOrderIsOfBST(arr, n))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}
