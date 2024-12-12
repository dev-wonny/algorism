import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍4_해결2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 180, 360, 100, 270};
		long result = solution.solution(arr);
		System.out.println(result);//4

	}

	static class Solution {
		public long solution(int[] weights) {
			// 무게 빈도를 저장하는 해시맵
			Map<Integer, Long> weightCount = new HashMap<>();

			// 무게의 빈도를 기록
			for (int weight : weights) {
				weightCount.put(weight, weightCount.getOrDefault(weight, 0L) + 1);
			}

			long totalCount = 0;

			// 모든 무게에 대해 짝꿍을 찾아본다
			for (Map.Entry<Integer, Long> entry : weightCount.entrySet()) {
				int weight1 = entry.getKey();
				long count1 = entry.getValue();

				// 동일한 무게의  수를 계산 (kC2)
				totalCount += (count1 * (count1 - 1)) / 2;

				// 다른 무게와의 조합을 검사
				for (int weight2 : weightCount.keySet()) {
//					if (weight1 >= weight2) {
//						continue; // 중복 방지
//					}

					long count2 = weightCount.get(weight2);

					// (2, 3), (2, 4), (3, 4) 거리 조합을 확인
					if (
							weight1 * 1 / 2 == weight2
									|| weight1 * 2 / 3 == weight2
									|| weight1 * 3 / 4 == weight2
//									|| weight1 * 2 == weight2
//									|| weight1 * 3 / 2 == weight2
//									|| weight1 * 4 / 3 == weight2
					) {
						totalCount += count1 * count2;
					}
				}
			}

			return totalCount;
		}// solution func  end


	}// Solution class end

}// one class end
