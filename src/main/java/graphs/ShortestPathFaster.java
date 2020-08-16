package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 16.08.20.
 */
public class ShortestPathFaster {
    //
    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Vector<pair>[] graph = new Vector[100000];

    static void addEdge(int source, int destination, int weight) {
        graph[source].add(new pair(destination, weight));
    }

    static void print_distance(int distance[], int V) {
        System.out.print("Vertex \t\t Distance" + " from source" + "\n");

        for (int i = 1; i <= V; i++) {
            System.out.printf("%distance \t\t %distance\n", i, distance[i]);
        }
    }

    static void shortestPathFaster(int source, int V) {
        int[] distance = new int[V + 1];
        boolean[] inQueue = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        inQueue[source] = true;

        while (!q.isEmpty()) {
            int u = q.peek();
            q.remove();
            inQueue[u] = false;

            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i).first;
                int weight = graph[u].get(i).second;

                if (distance[v] > distance[u] + weight) {
                    distance[v] = distance[u] + weight;

                    if (!inQueue[v]) {
                        q.add(v);
                        inQueue[v] = true;
                    }
                }
            }
        }

        print_distance(distance, V);
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 1;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<>();
        }

        addEdge(1, 2, 1);
        addEdge(2, 3, 7);
        addEdge(2, 4, -2);
        addEdge(1, 3, 8);
        addEdge(1, 4, 9);
        addEdge(3, 4, 3);
        addEdge(2, 5, 3);
        addEdge(4, 5, -3);

        shortestPathFaster(source, V);
    }
}
