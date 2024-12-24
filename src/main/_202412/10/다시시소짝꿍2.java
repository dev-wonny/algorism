import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 순열, 수열
 * 백트래킹을 사용한다
 * <p>
 * <p>
 * 둘의 차이
 * 수열에서는 visited[i] = false; 사용
 * 순열(조합)에서는 visited[i] = false; 신경 안씀
 */
public class 다시시소짝꿍2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 풀이
        long result = solution.solution(new int[] {100, 180, 360, 100, 270});
        System.out.println("예상 결과: 4, 실제 값:" + result);

    }// main end

    static class Solution {
        public long solution(int[] weights) {
            Arrays.sort(weights);
            // 몸무게 빈도수
            Map<Integer, Integer> weightCount = new HashMap<>();
            long count = 0;

            // 각 몸무게의 빈도수를 계산
            for (int weight : weights) {
                weightCount.put(weight, weightCount.getOrDefault(weight, 0));
            }

            // 비율 배열
            int[][] ratios = {
                {1, 1}, // 동일 좌석
                {2, 3}, // 2m 좌석과 3m 좌석
                {2, 4}, // 2m 좌석과 4m 좌석
                {3, 4}  // 3m 좌석과 4m 좌석
            };

            for (int w : weightCount.keySet()) {
                long currentWeightCount = weightCount.get(w);

                // 1. 같은 몸무게끼리 (비율 1:1)
                if (currentWeightCount > 1) {
                    count += (currentWeightCount * (currentWeightCount - 1)) / 2;
                }

                // 2. 다른 비율
                for (int[] r : ratios){

                }
            }


            return 0;
        }


    }// class Solution end
}
