package main._202502;

import java.util.LinkedList;
import java.util.Queue;

//https://neetcode.io/problems/rotting-fruit
public class RottingFruit {
    public static void main(String[] args) {
        RottingFruit c = new RottingFruit();
//        System.out.println("Input: grid = [[1,1,0],[0,1,1],[0,1,2]] --> Output: 4, result: " + c.orangesRotting(new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 1, 2}}));
//        System.out.println("Input: grid = [[1,0,1],[0,2,0],[1,0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{1, 0, 1}, {0, 2, 0}, {1, 0, 1}}));
//        System.out.println("Input: grid = [[2,1,1],[0,1,1],[1,0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
//        System.out.println("Input: grid = [[0,1]] --> Output: -1, result: " + c.orangesRotting(new int[][] {{0, 1}}));
//
//        // 2가 2개 이상인 경우도 있음 -> Queue 사용해야함
//        System.out.println("Input: grid = [[2,1,1],[1,1,1],[0,1,2]] --> Output: 2, result: " + c.orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));
//
//        // 0으로 되어있는 경우
        System.out.println("Input: grid = [[0]] --> Output: 0, result: " + c.orangesRotting(new int[][] {{0}}));
        System.out.println("Input: grid = [[1],[2]] --> Output: 1, result: " + c.orangesRotting(new int[][] {{1}, {2}}));
    }

    private class Point {
        int x = 0;
        int y = 0;
        int distance = 0;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private int orangesRotting(int[][] grid) {
        Queue<Point> rottenPointQue = new LinkedList<>();
        int result = 0;

        // 2를 추가 해놓는다
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    rottenPointQue.add(new Point(x, y, 0));
                }
            }
        }

        // queue 사용

        while (!rottenPointQue.isEmpty()) {
            Point poll = rottenPointQue.poll();// unlinkFirst
            int x = poll.x;
            int y = poll.y;
            int distance = poll.distance;

            //이동이 우선이다
            for (int[] direct : directions) {
                int newX = x + direct[0];
                int newY = y + direct[1];

                if (newX >= 0
                    && newY >= 0
                    && newX < grid.length
                    && newY < grid[0].length
                    && grid[newX][newY] == 1) {

                    // 변경, 방문 못하게 막음
                    grid[newX][newY] = 2;
                    rottenPointQue.add(new Point(newX, newY, distance + 1));

                }//if end

            }//for end

            // 더 이상 이동을 못하면 distance 리턴함
            result = Math.max(result, distance);

        }//while end

        // 1이 있는지 검색
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    private int BFS(Point poll, int[][] grid, Queue<Point> rottenPointQue) {
        return 0;
    }

    private int orangesRottingDFS(int[][] grid) {
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
                && newY < grid[0].length
                && grid[newX][newY] == 1) {
                // 변경
                grid[newX][newY] = 2;
                maxCount = Math.max(maxCount, DFS(newX, newY, count + 1, grid));
            }//if end

        }//for end

        return Math.max(count, maxCount);
    }
}
