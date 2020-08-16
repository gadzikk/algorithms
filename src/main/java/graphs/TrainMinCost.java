package graphs;

/**
 * Created by gadzik on 17.08.20.
 */
public class TrainMinCost {
    // https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction
    static int INF = Integer.MAX_VALUE, N = 4;

    static int minCostRec(int costs[][], int source, int destination) {
        if (source == destination || source + 1 == destination) {
            return costs[source][destination];
        }

        int min = costs[source][destination];

        for (int i = source + 1; i < destination; i++) {
            int countedCost = minCostRec(costs, source, i) + minCostRec(costs, i, destination);
            if (countedCost < min) {
                min = countedCost;
            }
        }
        return min;
    }

    static int minCost(int cost[][]) {
        return minCostRec(cost, 0, N - 1);
    }

    public static void main(String args[]) {
        int cost[][] = {
                {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        System.out.println("The Minimum cost to reach station " + N + " is " + minCost(cost));
    }
}
