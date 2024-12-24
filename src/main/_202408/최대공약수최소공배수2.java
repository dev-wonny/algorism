package main._202408;

public class 최대공약수최소공배수2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(12, 14);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	static class Solution {
		public int[] solution(int n, int m) {
			// n과 m이 1일 경우 [1, 1]을 반환
			if (n == 1 && m == 1) {
				return new int[] {1, 1};
			}

			// 최대 공약수 계산
			int gcd = gcd(n, m);
			// 최소 공배수 계산
			int lcm = (n * m) / gcd;

			return new int[] {gcd, lcm};

		}// solution func end

		// 최대 공약수 계산 (유클리드 호제법)
		private int gcd(int a, int b) {
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}// gcd func end

	}// Solution class end

}// one class end
