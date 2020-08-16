package graphs;

import java.util.Vector;

/**
 * Created by gadzik on 16.08.20.
 */
public class DominantSet {
    // https://www.geeksforgeeks.org/dominant-set-of-a-graph/
    static Vector<Integer>[] g;
    static boolean[] box = new boolean[100000];

    static Vector<Integer> dominant(int numberOfVertices) {
        Vector<Integer> set = new Vector<>();
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            if (!box[vertex]) {
                set.add(vertex);
                box[vertex] = true;
                for (int j = 0; j < g[vertex].size(); j++) {
                    if (!box[g[vertex].get(j)]) {
                        box[g[vertex].get(j)] = true;
                        break;
                    }
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int V = 5;
        g = new Vector[V];
        for (int i = 0; i < V; i++) {
            g[i] = new Vector<>();
        }


        g[0].add(1);
        g[1].add(0); // x = 1, y = 2 ;
        g[1].add(2);
        g[2].add(1); // x = 2, y = 3 ;
        g[2].add(3);
        g[3].add(2); // x = 3, y = 4 ;
        g[0].add(3);
        g[3].add(0); // x = 1, y = 4 ;
        g[3].add(4);
        g[4].add(3); // x = 4, y = 5 ;
        g[2].add(4);
        g[4].add(2); // x = 3, y = 5 ;

        Vector<Integer> set = dominant(V);
        System.out.print("The Dominant Set is : { ");
        for (int i = 0; i < set.size(); i++) {
            System.out.print(set.get(i) + 1 + " ");
        }
        System.out.print("}");
    }
}
