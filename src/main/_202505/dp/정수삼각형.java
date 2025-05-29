package main._202505.dp;

public class 정수삼각형 {
    public static void main(String[] args) {
        정수삼각형 o = new 정수삼각형();
        System.out.println(o.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));//30
    }

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        // 거꾸로 시작
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (dp[i + 1][j] <= 0) {
                    int temp1 = triangle[i + 1][j];
                    int temp2 = triangle[i + 1][j + 1];
                    dp[i][j] = Math.max(temp1, temp2) + triangle[i][j];
                } else {
                    int temp1 = dp[i + 1][j];
                    int temp2 = dp[i + 1][j + 1];
                    dp[i][j] = Math.max(temp1, temp2) + triangle[i][j];
                }
            }
        }//for end

        return dp[0][0];

    }// end
}
