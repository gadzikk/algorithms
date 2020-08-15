package graphs;

import zobjects.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gadzik on 14.08.20.
 */
public class NumberOfDistinctIslands {
    // https://algorithms.tutorialhorizon.com/find-the-number-of-distinct-islands-or-connected-components/
    public void findDistinctIslands(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return;
        }
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<List<Pair<Integer, Integer>>> islands = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int start_x = row;
                    int start_y = col;
                    List<Pair<Integer, Integer>> island = new ArrayList<>();
                    findIsland(grid, row, col, start_x, start_y, visited, island);
                    islands.add(island);
                }
            }
        }

        if (islands.size() > 0) {
            System.out.println("No of unique distinct islands are: " + islands.size());
        } else {
            System.out.println("No island in the given grid");
        }
    }

    public void findIsland(int[][] grid, int row, int col, int start_x, int start_y, boolean[][] visited, List<Pair<Integer, Integer>> island) {
        int highBound = grid.length;
        int lowBound = grid[0].length;

        if (row < 0 || col < 0 || row >= highBound || col >= lowBound || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        island.add(new Pair<>(row - start_x, col - start_y));
        visited[row][col] = true;
        findIsland(grid, row + 1, col, start_x, start_y, visited, island); // go right
        findIsland(grid, row - 1, col, start_x, start_y, visited, island); //go left
        findIsland(grid, row, col + 1, start_x, start_y, visited, island); //go down
        findIsland(grid, row, col - 1, start_x, start_y, visited, island); // go up
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };

        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        n.findDistinctIslands(grid);
    }
}
