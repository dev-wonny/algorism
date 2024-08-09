import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍3_중복제거 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 180, 360, 100, 270};
		long result = solution.solution(arr);
		System.out.println(result);//4

	}

	static class Solution {
		public long solution(int[] weights) {
			Arrays.sort(weights);

			ArrayList<Integer> duplicatedKeyList = new ArrayList<>();
			Map<Integer, Integer> map = new HashMap<>();// 무게, 갯수

			for (int w : weights) {
				map.compute(w, (key, value) -> value == null ? 0 : value + 1);

			}
			System.out.println(map);

			// 같은 숫자 제거, 중복 제거
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() >= 1) {
					duplicatedKeyList.add(entry.getKey());
					entry.setValue(0);
				}
			}

			System.out.println(map);

			for (int w : map.keySet()) {

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
				sum += value;
			}

			return sum + duplicatedKeyList.size();
		}// func solution end


	}// Solution class end

}// one class end
