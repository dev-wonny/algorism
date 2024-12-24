package main._202408;

import java.util.ArrayList;
import java.util.Collections;

public class 큰수만들기 {

	//	https://school.programmers.co.kr/learn/courses/30/lessons/42883
	public static void main(String[] args) {
		큰수만들기.Solution solution = new 큰수만들기.Solution();
		String result = solution.solution("1231234", 3);
		System.out.println("result>>>" + result);

	}

	static class Solution {
		public String solution(String number, int k) {
			String[] splitedArr = number.split("");
			int arrLength = splitedArr.length;//2이상

			ArrayList<Integer> allNumberList = new ArrayList<Integer>();

			// 조사한 것 중에서 가장 큰 숫자를 리턴해라
			for (int i = 0; i < splitedArr.length - k; i++) {
				allNumberList.add(Integer.valueOf(DFS(i, k - 1, splitedArr)));
			}

			return String.valueOf(Collections.max(allNumberList));
		}

		private String DFS(int startIndex, int leftPickNum, String[] splitedArr) {

			if (startIndex >= splitedArr.length) {
				return "";
			}

			if (leftPickNum < 0) {
				return "";
			}

			ArrayList<Integer> allNumberList = new ArrayList<Integer>();

			for (int j = 1; j < splitedArr.length; j++) {
				String temp = splitedArr[startIndex] + DFS(startIndex + j, leftPickNum - 1, splitedArr);
				allNumberList.add(Integer.valueOf(temp));
				System.out.println("temp>> " + temp);
			}

			return String.valueOf(Collections.max(allNumberList));
		}// DFS end
	}//class end
}
