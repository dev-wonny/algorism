package main._202502;

//https://neetcode.io/problems/max-area-of-island
public class MaxAreaofIsland {

    public static void main(String[] args) {
        MaxAreaofIsland maxAreaofIsland = new MaxAreaofIsland();

        int[][] grid = new int[][] {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {0, 1, 1, 0, 1},
            {0, 1, 0, 0, 1}
        };

        System.out.println("Output: 6, result: " + maxAreaofIsland.maxAreaOfIsland(grid));
    }

    private static class Area {
        int max = 0;

        public Area(int max) {
            this.max = max;
        }
    }

    private int maxAreaOfIsland(int[][] grid) {
        Area area = new Area(0);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    DFS(x, y, grid, area, 1);
                }
            }
        }
        return area.max;
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    private void DFS(int x, int y, int[][] grid, Area area, int currenArea) {
        // 방문처리
        grid[x][y] = 0;

        // 상하좌우
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX >= 0
                && nextY >= 0
                && nextX < grid.length
                && nextY < grid[0].length
                && grid[nextX][nextY] == 1) {
                currenArea++;
                DFS(nextX, nextY, grid, area, currenArea);
            }// if end

            // 더 이상 진행 못할떄, currenArea 반영
            else {
                if (area.max < currenArea) {
                    area.max = currenArea;
                }
            }
        }// for end
    }// DFS end
}
