package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class Prim3 {
    // https://www.geeksforgeeks.org/prims-algorithm-simple-implementation-for-adjacency-matrix-representation
    static int V = 5;
    static int INT_MAX = Integer.MAX_VALUE;

    static boolean isValidEdge(int u, int v, boolean[] minimumSpanningTree) {
        if (u == v) {
            return false;
        }

        if (minimumSpanningTree[u] == false && minimumSpanningTree[v] == false) {
            return false;
        } else if (minimumSpanningTree[u] == true && minimumSpanningTree[v] == true) {
            return false;
        }

        return true;
    }

    static void primMST(int cost[][]) {
        boolean[] minimumSpanningTree = new boolean[V];
        minimumSpanningTree[0] = true;
        int edge_count = 0, mincost = 0;

        while (edge_count < V - 1) {
            int min = INT_MAX, a = -1, b = -1;

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (cost[i][j] < min) {
                        if (isValidEdge(i, j, minimumSpanningTree)) {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            if (a != -1 && b != -1) {
                System.out.printf("Edge %d:(%d, %d) cost: %d \n", edge_count++, a, b, min);
                mincost = mincost + min;
                minimumSpanningTree[b] = minimumSpanningTree[a] = true;
            }
        }
        System.out.printf("\n Minimum cost = %d \n", mincost);
    }

    public static void main(String[] args) {
    /* Let us create the following graph
        2 3
    (0)--(1)--(2)
    | / \ |
    6| 8/ \5 |7
    | /     \ |
    (3)-------(4)
            9         */
        int cost[][] = {
                {INT_MAX, 2, INT_MAX, 6, INT_MAX},
                {2, INT_MAX, 3, 8, 5},
                {INT_MAX, 3, INT_MAX, INT_MAX, 7},
                {6, 8, INT_MAX, INT_MAX, 9},
                {INT_MAX, 5, 7, 9, INT_MAX}
        };
        // Print the solution
        primMST(cost);
    }
}
