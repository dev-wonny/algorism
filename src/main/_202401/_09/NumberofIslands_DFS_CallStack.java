package main._202401._09;

import java.awt.Point;

// https://leetcode.com/problems/number-of-islands/description/
public class NumberofIslands_DFS_CallStack {
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
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                // 체크만한다 진짜로 섬 낱개를 카운트 하는 부분
                // O(1)로 검증하기에 빠르다
                if (!visited[i][j] && grid[i][j] == '1') {
                    DFS(new Point(i, j), visited, grid);
                    islandCount++;
                }
            }// for end

        }// for end


        return islandCount;
    }// numIslands end

    private static void DFS(Point point, boolean[][] visited, char[][] grid) {
        // 체크와 더이상 접근 못하게 막도록 구현 -> 애를 제거함, 그래서 더 진행 못했음

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
                visited[nx][ny] = true;
                DFS(new Point(nx, ny), visited, grid);// 조건에 맞을때만 수행
            }
        }
    }// DPS end
}// class end