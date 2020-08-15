package graphs;

/**
 * Created by gadzik on 14.08.20.
 */
public class CheckBipartite4 {
    // https://algorithms.tutorialhorizon.com/check-if-graph-is-bipartite-adjacency-matrix-using-depth-first-searchdfs/
    enum Color {
        WHITE, RED, GREEN
    }

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) {
            return true;
        }

        int vertices = graph.length;
        Color colors[] = new Color[vertices];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.WHITE;
        }

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (colors[vertex] == Color.WHITE) {
                boolean result = isBipartiteUtil(vertex, vertices, colors, graph);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int u, int vertices, Color[] colors, int[][] graph) {

        //if is it first vertex, mark it RED
        if (u == 0) {
            colors[u] = Color.RED;
        }

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (graph[u][vertex] == 1 && colors[vertex] == Color.WHITE) {
                if (colors[u] == Color.RED) {
                    colors[vertex] = Color.GREEN;
                } else if (colors[u] == Color.GREEN) {
                    colors[vertex] = Color.RED;
                }

                return isBipartiteUtil(vertex, vertices, colors, graph);
            } else if (graph[u][vertex] == 1 && colors[u] == colors[vertex]) {
                return false;
            }
        }
        // if here means graph is successfully colored in 2 color, red and green graph is bipartite
        return true;
    }


    public static void main(String[] args) {
        CheckBipartite4 c = new CheckBipartite4();
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 0}
        };
        boolean result = c.isBipartite(graph);
        System.out.println("Graph is Bipartite: " + result);
        System.out.println("--------------------------");
        int[][] graph1 = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };
        result = c.isBipartite(graph1);
        System.out.println("Graph is Bipartite: " + result);
    }
}
