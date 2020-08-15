package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 14.08.20.
 */
public class ConvertAdjMatrixToAdjList {
    // https://www.geeksforgeeks.org/convert-adjacency-matrix-to-adjacency-list-representation-of-graph/
    static List<List<Integer>> convert(int[][] a) {
        // no of vertices
        int size = a[0].length;
        List<List<Integer>> adjListArray = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            adjListArray.add(new ArrayList<>());
        }

        for (int row = 0; row < a[0].length; row++) {
            for (int col = 0; col < a.length; col++) {
                if (a[row][col] == 1) {
                    adjListArray.get(row).add(col);
                }
            }
        }

        return adjListArray;
    }

    static void printArrayList(List<List<Integer>> adjListArray) {
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1},
                {0, 0, 1},
                {1, 1, 0}
        };

        List<List<Integer>> adjListArray = convert(a);
        System.out.println("Adjacency List: ");
        printArrayList(adjListArray);
    }
}
