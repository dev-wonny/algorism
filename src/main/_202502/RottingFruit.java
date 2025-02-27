package main._202502;

//https://neetcode.io/problems/rotting-fruit
public class RottingFruit {
    public static void main(String[] args) {
        RottingFruit c = new RottingFruit();
//        System.out.println("Input: grid = [[1,1,0],[0,1,1],[0,1,2]] --> Output: 4, result: " + c.orangesRotting(new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 1, 2}}));
//        System.out.println("Input: grid = [[1,0,1],[0,2,0],[1,0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{1, 0, 1}, {0, 2, 0}, {1, 0, 1}}));
//        System.out.println("Input: grid = [[2,1,1],[0,1,1],[1,0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println("Input: grid = [[0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{0, 1}}));
        System.out.println("Input: grid = [[2,1,1],[1,1,1],[0,1,2]] --> Output: 2, result: " + c.orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));

    }

    private int orangesRotting(int[][] grid) {
        int targetX = -1;
        int targetY = -1;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    targetX = x;
                    targetY = y;
                }
            }
        }
        int result = DFS(targetX, targetY, 0, grid);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

    private int DFS(int x, int y, int count, int[][] grid) {
        int maxCount = -1;

        //이동
        for (int[] direct : directions) {
            int newX = x + direct[0];
            int newY = y + direct[1];

            if (newX >= 0
                && newY >= 0
                && newX < grid.length
                && newY < grid.length
                && grid[newX][newY] == 1) {
                // 변경
                grid[newX][newY] = 2;
                maxCount = Math.max(maxCount, DFS(newX, newY, count + 1, grid));
            }//if end

        }//for end

        return Math.max(count, maxCount);
    }
}
