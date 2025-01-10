package main._202401._09;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/
public class NumberofIslands_DFS_Stack_DataStructure {
    public static void main(String[] args) {
        System.out.println("expect:1 , result: " +
            numIslands(

                new char[][] {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
                }
            )
        );

        System.out.println();
        System.out.println("expect:3 , result: " +
            numIslands(

                new char[][] {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
                }
            )
        );

    }// main end

    /**
     * 섬의 개수 구하기
     * DFS도 가능하다 그러나 O(N*M)
     * BFS는 O(min(N,M))으로 BFS가 시간복잡도가 빠르다
     */
    public static int numIslands(char[][] grid) {
        int X = grid.length;
        int Y = grid[0].length;
        // 그래프는 있음
        // 방문 기록
        boolean[][] visited = new boolean[X][Y];

        // dfs로 그래프 탐색

        // 스택 사용
        // 재귀함수
        // 스택 자료구조

        //전체 for문 카운트 세기
        int islandCount = 0;

        // 이걸로 하기에는 중간에 맥이 끊긴다. 카운트를 더 세어버림 계속해서 돌려야할 필요성이 있음
        // call stack이 아닌, stack 자료구조로 변경
        Queue<Point> stack = new ArrayDeque<>();

        stack.add(new Point(0, 0));

        // islandCount++;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                // 검증은 넣어라
                if ((!visited[i][j] && grid[i][j] == '1')) {
                    // queue 추가
                    stack.add(new Point(i, j));
                    DFS(stack, visited, grid);
                    islandCount++;
                }//if end
            }// for end
        }// for end
        return islandCount;
    }// numIslands end

    private static void DFS(Queue<Point> stack, boolean[][] visited, char[][] grid) {
        // 범위 안에 들면 DFS적용 끝가지 감
        while (!stack.isEmpty()) {
            Point point = stack.poll();

            // 자기 자신 방문 체크
            visited[point.x][point.y] = true;

            // 상하좌우
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동
            for (int[] direction : directions) {
                int nx = point.x + direction[0];
                int ny = point.y + direction[1];

                // 범위 안에 들면 DFS적용 끝가지 감
                if (
                    nx >= 0
                        && ny >= 0
                        && nx < visited.length
                        && ny < visited[0].length

                        && !visited[nx][ny]
                        && grid[nx][ny] == '1'
                ) {
                    stack.add(new Point(nx, ny));
                }
            }// directions for end
        }// while end
    }// DFS end
}// class end