package main._202501._22;

import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14502
public class 연구소 {
    public static void main(String[] args) {

        System.out.println("expect: 27, result:"
                + BFS(
                new int[][]
                    {
                        {2, 0, 0, 0, 1, 1, 0},
                        {0, 0, 1, 0, 1, 2, 0},
                        {0, 1, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0}
                    }
            )
        );


        System.out.println("expect: 9, result:"
                + BFS(
                new int[][]
                    {
                        {0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 2},
                        {1, 1, 1, 0, 0, 2},
                        {0, 0, 0, 0, 0, 2}
                    }
            )
        );


        System.out.println("expect: 3, result:"
                + BFS(
                new int[][]
                    {
                        {2, 0, 0, 0, 0, 0, 0, 2},
                        {2, 0, 0, 0, 0, 0, 0, 2},
                        {2, 0, 0, 0, 0, 0, 0, 2},
                        {2, 0, 0, 0, 0, 0, 0, 2},
                        {2, 0, 0, 0, 0, 0, 0, 2},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                    }
            )
        );


    }

    private static int maxSafeArea = 0; // 최대 안전 영역


    public static int BFS(int[][] grid) {
        maxSafeArea = 0; // 최대 안전 영역 초기화
        buildWall(grid, 0);
        return maxSafeArea;
    }


    // 벽 세우기 및 최대 안전 영역 계산
    private static void buildWall(int[][] map, int count) {
        if (count == 3) { // 벽 3개를 모두 세웠으면
            maxSafeArea = Math.max(maxSafeArea, calcSafety(map)); // 안전 영역 계산
            return;
        }

        int h = map.length;
        int w = map[0].length;

        // 벽을 세울 수 있는 모든 위치 탐색
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == 0) { // 빈 공간
                    map[y][x] = 1; // 벽 설치

                    buildWall(map, count + 1);
                    map[y][x] = 0; // 벽 복구
                }
            }
        }
    }

    // 바이러스 확산 후 안전 영역 계산
    private static int calcSafety(int[][] map) {
        int h = map.length;
        int w = map[0].length;
        int[][] temp = new int[h][w];

        // 맵 복사
        for (int i = 0; i < h; i++) {
            temp[i] = map[i].clone();
        }

        // 바이러스 확산
        Queue<int[]> queue = new LinkedList<>();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (temp[y][x] == 2) { // 바이러스 발견
                    queue.add(new int[] {y, x});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < h && nx < w && temp[ny][nx] == 0) {
                    temp[ny][nx] = 2; // 바이러스 확산
                    queue.add(new int[] {ny, nx});
                }
            }
        }

        // 안전 영역 계산
        int safeArea = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (temp[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    public static int BFS2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // BFS를 위한 방향 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 위치를 찾고 큐에 추가
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 유효한 좌표인지 확인
                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    // 빈 공간(0)일 경우 감염 확산
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2; // 감염 표시
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }// queue while end

        // 안전 영역 계산
        int safeArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea; // 안전 영역 크기 반환
    }
}
