public class 상담원인원 {
    /**
     * k 상담유형
     * n 멘토 수
     * <p>
     * k에는 하나의 멘토가 들어가야함
     * <p>
     * reqs를 분석해서 멘토를 배치해야함
     * <p>
     * 참가자
     * 시작시각,상담 시간,상담 유형
     * <p>
     * 가장 적게걸리는 대기시간을 구하라
     * bfs
     * <p>
     * https://school.programmers.co.kr/learn/courses/30/lessons/214288
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 풀이
        int result = solution.solution(3, 5
            , new int[][]
                {
                    {10, 60, 1}
                    , {15, 100, 3}
                    , {20, 30, 1}
                    , {30, 50, 3}
                    , {50, 40, 1}
                    , {60, 30, 2}
                    , {65, 30, 1}
                    , {70, 100, 2}
                }
        );
        System.out.println("예상 결과: 25, 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();

        int result2 = solution.solution(3, 5
            , new int[][]
                {
                    {5, 55, 2}
                    , {10, 90, 2}
                    , {20, 40, 2}
                    , {50, 45, 2}
                    , {100, 50, 2}
                }
        );
        System.out.println("예상 결과:90, 실제 값:" + result2);

    }// main end

    static class Solution {
        public int solution(int k, int n, int[][] reqs) {
            int answer = 0;
            return answer;
        }// solution end

    }// class Solution end
}
