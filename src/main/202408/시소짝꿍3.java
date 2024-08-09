import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍3 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 180, 360, 100, 270};
		long result = solution.solution(arr);
		System.out.println(result);//4

	}

	static class Solution {
		public long solution(int[] weights) {
			Arrays.sort(weights);

			Map<Integer, Integer> map = new HashMap<>();// 무게, 갯수

			for (int w : weights) {
				map.compute(w, (key, value) -> value == null ? 1 : value + 1);

			}

			System.out.println(map);

			for (int w : map.keySet()) {
				if (map.containsKey(w)) {
					map.computeIfPresent(w, (key, value) -> value + 1);

				}

				if (map.containsKey(w * 2)) {
					map.computeIfPresent(w * 2, (key, value) -> value + 1);
				}

				if (map.containsKey(w * 3 / 2)) {
					map.computeIfPresent(w * 3 / 2, (key, value) -> value + 1);

				}

				if (map.containsKey(w * 4 / 3)) {
					map.computeIfPresent(w * 4 / 3, (key, value) -> value + 1);
				}

			}

			long sum = 0;

			for (int value : map.values()) {
				// 값이 2보다 큰 경우
				if (value > 2) {
					// 값에서 2를 뺀 차이를 더함
					sum += (value - 2);
				}
			}

			return sum;
		}// func solution end


	}// Solution class end

}// one class end
