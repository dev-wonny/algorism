package main._202408;

import java.math.BigInteger;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int w = 8;
		int h = 12;
		long result = solution.solution(w, h);
		System.out.println(result);//80

	}

	static class Solution {
		public long solution(int w, int h) {
			// 지나가는 선 개수 w+h-최대공약수
			// 12~17 틀리는 이유 int*int 할 때 int 범위 벗어날 수 있어서 캐스팅
			return Math.max(((long) w * (long) h) - w - h + greatCommonFactor(w, h), 0);
		}

		private int greatCommonFactor(int w, int h) {
			while (h != 0) { // 최대공약수를 구할때까지
				int temp = h;//다음 계산을 위해 세팅, 나눠질 값
				int remainder = w % h;// 나머지

				// 다음 계산을 위한 세팅
				w = temp;//w사용이 끝나고 -> 다음 계산을 위해 세팅, 나눠질 값 세팅
				h = remainder;//다음 계산을 위해 세팅, 나머지를 나눌 값 세팅
			}

			return w;//나눠질 값 리턴.. 이때 h==0임
		}

		public long solution2(int w, int h) {
			long totalCount = (long) w * (long) h;
			long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

			return totalCount - diagonalCount;
		}

	}// Solution class end

}// one class end