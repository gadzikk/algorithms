package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 15.08.20.
 */
public class FordFulkersonMaxFlow {
    // https://algorithms.tutorialhorizon.com/max-flow-problem-ford-fulkerson-algorithm/
    static class Graph {
        int vertices;
        int graph[][];

        public Graph(int vertex, int[][] graph) {
            this.vertices = vertex;
            this.graph = graph;
        }

        public int findMaxFlow(int source, int sink) {
            int[][] residualGraph = new int[vertices][vertices];

            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    residualGraph[i][j] = graph[i][j];
                }
            }

            int[] parent = new int[vertices];
            int max_flow = 0;

            while (isPathExist_BFS(residualGraph, source, sink, parent)) {
                //if here means still path exist from source to destination
                //parent [] will have the path from source to destination
                //find the capacity which can be passed though the path (in parent[])
                int flow_capacity = Integer.MAX_VALUE;
                int temp = sink;
                while (temp != source) {
                    int s = parent[temp];
                    flow_capacity = Math.min(flow_capacity, residualGraph[s][temp]);
                    temp = s;
                }

                //update the residual graph
                //reduce the capacity on fwd edge by flow_capacity
                //add the capacity on back edge by flow_capacity
                temp = sink;
                while (temp != source) {
                    int s = parent[temp];
                    residualGraph[s][temp] -= flow_capacity;
                    residualGraph[temp][s] += flow_capacity;
                    temp = s;
                }

                max_flow += flow_capacity;
            }
            return max_flow;
        }

        public boolean isPathExist_BFS(int[][] residualGraph, int src, int dest, int[] parent) {
            boolean pathFound = false;
            boolean[] visited = new boolean[vertices];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            parent[src] = -1;
            visited[src] = true;

            while (queue.isEmpty() == false) {
                int queueVertex = queue.poll();

                for (int vertex = 0; vertex < vertices; vertex++) {
                    if (visited[vertex] == false && residualGraph[queueVertex][vertex] > 0) {
                        queue.add(vertex);
                        parent[vertex] = queueVertex;
                        visited[vertex] = true;
                    }
                }
            }
            //check if dest is reached during BFS
            pathFound = visited[dest];
            return pathFound;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        int graph[][] = {
                {0, 10, 8, 0, 0, 0},
                {0, 0, 5, 5, 0, 0},
                {0, 4, 0, 0, 10, 0},
                {0, 0, 9, 0, 10, 3},
                {0, 0, 0, 6, 0, 14},
                {0, 0, 0, 0, 0, 0}
        };
        Graph g = new Graph(vertices, graph);
        int source = 0;
        int destination = 5;
        int max_flow = g.findMaxFlow(source, destination);
        System.out.println("Maximum flow from source: " + source + " to destination: " + destination + " is: " + max_flow);
    }
}
