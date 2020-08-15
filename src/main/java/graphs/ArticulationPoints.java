package graphs;

import java.util.*;

/**
 * Created by gadzik on 14.08.20.
 */
public class ArticulationPoints {
    // https://algorithms.tutorialhorizon.com/articulation-points-or-cut-vertices-in-a-graph/
    static class Graph {
        int vertices;
        LinkedList<Integer> adjList[];

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int vertex = 0; vertex < vertices; vertex++) {
                adjList[vertex] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
        }
    }

    int time = 0;
    List<Integer> articulationResult = new ArrayList<>();

    public void findArticulationPoints(Graph graph) {
        int vertices = graph.vertices;
        Map<Integer, Integer> visitTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        boolean[] visited = new boolean[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                DFS(graph, vertex, visitTime, lowTime, visited, parent);
            }
        }

        if (articulationResult.size() > 0) {
            System.out.println("Articulation Points are: " + Arrays.toString(articulationResult.toArray()));
        } else {
            System.out.println("No Articulation Points in the given graph");
        }

    }

    public void DFS(Graph graph, int currentVertex, Map<Integer, Integer> discoveryTime, Map<Integer, Integer> lowTime, boolean[] visited, Map<Integer, Integer> parent) {
        LinkedList<Integer> adjList[] = graph.adjList;
        int childCount = 0;
        boolean canArticulationPoint = false;
        visited[currentVertex] = true;

        discoveryTime.put(currentVertex, time);
        lowTime.put(currentVertex, time);
        time++;
        for (int i = 0; i < adjList[currentVertex].size(); i++) {
            int adjacentVertex = adjList[currentVertex].get(i);
            if (!visited[adjacentVertex]) {
                parent.put(adjacentVertex, currentVertex);
                childCount++;
                DFS(graph, adjacentVertex, discoveryTime, lowTime, visited, parent);

                if (discoveryTime.get(currentVertex) <= lowTime.get(adjacentVertex)) {
                    canArticulationPoint = true;
                } else {
                    int currLowTime = lowTime.get(currentVertex);
                    lowTime.put(currentVertex, Math.min(currLowTime, lowTime.get(adjacentVertex)));
                }
            } else {
                int currLowTime = lowTime.get(currentVertex);
                lowTime.put(currentVertex, Math.min(currLowTime, discoveryTime.get(adjacentVertex)));
            }
        }
        //after visiting all the adjacent vertices check if current vertex is articulation point
        if ((parent.get(currentVertex) == null && childCount > 1) || (parent.get(currentVertex) != null && canArticulationPoint)) {
            articulationResult.add(currentVertex);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);

        ArticulationPoints ap = new ArticulationPoints();
        ap.findArticulationPoints(graph);
    }
}
