public class 자릿수더하기 {
//	https://school.programmers.co.kr/learn/courses/30/lessons/12931

	public static void main(String[] args) {
//		N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
		자릿수더하기.Solution solution = new 자릿수더하기.Solution();
		int result = solution.solution(123);
		System.out.println(result);

	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			String s = String.valueOf(n);
			String[] splitedArr = s.split("");

			for (String word : splitedArr) {
				answer += Integer.parseInt(word);
			}

			return answer;
		}
	}
}
