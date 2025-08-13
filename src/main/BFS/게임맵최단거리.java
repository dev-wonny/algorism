package main.BFS;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        System.out.println("expect: 11, result:"
                + new 게임맵최단거리().solution(
                new int[][]
                    {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                    }
            )
        );

    }

    static int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    private int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        // IMPORTANT: Set the distance of the starting cell to 1.
        // This makes sure the path length correctly increments from 1.
        maps[0][0] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 현재 지점이 목표 지점(가장 오른쪽 아래 칸)이면, 현재까지의 거리를 반환합니다.
            if (p.x == rows - 1 && p.y == cols - 1) {
                return maps[p.x][p.y];
            }

            for (int[] d : direction) {

                int nx = p.x + d[0];
                int ny = p.y + d[1];

                if (nx >= 0 &&
                    nx < maps.length &&
                    ny >= 0 &&
                    ny < maps[0].length
                ) {
                    if (maps[nx][ny] == 1) {
                        // 다음 위치에 현재 위치의 거리 + 1을 저장합니다.
                        // 한번 방문한 곳은 다시 방문하지 않게(중복 탐색 방지) 되는 효과
                        maps[nx][ny] = maps[p.x][p.y] + 1;
                        // 다음 위치를 큐에 추가하여 탐색을 계속합니다.
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        if (maps[rows - 1][cols - 1] == 1) {
            return -1; // 도달할 수 없는 경우
        } else {
            return maps[rows - 1][cols - 1]; // 도달했다면 최단 거리를 반환합니다.
        }
    }

    private void bfs(int[][] maps, int x, int y) {
        // 박힌 벽
        if (maps[x][y] == 0) {
            return;
        }

        // 방문 체크
        if (maps[x][y] > 1) {
            return;
        }

        // 나를 들어온 기준으로 상하좌우 이동
        for (int[] d : direction) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    bfs(maps, nx, ny);
                }
            }
        }//for end
    }//if end
}
