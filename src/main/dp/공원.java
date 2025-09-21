package main.dp;

public class 공원 {
    public static void main(String[] args) {
        System.out.println(new 공원().solution(new int[]{5, 3, 2}
                , new String[][]{
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"}
                        , {"A", "A", "-1", "B", "B", "B", "B", "-1"}
                        , {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
                }));

    }

    public int solution(int[] mats, String[][] park) {
        int maxSquareSize = getMaxSquareSize(park);
        if (maxSquareSize == 0) {
            return -1;
        }
        // mats를 순회하면서 maxSquareSize 같거나 작은 숫자중에 가장 큰수를 리턴
        int best = -1;
        for (int s : mats) {
            if (s <= maxSquareSize) best = Math.max(best, s);
        }
        return best;
    }

    public int getMaxSquareSize(String[][] park) {
        int n = park.length;
        int m = park[0].length;
        int[][] dp = new int[n][m];
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1) 계산 시작하기
                if (park[i][j].equals("-1")) {
                    // 1.1) 첫행, 첫열은 자가 자신만 가능
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    // 1.2) 그외 나머지는 위, 왼쪽, 왼쪽 대각선 중에서 가장 최소값의 +1 을 해준 값이 자신의 최대 정사각형
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // maxsize
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
                // 2) 비어있지 않으면 정사각형 대상이 아님
                else {
                    dp[i][j] = 0;
                }
            }//for end
        }//for end
        return maxSize;
    }
}
