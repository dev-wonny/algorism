import java.util.Stack;

public class 택배상자2 {

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
			// while문 O, for문 X
			// currentBoxNum은 조건에 따라 증가한다


			// 택배 번호 상자는 자신과 같은 값이 나올때까지 기다린다
			for (int box : order) {
				// currentBoxNum 마지막 숫자 == 배열의 길이와 일치하면(틀림)
				// 연속에서 stack에서 꺼낼 수 없음

				// totalCount == 배열의 길이와 일치하면(맞음)
				// 계속해서 stack 뒤질 수 있음

				// 모든게 끝나는 조건: 주 컨베이터 벨트가 끝 && 서브 컨테이너 끝
				// 서브를 마지막까지 더 돌려아함
				while (totalCount <= order.length) {
					boolean check = false;
					boolean check2 = false;

					// 먼저 주 컨베이터 벨트 체크
					if (currentBoxNum == box) {
						totalCount++;
						currentBoxNum++;
						check = true;
						break;
					}

					// 서브 컨베이터 벨트 체크
					if (!subConveyBelt.empty() && subConveyBelt.peek() == box) {
						totalCount++;
						currentBoxNum++;
						subConveyBelt.pop();
						check2 = true;
						break;
					}

					// 둘 다 아니면 서브 컨베이터 벨트에 넣기
					if (!check && !check2) {
						subConveyBelt.push(currentBoxNum);
						currentBoxNum++;
					}

				}// while end
			}// for end

			return totalCount;

		}// func end
	}
}
