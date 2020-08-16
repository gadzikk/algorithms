package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class TransitiveClosure {
    // https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
    final static int V = 4;

    void transitiveClosure(int graph[][]) {
        int reach[][] = new int[V][V];
        int row, col, k;

        for (row = 0; row < V; row++) {
            for (col = 0; col < V; col++) {
                reach[row][col] = graph[row][col];
            }
        }

        for (k = 0; k < V; k++) {
            for (row = 0; row < V; row++) {
                for (col = 0; col < V; col++) {
                    reach[row][col] = (reach[row][col] != 0) || ((reach[row][k] != 0) && (reach[k][col] != 0)) ? 1 : 0;
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(reach);
    }

    /* A utility function to print solution */
    void printSolution(int reach[][]) {
        System.out.println("Following matrix is transitive closure" +
                " of the given graph");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
        \|/        |
        (1)------->(2)
           3           */

        /* Let us create the following weighted graph

              10
         (0)------->(3)
          |         /|\
        5 |          |
          |          | 1
         \|/         |
         (1)------->(2)
            3           */
        int graph[][] = new int[][]{{1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        // Print the solution
        TransitiveClosure g = new TransitiveClosure();
        g.transitiveClosure(graph);
    }
}
