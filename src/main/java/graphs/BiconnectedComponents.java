package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gadzik on 16.08.20.
 */
public class BiconnectedComponents {
    // https://www.geeksforgeeks.org/biconnected-components/

    static class Edge {
        int u;
        int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Graph {
        static int count = 0, time = 0;
        private int V, E;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            E = 0;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }


        void addEdge(int v, int w) {
            adj[v].add(w);
            E++;
        }

        void BCCUtil(int vertex, int disc[], int low[], LinkedList<Edge> st, int parent[]) {
            disc[vertex] = low[vertex] = ++time;
            int children = 0;

            Iterator<Integer> it = adj[vertex].iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (disc[v] == -1) {
                    children++;
                    parent[v] = vertex;

                    st.add(new Edge(vertex, v));
                    BCCUtil(v, disc, low, st, parent);

                    if (low[vertex] > low[v]) {
                        low[vertex] = low[v];
                    }

                    if ((disc[vertex] == 1 && children > 1) || (disc[vertex] > 1 && low[v] >= disc[vertex])) {
                        while (st.getLast().u != vertex || st.getLast().v != v) {
                            System.out.print(st.getLast().u + "--" + st.getLast().v + " ");
                            st.removeLast();
                        }
                        System.out.println(st.getLast().u + "--" + st.getLast().v + " ");
                        st.removeLast();
                        count++;
                    }
                } else if (v != parent[vertex] && disc[v] < disc[vertex]) {
                    if (low[vertex] > disc[v]) {
                        low[vertex] = disc[v];
                    }

                    st.add(new Edge(vertex, v));
                }
            }
        }

        void BCC() {
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            LinkedList<Edge> st = new LinkedList<Edge>();

            for (int i = 0; i < V; i++) {
                disc[i] = -1;
                low[i] = -1;
                parent[i] = -1;
            }

            for (int i = 0; i < V; i++) {
                if (disc[i] == -1) {
                    BCCUtil(i, disc, low, st, parent);
                }

                int j = 0;

                while (st.size() > 0) {
                    j = 1;
                    System.out.print(st.getLast().u + "--" + st.getLast().v + " ");
                    st.removeLast();
                }

                if (j == 1) {
                    System.out.println();
                    count++;
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(12);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(0, 6);
        g.addEdge(6, 0);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
        g.addEdge(5, 7);
        g.addEdge(7, 5);
        g.addEdge(5, 8);
        g.addEdge(8, 5);
        g.addEdge(7, 8);
        g.addEdge(8, 7);
        g.addEdge(8, 9);
        g.addEdge(9, 8);
        g.addEdge(10, 11);
        g.addEdge(11, 10);
        g.BCC();
        System.out.println("Above are " + g.count + " biconnected components in graph");
    }
}
