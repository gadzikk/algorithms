package graphs;

/**
 * Created by gadzik on 14.08.20.
 */
public class GraphEdgeAdjMatrix {
    // https://www.geeksforgeeks.org/add-and-remove-edge-in-adjacency-matrix-representation-of-a-graph/
    private int V;
    private int[][] g = new int[10][10];

    GraphEdgeAdjMatrix(int x) {
        this.V = x;
        for (int rows = 0; rows < V; ++rows) {
            for (int cols = 0; cols < V; ++cols) {
                g[rows][cols] = 0;
            }
        }
    }

    public void displayAdjacencyMatrix() {
        for (int rows = 0; rows < V; ++rows) {
            System.out.println();
            for (int cols = 0; cols < V; ++cols) {
                System.out.print(" " + g[rows][cols]);
            }
        }

        System.out.println();
    }

    public void addEdge(int x, int y) {
        if ((x < 0) || (x >= V)) {
            System.out.printf("Vertex " + x + " does not exist!");
        }
        if ((y < 0) || (y >= V)) {
            System.out.printf("Vertex " + y + " does not exist!");
        }

        if (x == y) {
            System.out.println("Same Vertex!");
        } else {
            g[y][x] = 1;
            g[x][y] = 1;
        }
    }

    // Function to update adjacency
    // matrix for edge removal
    public void removeEdge(int x, int y) {
        if ((x < 0) || (x >= V)) {
            System.out.printf("Vertex " + x + " does not exist!");
        }

        if ((y < 0) || (y >= V)) {
            System.out.printf("Vertex " + y + " does not exist!");
        }

        if (x == y) {
            System.out.println("Same Vertex!");
        } else {
            g[y][x] = 0;
            g[x][y] = 0;
        }
    }

    public static void main(String[] args) {

        int N = 6, X = 2, Y = 3;
        GraphEdgeAdjMatrix obj = new GraphEdgeAdjMatrix(N);

        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(0, 3);
        obj.addEdge(0, 4);
        obj.addEdge(1, 3);
        obj.addEdge(2, 3);
        obj.addEdge(2, 4);
        obj.addEdge(2, 5);
        obj.addEdge(3, 5);

        System.out.println("Adjacency matrix after" + " edge insertions:");
        obj.displayAdjacencyMatrix();
        obj.removeEdge(2, 3);
        System.out.println("\nAdjacency matrix after" + " edge removal:");
        obj.displayAdjacencyMatrix();
    }
}
