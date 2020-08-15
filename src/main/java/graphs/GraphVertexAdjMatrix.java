package graphs;

/**
 * Created by gadzik on 14.08.20.
 */
public class GraphVertexAdjMatrix {
    //
    private int V;
    private int[][] g = new int[10][10];

    GraphVertexAdjMatrix(int x) {
        this.V = x;

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                g[i][j] = 0;
            }
        }
    }

    public void displayAdjacencyMatrix() {
        System.out.print("\n\n Adjacency Matrix:");

        for (int i = 0; i < V; ++i) {
            System.out.println();
            for (int j = 0; j < V; ++j) {
                System.out.print(" " + g[i][j]);
            }
        }
    }

    public void addEdge(int x, int y) {
        if ((x >= V) || (y > V)) {
            System.out.println("Vertex does not exists!");
        }

        if (x == y) {
            System.out.println("Same Vertex!");
        } else {
            g[y][x] = 1;
            g[x][y] = 1;
        }
    }

    public void addVertex() {
        V++;
        for (int vertex = 0; vertex < V; ++vertex) {
            g[vertex][V - 1] = 0;
            g[V - 1][vertex] = 0;
        }
    }

    public void removeVertex(int x) {
        if (x > V) {
            System.out.println("Vertex not present!");
            return;
        } else {

            while (x < V) {
                for (int vertex = 0; vertex < V; ++vertex) {
                    g[vertex][x] = g[vertex][x + 1];
                }

                for (int vertex = 0; vertex < V; ++vertex) {
                    g[x][vertex] = g[x + 1][vertex];
                }
                x++;
            }

            V--;
        }
    }

    public static void main(String[] args) {
        GraphVertexAdjMatrix obj = new GraphVertexAdjMatrix(4);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);
        obj.displayAdjacencyMatrix();
        obj.addVertex();
        obj.addEdge(4, 1);
        obj.addEdge(4, 3);
        obj.displayAdjacencyMatrix();
        obj.removeVertex(1);
        obj.displayAdjacencyMatrix();
    }
}
