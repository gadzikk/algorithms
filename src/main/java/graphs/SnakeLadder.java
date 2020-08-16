package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 16.08.20.
 */
public class SnakeLadder {
    // https://www.geeksforgeeks.org/snake-ladder-problem-2/
    static class qentry {
        int v;// Vertex number
        int distance;// Distance of this vertex from source
    }

    // This function returns minimum number of dice
    // throws required to Reach last cell from 0'th cell
    // in a snake and ladder game. move[] is an array of
    // size N where N is no. of cells on board If there
    // is no snake or ladder from cell i, then move[i]
    // is -1 Otherwise move[i] contains cell to which
    // snake or ladder at i takes to.
    static int getMinDiceThrows(int move[], int n) {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry entry = new qentry();
        entry.v = 0;
        entry.distance = 0;
        visited[0] = 1;
        q.add(entry);

        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty()) {
            entry = q.remove();
            int v = entry.v;

            // If front vertex is the destination
            // vertex, we are done
            if (v == n - 1) {
                break;
            }

            for (int j = v + 1; j <= (v + 6) && j < n; ++j) {

                if (visited[j] == 0) {
                    qentry newEntry = new qentry();
                    newEntry.distance = entry.distance + 1;
                    visited[j] = 1;

                    // Check if there newEntry snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1) {
                        newEntry.v = move[j];
                    } else {
                        newEntry.v = j;
                    }
                    q.add(newEntry);
                }
            }
        }

        // We reach here when 'entry' has last vertex return the distance of vertex in 'entry'
        return entry.distance;
    }

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++) {
            moves[i] = -1;
        }

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
    }
}
