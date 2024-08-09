public class 하샤드수 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/12947
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean result = solution.solution(18);
		System.out.println(result);// 5

	}

	static class Solution {
		public boolean solution(int x) {
			String[] splitArr = String.valueOf(x).split("");
			int sum = 0;
			for (String num : splitArr) {
				sum += Integer.parseInt(num);
			}
			return x % sum == 0 ? true : false;
		}

		public boolean solution2(int x) {
			int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
			return x % sum == 0;
		}

	}
}
