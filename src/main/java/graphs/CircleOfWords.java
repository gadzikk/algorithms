package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class CircleOfWords {
    // https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
    static final int CHARS = 26;

    int V;
    List<List<Integer>> adj;
    int[] in;

    CircleOfWords(int V) {
        this.V = V;
        in = new int[V];
        adj = new ArrayList<>(CHARS);

        for (int i = 0; i < CHARS; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        in[destination]++;
    }

    boolean isEulerianCycle() {
        if (!isSC()) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() != in[i]) {
                return false;
            }
        }

        return true;
    }

    boolean isSC() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        int n;
        for (n = 0; n < V; n++) {
            if (adj.get(n).size() > 0) {
                break;
            }
        }

        DFSUtil(n, visited);

        // If DFS traversal doesn't visit all
        // vertices, then return false.
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;
            }
        }

        CircleOfWords gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        gr.DFSUtil(n, visited);

        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    void DFSUtil(int vertex, boolean[] visited) {

        visited[vertex] = true;
        for (Integer i : adj.get(vertex)) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    CircleOfWords getTranspose() {
        CircleOfWords g = new CircleOfWords(V);
        for (int v = 0; v < V; v++) {
            for (Integer i : adj.get(v)) {
                g.adj.get(i).add(v);
                g.in[v]++;
            }
        }
        return g;
    }

    static boolean canBeChained(String[] arr, int n) {
        CircleOfWords g = new CircleOfWords(CHARS);

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            g.addEdge(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
        }
        return g.isEulerianCycle();
    }

    public static void main(String[] args) throws Exception {
        String[] arr1 = {"for", "geek", "rig", "kaf"};
        int n1 = arr1.length;
        System.out.println((canBeChained(arr1, n1) ? "Can be chained " : "Can't be chained "));
        String[] arr2 = {"aab", "abb"};
        int n2 = arr2.length;
        System.out.println((canBeChained(arr2, n2) ? "Can be chained " : "Can't be chained "));
    }
}
