package main._202408;

public class 시소짝꿍2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 180, 360, 100, 270};
		long result = solution.solution(arr);
		System.out.println(result);//4

	}

	static class Solution {

		int totalCount = 0;

		public long solution(int[] weights) {
			// 모든 가능한 쌍을 DFS로 탐색
			for (int i = 0; i < weights.length - 1; i++) {
				for (int j = i + 1; j < weights.length; j++) {
					DFS(i, j, weights);
				}
			}
			return totalCount;
		}// solution func end

		private void DFS(int start, int end, int[] weights) {
			// 같은 몸무게인 경우
			if (weights[start] == weights[end]) {
				totalCount++;
				return;
			}

			// 서로 다른 경우 토크 계산
			if (DFS2(weights[start], weights[end])) {
				totalCount++;
			}
		}// DFS func end

		private boolean DFS2(int weight1, int weight2) {
			int[] distanceArr = {2, 3, 4};

			// 각 거리 비율을 비교
			for (int i = 0; i < distanceArr.length; i++) {
				for (int j = i + 1; j < distanceArr.length; j++) {
					if (weight1 * distanceArr[i] == weight2 * distanceArr[j] ||
							weight1 * distanceArr[j] == weight2 * distanceArr[i]) {
						return true;
					}
				}
			}
			return false;
		}// DFS2 func end


	}// Solution class end

}// one class end
