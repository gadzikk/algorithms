package arrays;

/**
 * Created by gadzik on 09.07.20.
 */
public class MinStepsToReachDest {
    // https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
    static int steps(int source, int step, int dest) {
        System.out.println("source: " + source + " step:" + step + "dest:" + dest);
        // base cases
        if (Math.abs(source) > (dest)) {
            return Integer.MAX_VALUE;
        }

        if (source == dest) {
            return step;
        }

        // at each point we can go either way
        // if we go on positive side
        int pos = steps(source + step + 1, step + 1, dest);
        // if we go on negative side
        int neg = steps(source - step - 1, step + 1, dest);
        // minimum of both cases
        return Math.min(pos, neg);
    }

    public static void main(String[] args) {
        int dest = 11;
        System.out.println("No. of steps required" +
                " to reach " + dest +
                " is " + steps(0, 0, dest));
    }
}
