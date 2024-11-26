import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS (깊이 우선 탐색) 스택
 * 경로가 중요한 문제: 미로 탐색, 퍼즐 문제
 * 한 경로를 끝까지 탐색한 후, 다음 경로를 탐색합니다.
 * 트리나 그래프의 가장 깊은 노드까지 내려간 뒤, 돌아와서 다른 경로를 탐색합니다.
 * 재귀적 방식이나 스택을 사용하여 구현됩니다.
 * 탐색 순서: 후입선출 (LIFO, Last-In-First-Out)
 * 최단 경로 보장 여부: X
 * <p>
 * <p>
 * BFS (너비 우선 탐색) 큐
 * 최단 경로를 찾는 문제: 그래프의 최단 거리 탐색
 * 현재 노드와 연결된 모든 노드를 먼저 탐색한 후, 다음 단계로 넘어갑니다.
 * 동일 깊이의 노드를 모두 탐색한 후 다음 깊이로 이동합니다.
 * 큐를 사용하여 구현됩니다.
 * 탐색 순서: 선입선출 (FIFO, First-In-First-Out)
 * 최단 경로 보장 여부: O
 * <p>
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java">...</a>
 */

public class 게임최단거리 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2차원 배열 1~100, 1~100, [1][1]인 경우는 없다
        // 0: 벽, 1: 길
        // 캐릭터는 (1,1), 목표(n,m)


        이중배열을생성하는여러가지방법 way = new 이중배열을생성하는여러가지방법();

        arrayList를2차원배열처럼사용 way2 = new arrayList를2차원배열처럼사용();
        way2.make();


        // [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
        int[][] maps = way.make();
        int result = solution.solution(maps);// 11
        System.out.println("예상 결과(11), 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();
        // [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
        int[][] maps2 = way.failMake();
        int result2 = solution.solution(maps2);// -1
        System.out.println("예상 결과(-1), 실제 값:" + result2);


    }

    static class Solution {
        public int solution(int[][] maps) {
            // 최단 경로를 찾아야하기때문에 BFS

            // DFS, BFS는 처음 시작점을 호출해야함
            Point start = new Point(0, 0, 1);
            Point end = new Point(maps.length, maps[0].length);

            //출발에서 출구까지의 최단거리
            return bfs(maps, start, end);
        }


        public int bfs(int[][] maps, Point start, Point end) {
            //상하좌우 이동
            final int[][] directionTool = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            //공통 변수
            boolean[][] visited = new boolean[end.x][end.y];

            // queue를 사용하니까
            Queue<Point> queue = new LinkedList<>();

            // 시작점: queue에 넣고, 방문체크
            queue.add(start);
            visited[start.x][start.y] = true;

            // 진짜 로직 시작
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                // 종료: end에 도착하면 멈춘다
                if (current.x == end.x - 1 && current.y == end.y - 1) {
                    System.out.println(
                        "-----> 종료 Point(" + (current.x + 1) + ", " + (current.y + 1) + "), maps 값:" + maps[current.x][current.y] + ", 방문 여부:" + visited[current.x][current.y] + ", 누적 길이:" +
                            current.distance);

                    return current.distance;
                }

                // 다음에 이동할 곳이 있는지 탐색 후 queue에 넣음
                for (int[] direction : directionTool) {
                    int nx = current.x + direction[0];
                    int ny = current.y + direction[1];

                    if (
                        nx >= 0
                            && nx < end.x
                            && ny >= 0
                            && ny < end.y
                            // 길일때
                            && maps[nx][ny] == 1
                            // 방문한곳이 아닐때
                            && !visited[nx][ny]
                    ) {
                        // 반복: queue에 넣고, 방문체크, 다음 Point Distance 증가
                        System.out.println("추가 Point(" + (nx + 1) + ", " + (ny + 1) + "), maps 값:" + maps[nx][ny] + ", 방문 여부:" + visited[nx][ny] + ", Next Point 누적 길이:" + (current.distance + 1));
                        queue.add(new Point(nx, ny, current.distance + 1));
                        visited[nx][ny] = true;
                    }
                }

            }// while end

            // 도달 할 수 없는 경우
            return -1;
        }
    }// Solution class end


    static class Point {
        private int x, y;
        private int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static class 이중배열을생성하는여러가지방법 {
        public int[][] make() {
            int[][] array = new int[5][5];
            array[0] = new int[] {1, 0, 1, 1, 1};
            array[1] = new int[] {1, 0, 1, 0, 1};
            array[2] = new int[] {1, 0, 1, 1, 1};
            array[3] = new int[] {1, 1, 1, 0, 1};
            array[4] = new int[] {0, 0, 0, 0, 1};

            System.out.println(Arrays.deepToString(array));//[[I@28a418fc

            return array;
        }


        public int[][] failMake() {
            int[][] array =
                {
                    {1, 0, 1, 1, 1}
                    , {1, 0, 1, 0, 1}
                    , {1, 0, 1, 1, 1}
                    , {1, 1, 1, 0, 0}
                    , {0, 0, 0, 0, 1}
                };

            System.out.println(Arrays.deepToString(array));//[[I@5305068a
            return array;
        }

    }

    static class arrayList를2차원배열처럼사용 {

        public ArrayList<ArrayList<Integer>> make() {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            // 행 추가
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());

            // 값 추가
            list.get(0).add(1);
            list.get(0).add(2);
            list.get(0).add(3);

            list.get(1).add(1);
            list.get(1).add(2);
            list.get(1).add(3);

//            System.out.println(list);// [[1, 2, 3], [1, 2, 3]]

            return list;
        }

    }

}// one class end
