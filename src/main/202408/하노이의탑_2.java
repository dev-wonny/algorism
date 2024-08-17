import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑_2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 3;
		int[][] result = solution.solution(n);
		System.out.println(Arrays.toString(result));
		int[][] result2 = new int[][] {{1, 3}, {1, 2}, {3, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 3}};


	}

	static class Solution {
		int k = 0; // 이동 횟수를 저장할 변수

		public int[][] solution(int n) {
			// 결과를 저장할 리스트 초기화
			List<int[]> result = new ArrayList<>();

			// 하노이 탑 알고리즘 실행
			hanoi(n, 1, 3, 2, result);

			// 리스트를 이중 배열로 변환
			int[][] answer = new int[result.size()][2];
			for (int i = 0; i < result.size(); i++) {
				answer[i] = result.get(i);
			}

			// 이동 횟수 출력
			System.out.println("총 이동 횟수: " + k);

			return answer;
		}

		// 하노이 탑 재귀 함수
		private void hanoi(int n, int from, int to, int via, List<int[]> result) {
			if (n == 1) {
				result.add(new int[] {from, to});
				k++; // 이동 횟수 증가
			} else {
				hanoi(n - 1, from, via, to, result); // 위의 n-1개를 from에서 via로 이동
				result.add(new int[] {from, to});
				k++; // 이동 횟수 증가
				hanoi(n - 1, via, to, from, result); // 위의 n-1개를 via에서 to로 이동
			}
		}
	}


}// one class end
