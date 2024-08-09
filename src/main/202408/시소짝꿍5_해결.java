import java.util.Arrays;
import java.util.HashMap;

public class 시소짝꿍5_해결 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 50, 100, 150};
		long result = solution.solution(arr);
		System.out.println(result);//6

	}

	static class Solution {
		public long solution(int[] weights) {
			long answer = 0;
			Arrays.sort(weights);
			HashMap<Double, Integer> map = new HashMap<>();
			for (int w : weights) {
				double a = (double) w;

				double b = (double) w / 2.0;
				double c = ((double) w * 2.0) / 3.0;
				double d = ((double) w * 3.0) / 4.0;
				if (map.containsKey(a)) {
					answer += 1;
				}
				if (map.containsKey(b)) {
					answer += 1;
				}
				if (map.containsKey(c)) {
					answer += 1;
				}
				if (map.containsKey(d)) {
					answer += 1;
				}
				map.put(a, map.getOrDefault(a, 0) + 1);
			}
			return answer;
		}

	}// Solution class end

}// one class end
