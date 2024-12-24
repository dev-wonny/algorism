package main._202408;

import java.util.ArrayList;
import java.util.Optional;

public class 최대공약수최소공배수 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(12, 14);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	static class Solution {
		public int[] solution(int n, int m) {
			//둘 다 1일때 최대공약수:1, 최소공배수:1
			if (n == 1 && m == 1) {
				return new int[] {1, 1};
			}

			// 하나라도 1일 때, 최대공약수:1, 최소공배수:1이 아닌 값
			int maxMultiply = n * m;
			if (n == 1 || m == 1) {
				return new int[] {1, maxMultiply};
			}

			// n의 약수, m의 약수를 각각 모아둔다
			ArrayList<Integer> maxYacksuNList = new ArrayList<>();
			ArrayList<Integer> maxYacksuMList = new ArrayList<>();

			// 둘중에 큰 값 구하기
			int maxNum = Math.max(n, m);

			// 숫자 2부터 가장큰 수 maxNum까지 한번 씩 나눠본다
			for (int i = 2; i <= maxNum; i++) {
				if (maxNum < i || maxMultiply < i) {
					break;
				}
				if (n % i == 0) {
					maxYacksuNList.add(i);
				}
				if (m % i == 0) {
					maxYacksuMList.add(i);
				}
			}

			// 최대 공약수를 찾는 로직 (마지막 공통 요소를 찾기)
			// n의 약수들, m의 약수들 중에서 공통적인 것 중 가장 마지막 숫자를 꺼낸다
			Optional<Integer> maxYacksuOpt = maxYacksuNList.stream()
					.filter(maxYacksuMList::contains)
					.reduce((first, second) -> second);  // 마지막 요소 가져오기

			int maxYacksu = maxYacksuOpt.orElse(1);  // 공통 요소가 없을 경우 1 반환

			int minGongBaesu = maxMultiply / maxYacksu;//최소공배수 구하는 공식

			return new int[] {maxYacksu, minGongBaesu};
		}

	}// Solution class end

}// one class end
