import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 3;
		int[][] result = solution.solution(n);
		System.out.println(Arrays.toString(result));
		int[][] result2 = new int[][] {{1, 3}, {1, 2}, {3, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 3}};


	}

	static class Solution {
		public int[][] solution(int n) {
			List<int[]> result = new ArrayList<>();
			solveHanoi(n, 1, 3, 2, result);

			// List를 배열로 변환
			int[][] answer = new int[result.size()][2];
			for (int i = 0; i < result.size(); i++) {
				answer[i] = result.get(i);
			}

			return answer;
		}

		private void solveHanoi(int n, int start, int target, int auxiliary, List<int[]> result) {
			if (n == 0) {
				return;
			}

			// 1. n-1개의 원판을 보조 기둥으로 이동
			solveHanoi(n - 1, start, auxiliary, target, result);

			// 2. 가장 큰 원판을 목표 기둥으로 이동
			result.add(new int[] {start, target});

			// 3. 보조 기둥에 있는 n-1개의 원판을 목표 기둥으로 이동
			solveHanoi(n - 1, auxiliary, target, start, result);
		}
	}


}// one class end
