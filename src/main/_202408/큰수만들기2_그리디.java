package main._202408;

import java.util.Stack;

public class 큰수만들기2_그리디 {

	//	https://school.programmers.co.kr/learn/courses/30/lessons/42883
	public static void main(String[] args) {
		큰수만들기2_그리디.Solution solution = new 큰수만들기2_그리디.Solution();
		String result = solution.solution("4177252841", 4);
		System.out.println("result>>>" + result);

	}// main end

	static class Solution {
		public String solution(String number, int k) {
			// 완전 탐색 X, 그리디 O
			//k는 제거해도 되는 수

			// 배열 중에서 가장 큰 값을 선택해서 넣을 Stack
			// LIFO : Last In First Out
			Stack<Character> stack = new Stack<>();
			int len = number.length();

			//각자리에서 시작
			for (int i = 0; i < len; i++) {

				char current = number.charAt(i);//값 꺼내기
				while (!stack.isEmpty()//비어있지 았곤
						&& stack.peek() < current
						&& k > 0) {//뽑을게 있어야함
					stack.pop();// 꺼낸다
					k--;//제거
				}
				stack.push(current);
				// 각 자리, 처음 시작할 때 push
				// 큰 값보다 현재 값이 클 때 push
			}

			// k가 0이 되지 않았다면, 스택에서 k개를 더 pop해줍니다.
			while (k > 0) {
				stack.pop();
				k--;
			}

			// 스택의 모든 요소를 합쳐서 결과 문자열을 만듭니다.
			StringBuilder result = new StringBuilder();
			for (char c : stack) {
				result.append(c);
			}

			return result.toString();
		}// solution func end

	}//class end
}
