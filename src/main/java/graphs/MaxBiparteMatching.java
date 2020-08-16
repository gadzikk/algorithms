package graphs;

/**
 * Created by gadzik on 16.08.20.
 */
public class MaxBiparteMatching {
    // https://www.geeksforgeeks.org/maximum-bipartite-matching/

    static final int M = 6;
    static final int N = 6;

    boolean bpm(boolean bpGraph[][], int vertex, boolean seen[], int matchesAplicantJob[]) {
        for (int v = 0; v < N; v++) {
            if (bpGraph[vertex][v] && !seen[v]) {
                seen[v] = true;
                if (matchesAplicantJob[v] < 0 || bpm(bpGraph, matchesAplicantJob[v], seen, matchesAplicantJob)) {
                    matchesAplicantJob[v] = vertex;
                    return true;
                }
            }
        }
        return false;
    }

    int maxBPM(boolean bpGraph[][]) {
        int matchesAplicantJob[] = new int[N];

        for (int i = 0; i < N; ++i) {
            matchesAplicantJob[i] = -1;
        }

        int result = 0;
        for (int u = 0; u < M; u++) {
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; ++i) {
                seen[i] = false;
            }

            if (bpm(bpGraph, u, seen, matchesAplicantJob)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean bpGraph[][] = new boolean[][]{
                {false, true, true, false, false, false},
                {true, false, false, true, false, false},
                {false, false, true, false, false, false},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, true}};
        MaxBiparteMatching m = new MaxBiparteMatching();
        System.out.println("Maximum number of applicants that can" + " get job is " + m.maxBPM(bpGraph));
    }
}
