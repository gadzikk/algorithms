package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class ReverseDirected2 {
    // https://www.geeksforgeeks.org/transpose-graph/
    private static int vertices = 5;
    private static List<Integer>[] adj = new ArrayList[vertices];
    private static List<Integer>[] reversed = new ArrayList[vertices];

    public static void addedge(int source, int destination, boolean choice) {
        if (!choice) {
            adj[source].add(destination);
        } else {
            reversed[source].add(destination);
        }
    }

    public static void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "--> ");
            for (int j = 0; j < reversed[i].size(); j++) {
                System.out.print(reversed[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void getTranspose() {
        for (int source = 0; source < vertices; source++) {
            for (int destination = 0; destination < adj[source].size(); destination++) {
                addedge(adj[source].get(destination), source, true);
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
            reversed[i] = new ArrayList<>();
        }
        addedge(0, 1, false);
        addedge(0, 4, false);
        addedge(0, 3, false);
        addedge(2, 0, false);
        addedge(3, 2, false);
        addedge(4, 1, false);
        addedge(4, 3, false);
        getTranspose();
        printGraph();
    }
}
