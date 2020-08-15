package graphs;

/**
 * Created by gadzik on 14.08.20.
 */
public class NumberOfIslands {
    // https://algorithms.tutorialhorizon.com/number-of-islands/
    public int numIslands(char[][] islandGrid) {

        int rows = islandGrid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = islandGrid[0].length;
        int result = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (islandGrid[row][col] == '1') {
                    DFS(islandGrid, row, col);
                    result++;
                }
            }
        }
        return result;
    }

    public void DFS(char[][] islandGrid, int row, int col) {
        int rows = islandGrid.length;
        int cols = islandGrid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || islandGrid[row][col] != '1') {
            return;
        }

        islandGrid[row][col] = '0'; //marking it visited
        DFS(islandGrid, row + 1, col); // go right
        DFS(islandGrid, row - 1, col); //go left
        DFS(islandGrid, row, col + 1); //go down
        DFS(islandGrid, row, col - 1); // go up
    }

    public static void main(String[] args) {
        char[][] islandGrid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumberOfIslands noOfIslands = new NumberOfIslands();
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
        islandGrid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
    }
}
