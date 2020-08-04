package trees;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by gadzik on 04.08.20.
 */
public class ShortestDistanceTwoNodesInfinityTree {
    // https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-an-infinite-binary-tree/

    static Vector<Integer> v1 = new Vector<Integer>();
    static Vector<Integer> v2 = new Vector<Integer>();

    static int BinarySearch(int x) {
        int low = 0;
        int high = v2.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (v2.get(mid) == x) {
                return mid;
            } else if (x < v2.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static void MakeAncestorNode1(int x) {
        v1.clear();
        while (x > 0) {
            v1.add(x);
            x /= 2;
        }
        Collections.reverse(v1);
    }

    static void MakeAncestorNode2(int x) {
        v2.clear();
        while (x > 0) {
            v2.add(x);
            x /= 2;
        }
        Collections.reverse(v2);
    }

    static int Distance() {
        for (int i = v1.size() - 1; i >= 0; i--) {
            int x = BinarySearch(v1.get(i));
            if (x != -1) {
                return v1.size() - 1 - i + v2.size() - 1 - x;
            }
        }
        return Integer.MAX_VALUE;
    }

    // Driver code
    public static void main(String[] args) {
        int node1 = 2, node2 = 3;

        // find ancestors
        MakeAncestorNode1(node1);
        MakeAncestorNode2(node2);

        System.out.print("Distance between " + node1 + " and " + node2 + " is : " + Distance());
    }
}
