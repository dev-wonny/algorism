package main._202408;

import java.util.ArrayList;

public class 약수의합 {
	public static void main(String[] args) {
		약수의합.Solution solution = new 약수의합.Solution();
		int result = solution.solution(1);
		System.out.println(result);

	}
	static class Solution {
		public int solution(int n) {
			if (n == 0) return 0;
			ArrayList<Integer> yacksuList = new ArrayList<>();
			yacksuList.add(1);
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					yacksuList.add(i);
				}
			}
			System.out.println(yacksuList);
			return yacksuList.stream().mapToInt(Integer::intValue).sum();
		}
	}
}
