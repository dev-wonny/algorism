public class N개의최소공배수 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {12, 14};
		int result = solution.solution(arr);
		System.out.println(result);

	}

	static class Solution {
		public int solution(int[] arr) {
			int leng = arr.length;
			if (leng == 1) {
				return arr[0]; // 배열이 하나의 요소만 가질 경우 그 요소 반환, 1이 아니다
			}
			int result = 1;

			for (int i = 0; i < leng - 1; i++) {
				int n = arr[i];
				int m = arr[i + 1];

				// n과 m이 1일 경우 [1, 1]을 반환
				if (n == 1 && m == 1) {
					return 1;
				}

				//최대 공약수
				int gcd = gcd(n, m);

				// 최소 공배수 계산
				int lcm = (n * m) / gcd;// 12*14/2 = 84

				arr[i + 1] = lcm;
			}// for end

			return arr[leng - 1];

		}// solution func end

		// 최대 공약수 계산 (유클리드 호제법)
		private int gcd(int a, int b) {// a:12, b:14 -> a:14, b:12 -> a:12, b:2 -> a:2, b:0
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}// gcd func end

	}// Solution class end

}// one class end
