package zobjects;

import java.util.LinkedList;

/**
 * Created by gadzik on 15.08.20.
 */
public class GraphV {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    public GraphV(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
}
