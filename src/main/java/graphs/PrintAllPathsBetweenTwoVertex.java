package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class PrintAllPathsBetweenTwoVertex {
    // https://www.geeksforgeeks.org/find-paths-given-source-destination/
    private int V;
    private List<Integer>[] adjList;

    public PrintAllPathsBetweenTwoVertex(int vertices) {
        this.V = vertices;
        initAdjList();
    }

    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    public void printAllPaths(int source, int destination) {
        boolean[] isVisited = new boolean[V];
        List<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        printAllPathsUtil(source, destination, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer source, Integer destination, boolean[] visited, List<Integer> localPathList) {
        visited[source] = true;

        if (source.equals(destination)) {
            System.out.println(localPathList);
            visited[source] = false;
            return;
        }

        for (Integer vertex : adjList[source]) {
            if (!visited[vertex]) {
                localPathList.add(vertex);
                printAllPathsUtil(vertex, destination, visited, localPathList);
                localPathList.remove(vertex);
            }
        }

        visited[source] = false;
    }

    public static void main(String[] args) {
        PrintAllPathsBetweenTwoVertex g = new PrintAllPathsBetweenTwoVertex(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        int source = 2;
        int destination = 3;
        System.out.println("Following are all different paths from " + source + " to " + destination);
        g.printAllPaths(source, destination);
    }
}
