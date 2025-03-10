package main._202502;

//https://school.programmers.co.kr/learn/courses/30/lessons/67259?language=java
public class 경주로건설 {
    public static void main(String[] args) {

    }

    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동


    public static int solution(int[][] board) {
        int answer = 0;
        // TOP-DOWN: F(x,y) = MIN( F(x-1, y), F(x, y-1) );
        // 중복 발생으로 memozation[][] 사용
        int[][] memozation = new int[board.length][board.length];


        return answer;
    }

    private static int TopDown(Point currentPoint, int N, int[][] memozation) {
        //break point
        if (currentPoint.x == 0 && currentPoint.y == 0) {
            return 0;
        }

//        if (currentPoint.x == N && currentPoint.y == N){
//            return memozation[N][N];
//        }

        // TOP-DOWN: F(x,y) = MIN( F(x-1, y), F(x, y-1) );
        int getMemoData = memozation[currentPoint.x][currentPoint.y];

        // 이미 값이 있으면 사용하셈
//        if (getMemoData > 0) {
//            return memozation[currentPoint.x][currentPoint.y];
//        }

        int changeX = TopDown(new Point(currentPoint.x - 1, currentPoint.y), N, memozation);
        int changeY = TopDown(new Point(currentPoint.x, currentPoint.y - 1), N, memozation);
        int minValue = Math.min(changeX, changeY);

        // memozation 배열 값 채우기
        memozation[currentPoint.x][currentPoint.y] = Math.min(getMemoData, minValue);


        return memozation[currentPoint.x][currentPoint.y];
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
