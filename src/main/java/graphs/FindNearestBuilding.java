package graphs;

import zobjects.BuildingBlock;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gadzik on 15.08.20.
 */
public class FindNearestBuilding {
    // https://algorithms.tutorialhorizon.com/find-the-nearest-building-which-has-bike-find-nearest-specific-vertex-from-source-in-a-graph/
    public static BuildingBlock findBike(int[][] buildings, int start_row, int start_col) {
        int distance = 0;

        if (buildings[start_row][start_col] == 1) {
            return new BuildingBlock(start_row, start_col, distance);
        }
        int length = buildings.length;

        boolean[][] visited = new boolean[length][length];
        visited[start_row][start_col] = true;

        Queue<BuildingBlock> queue = new LinkedList<>();
        BuildingBlock buildingBlock = new BuildingBlock(start_row, start_col, distance);
        queue.add(buildingBlock);

        while (queue.isEmpty() == false) {
            BuildingBlock building = queue.poll();
            int row = building.row;
            int col = building.col;
            int dist = building.distance;
            dist = dist + 1;

            //go up
            int dest_row = row - 1;
            int dest_col = col;
            if (dest_col >= 0 && dest_col < length && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if (buildings[dest_row][dest_col] == 1) {
                    return b1;
                }
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
            //go down
            dest_row = row + 1;
            dest_col = col;
            if (dest_col >= 0 && dest_col < length && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if (buildings[dest_row][dest_col] == 1) {
                    return b1;
                }
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
            //go left
            dest_row = row;
            dest_col = col - 1;
            if (dest_col >= 0 && dest_col < length && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if (buildings[dest_row][dest_col] == 1) {
                    return b1;
                }
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
            //go right
            dest_row = row;
            dest_col = col + 1;
            if (dest_col >= 0 && dest_col < length && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if (buildings[dest_row][dest_col] == 1) {
                    return b1;
                }
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
        }
        //if here that means bike is not found.
        return null;
    }

    public static BuildingBlock bikePresentProcessor(int[][] buildings ,int dest_row, int dest_col, int dist,
                                            boolean[][] visited, Queue<BuildingBlock> queue) {
        BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
        if (buildings[dest_row][dest_col] == 1) {
            return b1;
        }
        queue.add(b1);
        visited[dest_row][dest_col] = true;
        return null;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0}
        };
        int start_building_row = 0;
        int start_building_col = 3;
        BuildingBlock result = findBike(buildings, start_building_row, start_building_col);
        if (result != null) {
            int distance = result.distance;
            int dest_row = result.row;
            int dest_col = result.col;
            String buildingNo = start_building_row + "," + start_building_col;
            String destinationBuilding = dest_row + "," + dest_col;
            System.out.println("Source building No: " + buildingNo + "\n Nearest building " +
                    "where bike is available is: " + destinationBuilding + "\n" +
                    " at distance: " + distance);
        } else {
            System.out.println("No bike is present in the any community");
        }
    }
}
