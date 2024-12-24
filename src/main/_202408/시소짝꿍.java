package main._202408;

public class 시소짝꿍 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100, 180, 360, 100, 270};
		long result = solution.solution(arr);
		System.out.println(result);//4

	}

	static class Solution {
		int totalCount = 0;

		public long solution(int[] weights) {
			for (int i = 0; i < weights.length - 1; i++) {
				for (int j = 1; j < weights.length - 1; j++) {
					DFS(i, j, weights);
				}
			}

			return totalCount;
		}// solution func end

		private void DFS(int start, int end, int[] weights) {
			// 처음 골랐을때 같은 경우
			if (weights[start] == weights[end]) {
				totalCount++;
				return;
			}

			// 서로 다른 경우 거리를 곱해서 같은 값을 찾는다
			// 찾은 경우
			if (DFS2(weights[start], weights[end])) {
				totalCount++;
				return;
			}

		}// DFS func end

		private boolean DFS2(int start, int end) {
			int[] distanceArr = {2, 3, 4};

			for (int i = 0; i < distanceArr.length - 1; i++) {
				if (start * distanceArr[i] == end * distanceArr[i + 1]) {
					return true;
				}
			}
			return false;
		}// DFS2 func end


	}// Solution class end

}// one class end
