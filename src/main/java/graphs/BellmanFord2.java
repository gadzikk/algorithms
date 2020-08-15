package graphs;

import zobjects.GraphE;

/**
 * Created by gadzik on 15.08.20.
 */
public class BellmanFord2 {
    // https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
    void BellmanFord(GraphE graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int vertex = 1; vertex < V; ++vertex) {
            for (int edge = 0; edge < E; ++edge) {
                int sourceVertex = graph.edge[edge].src;
                int destVertex = graph.edge[edge].dest;
                int weight = graph.edge[edge].weight;
                if (dist[sourceVertex] != Integer.MAX_VALUE && dist[sourceVertex] + weight < dist[destVertex]) {
                    dist[destVertex] = dist[sourceVertex] + weight;
                }
            }
        }

        // Step 3: check for negative-weight cycles. The above step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter path, then there is a cycle.
        for (int edge = 0; edge < E; ++edge) {
            int sourceVertex = graph.edge[edge].src;
            int destVertex = graph.edge[edge].dest;
            int weight = graph.edge[edge].weight;
            if (dist[sourceVertex] != Integer.MAX_VALUE && dist[sourceVertex] + weight < dist[destVertex]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, V);
    }

    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        GraphE graph = new GraphE(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        BellmanFord2 bellmanFord2 = new BellmanFord2();
        bellmanFord2.BellmanFord(graph, 0);
    }
}
