package main._202502;

import java.util.ArrayList;

//https://leetcode.com/problems/number-of-closed-islands
public class NumberofClosedIslands {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) {
        // 0: 섬
        // 1: 물
        int[][] grid1 = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };
        int[][] grid2 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
        };

        System.out.println("Output: 2, result: " + closedIsland(grid1));
        System.out.println("Output: 1, result: " + closedIsland(grid2));


    }

    private static int closedIsland(int[][] grid) {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 0) {
                    ArrayList<Integer> stopList = new ArrayList<>();// 초기화
                    DFS(x, y, grid, stopList);

                    // 개수 올리기
                    if (stopList.isEmpty()) {
                        count++;
                    }
                }
            }// for end
        }// for end

        return count;
    }

    private static void DFS(int x, int y, int[][] grid, ArrayList<Integer> stopList) {
        // 방문하면 0-> 2로 바꾸자
        grid[x][y] = 2;

        // 상하좌우 -> 0에서 2로 바꿔야해서 다 순회해야함, 멈추면 안됨
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX >= 0
                && nextY >= 0
                && nextX < grid.length
                && nextY < grid[0].length
                && grid[nextX][nextY] == 0) {
                DFS(nextX, nextY, grid, stopList);
            }
        }

        // x, y가 0, length-1이 포함된게 하나라도 있으면 실패!
        if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) {
            stopList.add(x);
        }

    }// DFS end
}
