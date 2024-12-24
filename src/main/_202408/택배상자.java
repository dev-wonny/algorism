package main._202408;

import java.util.Stack;

public class 택배상자 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {4, 3, 1, 2, 5});
		System.out.println(result);// 2

	}

	static class Solution {
		public int solution(int[] order) {
			int totalCount = 0;
			Stack<Integer> subConveyBelt = new Stack<>();
			int currentBoxNum = 1;


			for (int i = 0; i < order.length; i++) { // 여기가 틀렸음.. 더 돌아야함

				if (subConveyBelt.empty()) {
					if (currentBoxNum == order[i]) {
						totalCount++;
						currentBoxNum++;
					} else {
						subConveyBelt.push(currentBoxNum);
						currentBoxNum++;
					}
				} else {
					boolean check1 = false;
					boolean check2 = false;

					if (subConveyBelt.peek() == currentBoxNum) {
						subConveyBelt.pop();
						totalCount++;
						currentBoxNum++;
						check1 = true;
					}

					if (currentBoxNum == order[i]) {
						totalCount++;
						currentBoxNum++;
						check2 = true;
					}

					if (check1 == false && check2 == false) {
						subConveyBelt.push(currentBoxNum);
						currentBoxNum++;
					}

				}


			}

			return totalCount;
		}
	}
}
