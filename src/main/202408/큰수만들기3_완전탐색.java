import java.util.ArrayList;
import java.util.List;

public class 큰수만들기3_완전탐색 {

	//	https://school.programmers.co.kr/learn/courses/30/lessons/42883
	public static void main(String[] args) {
		큰수만들기3_완전탐색.Solution solution = new 큰수만들기3_완전탐색.Solution();
		String result = solution.solution("4177252841", 4);
		System.out.println("result>>>" + result);

	}

	static class Solution {
		public String solution(String number, int k) {
			int targetLength = number.length() - k;
			List<String> allCombinations = new ArrayList<>();// 값을 담을 List
			generateCombinations(number, "", targetLength, 0, allCombinations);//재귀함수

			// 만들어진 값 중에서 가장 큰 값 찾기
			String maxNumber = "";
			for (String combination : allCombinations) {
				if (combination.compareTo(maxNumber) > 0) {
					maxNumber = combination;
				}
			}

			return maxNumber;
		}

		private void generateCombinations(String number, String current, int targetLength, int index, List<String> combinations) {
			// If the current combination has reached the target length, add it to the list
			if (current.length() == targetLength) {//더이상 빼면 안됨
				combinations.add(current);// 값 추가
				return;
			}

			// If the index exceeds the length of the number, return
			if (index >= number.length()) {
				return;
			}


			//배열의 index 는 하나씩 증가시킨다
			// Include the current character in the combination
			generateCombinations(number, current + number.charAt(index), targetLength, index + 1, combinations);

			// Exclude the current character and move to the next one
			generateCombinations(number, current, targetLength, index + 1, combinations);
		}
	}
}//class end