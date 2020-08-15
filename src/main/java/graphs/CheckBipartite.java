package graphs;

import java.util.LinkedList;

/**
 * Created by gadzik on 14.08.20.
 */
public class CheckBipartite {
    // https://www.geeksforgeeks.org/bipartite-graph/
    final static int V = 4;

    boolean isBipartite(int G[][], int src) {
        // The value 1 is used to indicate first color is assigned and value 0 indicates second color is assigned.
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i) {
            colorArr[i] = -1;
        }
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);

        while (q.size() != 0) {
            int qVertex = q.poll();
            // Return false if there is a self-loop
            if (G[qVertex][qVertex] == 1) {
                return false;
            }

            for (int vertex = 0; vertex < V; ++vertex) {
                if (G[qVertex][vertex] == 1 && colorArr[vertex] == -1) {
                    colorArr[vertex] = 1 - colorArr[qVertex];
                    q.add(vertex);
                } else if (G[qVertex][vertex] == 1 && colorArr[vertex] == colorArr[qVertex]) {
                    return false;
                }
            }
        }
        // If we reach here, then all adjacent vertices can be colored with alternate color
        return true;
    }

    public static void main(String[] args) {
        int G[][] = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        CheckBipartite b = new CheckBipartite();
        if (b.isBipartite(G, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
