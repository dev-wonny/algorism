import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 * 2배로 늘린다
 * bfs while 사용
 * queue, 최단거리
 */
public class 아이템줍기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int rectangle1 = solution.solution(
            new int[][]
                {
                    {1, 1, 7, 4}
                    , {3, 2, 5, 5}
                    , {4, 3, 6, 9}
                    , {2, 6, 8, 8}
                }
            , 1
            , 3
            , 7
            , 8
        );
        System.out.println("예상:17, 결과: " + rectangle1);

        int[][] rectangle2 = {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
        System.out.println("예상:11, 결과:" + solution.solution(rectangle2, 9, 7, 6, 1)); // 11

        int[][] rectangle3 = {{1, 1, 5, 7}};
        System.out.println("예상:9, 결과:" + solution.solution(rectangle3, 1, 1, 4, 7)); // 9

    }

    static class Solution {
        public int solution(
            int[][] rectangle
            , int characterX
            , int characterY
            , int itemX
            , int itemY
        ) {
            //모든 좌표를 2배로 확장해서 맵을 다시 그린다(정확한 테두리 판별을 위해)
            //직사각형을 나타내는 모든 좌표값은 1 이상 50 이하인 자연수입니다.-> 51 *2 = 102
            int[][] newMap = new int[102][102];
            characterX *= 2;
            characterY *= 2;
            itemX *= 2;
            itemY *= 2;

            for (int[] rect : rectangle) {
                //사각형 점들도 *2
                int xa = rect[0] * 2;
                int ya = rect[1] * 2;
                int xb = rect[2] * 2;
                int yb = rect[3] * 2;

                for (int i = xa; i <= xb; i++) {
                    for (int j = ya; j <= yb; j++) {
                        //4개의 점을 2로 표시, 나머지 포함영역은 1로 표시, 그외 영역 0
                        if (i == xa || i == xb || j == ya || i == yb) {
                            // 겹치는 부분처리
                            // 이미 2라면 그대로 두고
                            // 이미 1이라면 2가아닌 1로한다, 겹치기 때문이다
                            if (newMap[i][j] != 1) {
                                newMap[i][j] = 2;
                            }
                        } else {
                            newMap[i][j] = 1;
                        }
                    }
                }
            }

//            System.out.println("newMap 값 채움: ");
//            TablePrinterWithIndex.printAsTableWithIndex(newMap);

            // 그리고 안에 남은 2들이 있어서 내부를 지워준다
            // 맨 앞에서 한칸 앞부터 시작 ~ 맨마지막에서 하나 뺴고 까지
            for (int[] rect : rectangle) {
                int x1 = rect[0] * 2, y1 = rect[1] * 2;
                int x2 = rect[2] * 2, y2 = rect[3] * 2;
                for (int i = x1 + 1; i < x2; i++) {
                    for (int j = y1 + 1; j < y2; j++) {
                        newMap[i][j] = 0; // 내부 제거
                    }
                }
            }
//            System.out.println("newMap 값 내부 정리: ");
//            TablePrinterWithIndex.printAsTableWithIndex(newMap);

            // 사각형은 만들었음
            // 결과에서 2 나눠야함
            return bfs(newMap, characterX, characterY, itemX, itemY) / 2;
        }


        // bfs는 재귀호출 안함, while 사용함
        // queue 비울때까지 끝까지 팝니다
        public int bfs(int[][] newMap, int startX, int startY, int targetX, int targetY) {
            final int[][] directionTool = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};//상하좌우
            boolean[][] visitedArr = new boolean[102][102];// 고정 배열
            Queue<Point> queue = new LinkedList<>();//동적으로 늘어남

            //시작점 큐 추가, 방문기록
            queue.add(new Point(startX, startY, 0));
            visitedArr[startX][startY] = true;

            // queue 비울때까지 끝까지 팝니다
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                // 종료 포인트
                if (current.x == targetX && current.y == targetY) {
                    return current.distance;
                }


                // 현재 내위치에서 상하좌우를 돌아보고 길이 있으면 더 팝니다
                for (int[] direction : directionTool) {
                    int nx = current.x + direction[0];
                    int ny = current.y + direction[1];

                    if (
                        nx >= 0
                            && nx < 102
                            && ny >= 0
                            && ny < 102
                            // 길일떄
                            && newMap[nx][ny] != 0
                            // 방문하지 않은경우 더 진행
                            && !visitedArr[nx][ny]
                    ) {
                        // 반복: queue에 넣고, 방문체크, 다음 Point Distance 증가
                        queue.add(new Point(nx, ny, current.distance + 1));
                        visitedArr[nx][ny] = true;
                    }//if end
                }//for end
            }// while end
            return -1;
        }//bfs end

        static class Point {
            private int x;
            private int y;
            private int distance;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Point(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }//Point Class end
    }// Soulution class end
}
