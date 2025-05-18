package main._202505.BFS;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/250125
public class 이웃한칸 {
    public static void main(String[] args) {
        이웃한칸 o = new 이웃한칸();
        System.out.println(o.solution(
            new String[][]
                {
                    {"blue", "red", "orange", "red"}
                    , {"red", "red", "blue", "orange"}
                    , {"blue", "orange", "red", "red"}
                    , {"orange", "orange", "red", "blue"}
                }
            , 1, 1));//2

    }

    static int answer = 0;

    public int solution(String[][] board, int h, int w) {
        // visited 추가
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Point> queue = new LinkedList<>();

        // target setting
        String color = board[h][w];
        visited[h][w] = true;
        queue.add(new Point(h, w, color));

        // 똑같은 색 갯수 찾기, BFS(), Queue 사용
        BFS(board, queue, visited);
        return answer;
    }

    public void BFS(String[][] board, Queue<Point> queue, boolean[][] visited) {
        //queue
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            //순회, 4방향
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                String color = poll.color;

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || visited[nx][ny] || !board[nx][ny].equals(color)) {
                    continue;
                }

                //위, 아래, 왼쪽, 오른쪽
                visited[nx][ny] = true;
                answer++;
                queue.add(new Point(nx, ny, color));

            }// for end
        }// while end
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    class Point {
        int x;
        int y;
        String color;

        public Point(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
