package main._202502;

//https://neetcode.io/problems/count-number-of-islands
public class NumberofIslands {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {

        char[][] grid1 = new char[][] {
            {'0', '1', '1', '1', '0'},
            {'0', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Output: 1, result:" + numIslands(grid1));

        char[][] grid2 = new char[][] {
            {'1', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Output: 4, result:" + numIslands(grid2));
    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    ++count;
                    DFS(x, y, grid);
                }
            }// for end
        }// for end

        return count;
    }

    private static void DFS(int x, int y, char[][] grid) {
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
                && grid[nextX][nextY] == '1') {
                DFS(nextX, nextY, grid);
            }
        }
    }// DFS end
}
