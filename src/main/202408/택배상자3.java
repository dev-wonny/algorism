import java.util.Stack;

public class 택배상자3 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {5, 4, 3, 2, 1});
		System.out.println(result);// 5

	}

	static class Solution {
		public int solution(int[] order) {
			int totalCount = 0;
			Stack<Integer> subConveyBelt = new Stack<>();
			int currentBoxNum = 1;

			for (int box : order) {
				// 메인 컨베이어 벨트에서 목표 상자를 찾을 때까지 상자를 서브 벨트로 보낸다.
				while (currentBoxNum <= order.length && currentBoxNum != box && (subConveyBelt.isEmpty() || subConveyBelt.peek() != box)) {
					subConveyBelt.push(currentBoxNum++);
				}

				// 메인 컨베이어 벨트에 목표 상자가 있는 경우
				if (currentBoxNum == box) {
					totalCount++;
					currentBoxNum++;
				}
				// 서브 컨베이어 벨트의 맨 위에 목표 상자가 있는 경우
				else if (!subConveyBelt.isEmpty() && subConveyBelt.peek() == box) {
					subConveyBelt.pop();
					totalCount++;
				}
				// 더 이상 작업을 진행할 수 없는 경우
				else {
					break;
				}
			}// for end

			return totalCount;
		}// func end

	}
}
