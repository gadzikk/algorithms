package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.08.20.
 */
public class WaterConnection {
    // https://www.geeksforgeeks.org/water-connection-problem/
    static int numberOfHouses, numberOfPipes;

    static int endingVertex[] = new int[1100];
    static int diameters[] = new int[1100];
    static int startingVertex[] = new int[1100];

    static List<Integer> aResult = new ArrayList<>();
    static List<Integer> bResult = new ArrayList<>();
    static List<Integer> cResult = new ArrayList<>();

    static int ans;

    static int dfs(int vertex) {
        if (startingVertex[vertex] == 0) {
            return vertex;
        }

        if (diameters[vertex] < ans) {
            ans = diameters[vertex];
        }

        return dfs(startingVertex[vertex]);
    }

    static void solve(int arr[][]) {
        int i = 0;

        while (i < numberOfPipes) {
            int q = arr[i][0];
            int h = arr[i][1];
            int t = arr[i][2];

            startingVertex[q] = h;
            diameters[q] = t;
            endingVertex[h] = q;
            i++;
        }

        aResult = new ArrayList<>();
        bResult = new ArrayList<>();
        cResult = new ArrayList<>();

        for (int j = 1; j <= numberOfHouses; ++j)

            if (endingVertex[j] == 0 && startingVertex[j] > 0) {
                ans = 1000000000;
                int w = dfs(j);

                // We put the details of  component in final output array
                aResult.add(j);
                bResult.add(w);
                cResult.add(ans);
            }

        System.out.println(aResult.size());

        for (int j = 0; j < aResult.size(); ++j) {
            System.out.println(aResult.get(j) + " " + bResult.get(j) + " " + cResult.get(j));
        }
    }

    public static void main(String args[]) {
        numberOfHouses = 9;
        numberOfPipes = 6;

        for (int i = 0; i < 1100; i++) {
            endingVertex[i] = startingVertex[i] = diameters[i] = 0;
        }

        int arr[][] = {
                {7, 4, 98},
                {5, 9, 72},
                {4, 6, 10},
                {2, 8, 22},
                {9, 7, 17},
                {3, 1, 66}
        };
        solve(arr);
    }
}
