package graphs;

/**
 * Created by gadzik on 15.08.20.
 */
public class Prim {
    // https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-matrix/
    static class Graph {
        int vertices;
        int matrix[][];

        public Graph(int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {
            matrix[source][destination] = weight;
            matrix[destination][source] = weight;
        }

        class ResultSet {
            int parent;
            int weight;
        }

        int getMinimumVertex(boolean[] mst, int[] keys) {
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i < vertices; i++) {
                if (mst[i] == false && keys[i] < minKey) {
                    minKey = keys[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void primMST() {
            boolean[] visited = new boolean[vertices];
            int[] keys = new int[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];

            for (int i = 0; i < vertices; i++) {
                keys[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
            }

            keys[0] = 0;
            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;

            for (int i = 0; i < vertices; i++) {
                int vertex = getMinimumVertex(visited, keys);
                visited[vertex] = true;

                for (int j = 0; j < vertices; j++) {
                    if (matrix[vertex][j] > 0) {
                        //check if this vertex 'j' already in visited and
                        //if no then check if keys needs an update or not
                        if (visited[j] == false && matrix[vertex][j] < keys[j]) {
                            keys[j] = matrix[vertex][j];
                            resultSet[j].parent = vertex;
                            resultSet[j].weight = keys[j];
                        }
                    }
                }
            }
            //print visited
            printMST(resultSet);
        }

        public void printMST(ResultSet[] resultSet) {
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 1; i < vertices; i++) {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent + " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.primMST();
    }
}
