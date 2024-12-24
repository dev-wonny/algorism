package main._202408;

public class 음양더하기 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/76501

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {4, 7, 12};
		boolean[] arr2 = {true, false, true};
		int result = solution.solution(arr, arr2);
		System.out.println(result);

	}

	static class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int result = 0;
			for (int i = 0; i < absolutes.length; i++) {

				result += signs[i] ? absolutes[i] : -absolutes[i];
			}

			return result;
		}
	}// Solution class end

}// one class end
