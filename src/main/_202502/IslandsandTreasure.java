package main._202502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://neetcode.io/problems/islands-and-treasure
public class IslandsandTreasure {
    public static void main(String[] args) {
        IslandsandTreasure i = new IslandsandTreasure();
        int[][] matrix = {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        };

        i.islandsAndTreasure(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }

    }

    private class Point {
        int x;
        int y;
        int ditance;

        public Point(int x, int y, int ditance) {
            this.x = x;
            this.y = y;
            this.ditance = ditance;
        }
    }

    private void islandsAndTreasure(int[][] grid) {
        //TARGET 위치 찾기
        Queue<Point> targetQueue = new LinkedList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 0) {
                    targetQueue.add(new Point(x, y, 0));
                }
            }
        }

        while (!targetQueue.isEmpty()) {
            BFS(targetQueue, grid);
        }

    }

    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

    private void BFS(Queue<Point> targetQueue, int[][] grid) {
        Point curTarget = targetQueue.poll();

        // setting
        int curX = curTarget.x;
        int curY = curTarget.y;
        int diffDistance = curTarget.ditance;

        int prevValue = grid[curX][curY];
        grid[curX][curY] = Math.min(prevValue, diffDistance);

        // move
        for (int[] direction : directions) {
            int newX = curX + direction[0];
            int newY = curY + direction[1];

            if (newX >= 0
                && newY >= 0
                && newX < grid.length
                && newY < grid[0].length
                && grid[newX][newY] != -1
                && grid[newX][newY] != 0
                && grid[newX][newY] == 2147483647 // 방문하지 않은 노드만 탐색
            ) {
                targetQueue.add(new Point(newX, newY, diffDistance + 1));
            }//if end
        }//for end
    }
}
