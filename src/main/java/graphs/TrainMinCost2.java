package graphs;

/**
 * Created by gadzik on 17.08.20.
 */
public class TrainMinCost2 {
    // https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
    static int INF = Integer.MAX_VALUE, N = 4;

    static int minCost(int costs[][]) {
        int distances[] = new int[N];
        for (int i = 0; i < N; i++) {
            distances[i] = INF;
        }

        distances[0] = 0;

        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                if (distances[row] + costs[row][col] < distances[col]) {
                    distances[col] = distances[row] + costs[row][col];
                }
            }
        }

        return distances[N - 1];
    }


    public static void main(String args[]) {
        int cost[][] = {{0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        System.out.println("The Minimum cost to reach station " + N +
                " is " + minCost(cost));
    }
}
