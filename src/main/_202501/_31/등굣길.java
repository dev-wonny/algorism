package main._202501._31;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java
public class 등굣길 {
    public static void main(String[] args) {
        System.out.println("expect: 4, " + solution(4, 3, new int[][] {{2, 2}}));

    }

    public static int solution_실패(int m, int n, int[][] puddles) {
        int[][] dp_arr = new int[n][m];
        for (int[] puddle : puddles) {
            int mm = puddle[0] - 1;
            int nn = puddle[1] - 1;
            dp_arr[nn][mm] = -1;
        }

        // 값 세팅
        for (int i = 1; i < m; i++) {
            if (dp_arr[0][i] != -1) {
                dp_arr[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (dp_arr[i][0] != -1) {
                dp_arr[i][0] = 1;
            }
        }


        // 값 구하기
        return dp(n - 1, m - 1, dp_arr, n, m);
    }


    public static int dp(int x, int y, int[][] dp_arr, int n, int m) {
        if (dp_arr[x][y] == -1) {
            return 0;
        }

        // 재귀 호출 시 중복 계산을 피하기 위해 메모이제이션(Memoization)을 활용
        // 반복문(동적 프로그래밍, DP)을 사용하여 bottom-up 방식으로 문제를 해결
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x - 1 < 0 || y - 1 < 0) {
                    continue;
                }
                int num = dp(x - 1, y, dp_arr, n, m) + dp(x, y - 1, dp_arr, n, m);
                dp_arr[x][y] = num;
            }
        }

        return dp_arr[x][y];

    }

    // 배열 자체가 dp
    public static int solution(int m, int n, int[][] puddles) {
        // dp[i][j] : (i, j)까지 도달하는 경우의 수
        int[][] dp = new int[n][m];
        // 물웅덩이 위치를 표시할 배열 (true: 이동 불가)
        boolean[][] blocked = new boolean[n][m];

        // 물웅덩이 위치 설정 (입력은 1-indexed 이므로 -1 보정)
        for (int[] puddle : puddles) {
            int col = puddle[0] - 1;
            int row = puddle[1] - 1;
            blocked[row][col] = true;
        }

        // 시작 위치 (0,0)은 물웅덩이가 아니라고 가정 (문제 조건)
        dp[0][0] = 1;

        // 첫 행 초기화: 왼쪽에서 오른쪽으로 이동하면서 물웅덩이가 없으면 경로 수는 1
        for (int j = 1; j < m; j++) {
            if (!blocked[0][j]) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 첫 열 초기화: 위쪽에서 아래쪽으로 이동하면서 물웅덩이가 없으면 경로 수는 1
        for (int i = 1; i < n; i++) {
            if (!blocked[i][0]) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 나머지 칸에 대해 dp 점화식 적용: 위쪽과 왼쪽에서 오는 경우의 수의 합
        // 단, 물웅덩이는 0으로 처리
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (blocked[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    // 문제에 따라 경로 수가 매우 클 경우 모듈러 연산을 할 수 있음
                    dp[i][j] %= 1000000007;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static int solution2(int m, int n, int[][] puddles) {
        // blocked[i][j] : (i, j)가 물웅덩이인지 여부 (0-indexed)
        boolean[][] blocked = new boolean[n][m];
        for (int[] puddle : puddles) {
            // 입력이 1-indexed이므로 보정
            int col = puddle[0] - 1;
            int row = puddle[1] - 1;
            blocked[row][col] = true;
        }

        // 1차원 dp 배열 사용: dp[j]는 현재 행에서 (i, j)까지의 경우의 수
        int[] dp = new int[m];

        // 시작점 (0,0)
        dp[0] = blocked[0][0] ? 0 : 1;

        // 첫 행 초기화
        for (int j = 1; j < m; j++) {
            if (blocked[0][j]) {
                dp[j] = 0;
            } else {
                dp[j] = dp[j - 1];
            }
        }

        // 나머지 행 처리
        for (int i = 1; i < n; i++) {
            // 첫 열 업데이트: 만약 해당 cell이 blocked라면 0, 아니라면 그대로 유지 (위쪽 값)
            dp[0] = blocked[i][0] ? 0 : dp[0];
            for (int j = 1; j < m; j++) {
                if (blocked[i][j]) {
                    dp[j] = 0;
                } else {
                    // dp[j]는 위쪽 값, dp[j-1]은 왼쪽 값
                    dp[j] = (dp[j] + dp[j - 1]) % 1000000007;
                }
            }
        }

        return dp[m - 1];
    }

    public static int solution_효율성낮음(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        // dp[row][col] : (row, col)까지 가는 경우의 수, 0-indexed, 배열 크기는 n x m
        int[][] dp = new int[n][m];

        // 물웅덩이 위치를 1-indexed 기준의 "row,col" 문자열로 저장
        Set<String> puddleSet = new HashSet<>();
        for (int[] puddle : puddles) {
            // puddle[0] : x좌표(열), puddle[1] : y좌표(행) → (행, 열)로 변경
            int col = puddle[0];
            int row = puddle[1];
            puddleSet.add(row + "," + col);
        }

        // 첫 번째 열 초기화 (각 행의 첫 번째 열)
        for (int i = 0; i < n; i++) {
            // 현재 좌표 (i+1, 1) (1-indexed)
            if (puddleSet.contains((i + 1) + "," + 1)) {
                break;
            }
            dp[i][0] = 1;
        }

        // 첫 번째 행 초기화 (각 열의 첫 번째 행)
        for (int j = 0; j < m; j++) {
            // 현재 좌표 (1, j+1) (1-indexed)
            if (puddleSet.contains(1 + "," + (j + 1))) {
                break;
            }
            dp[0][j] = 1;
        }

        // 나머지 칸 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 현재 좌표 (i+1, j+1)가 물웅덩이가 아니면
                if (!puddleSet.contains((i + 1) + "," + (j + 1))) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
