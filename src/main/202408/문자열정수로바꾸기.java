public class 문자열정수로바꾸기 {

	//	https://school.programmers.co.kr/learn/courses/30/lessons/12925
	public static void main(String[] args) {
		문자열정수로바꾸기.Solution solution = new 문자열정수로바꾸기.Solution();
		int result = solution.solution("-1231234");
		System.out.println("result>>>" + result);

	}

	static class Solution {
		public int solution(String s) {
//			int answer = 0;
//			int leng = s.length();
//			if (leng > 1) {
//				char check = s.charAt(0);
//				if (check == '+' || check == '-') {
//					answer = Integer.parseInt(s.substring(1));
//					if (check == '-') {
//						answer *= -1;
//					}
//
//				} else {
//					answer = Integer.parseInt(s);
//				}
//
//			}
//			return answer;
			return  Integer.parseInt(s);
		}// func end
	}// class end
}
