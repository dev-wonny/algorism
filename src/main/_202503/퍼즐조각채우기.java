package main._202503;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class 퍼즐조각채우기 {

    public static void main(String[] args) {

    }

    private class Point {
        int totalCount;
        int startX;
        int staryY;

        public Point(int totalCount, int startX, int staryY) {
            this.totalCount = totalCount;
            this.startX = startX;
            this.staryY = staryY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point point)) {
                return false;
            }
            return totalCount == point.totalCount && startX == point.startX && staryY == point.staryY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(totalCount, startX, staryY);
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        //game_board: 0인 애들을 찾아서-> (총개수, 시작점) gameLinkedList 추가한다
        LinkedList<Point> gameList = new LinkedList<>();
        findValue(0, game_board, gameList);


        LinkedList<Point> tableList = new LinkedList<>();
        //table: 1인 애들을 찾아서-> (총개수, 시작점) tableLinkedList 추가한다
        findValue(1, table, tableList);

        gameList.sort(Collections.reverseOrder()); // 내림차순 정렬
        tableList.sort(Collections.reverseOrder()); // 내림차순 정렬

        //for 돌려서 gameLinkedList 하나씩 꺼내보고, tableLinkedList 일치하는지 체킹한다.
        for (int i = 0; i < gameList.size(); i++) {
            Point point = gameList.get(i);
            int gameTotalCount = point.totalCount;
            for (int j = 0; j < tableList.size(); j++) {
                Point tablePoint = tableList.get(j);
                int tableTotalCount = tablePoint.totalCount;

                // 1) 총개수가 동일함
                if (gameTotalCount >= tableTotalCount) {
                    // 2)방향이 같음
                    // 3)빈칸이 없음


                    //다 일치하면 제거
                    gameList.remove(i);
                    tableList.remove(j);

                }
            }


        }

        // 일치여부 구분: 1) 총개수가 동일함, 2)방향이 같음, 3)빈칸이 없음
        // 4)새로운걸 조합해서 넣는 경우도 있음 : 총6칸이면: 4+2로 가득 채우는 경우
        // ->이런경우에는 game_board를 기준으로 해야한다.
        // tableArrayList에 일치하면
        // 해당 인덱스는 제외하고, 다음번에는 해당 인덱스를 제외한 나머지에서 찾는다.
        // 일치하면: total count에 개수를 올린다.


        int answer = -1;
        return answer;
    }

    private void findValue(int target, int[][] targetArr, LinkedList<Point> resultList) {
        for (int x = 0; x < targetArr.length; x++) {
            for (int y = 0; y < targetArr[0].length; y++) {
                if (targetArr[x][y] == target) {
                    resultList.add(new Point(DFS(0, x, y, targetArr, target), x, y));
                }
            }
        }
    }

    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동


    private int DFS(int count, int x, int y, int[][] targetArr, int target) {
        // 방문처리
        targetArr[x][y] = 3;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0
                && newY >= 0
                && newX < targetArr.length
                && newY < targetArr[0].length
                && targetArr[newX][newY] == target) {
                count = DFS(count + 1, newX, newY, targetArr, target);
            }
        }//direction for end
        return count;
    }

    private void BFS() {

    }


}
