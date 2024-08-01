public class N개의최소공배수2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int result = solution.solution(arr);
		System.out.println(result);

	}

	static class Solution {
		public int solution(int[] arr) {
			int leng = arr.length;
			if (leng == 1) {
				return arr[0]; // 배열이 하나의 요소만 가질 경우 그 요소 반환
			}
			int lcm = arr[0]; //처음 값을 가져옴

			for (int i = 1; i < leng; i++) { // 배열 인덱스1부터 가져옴, 따라서 길이가 leng
				lcm = lcm(lcm, arr[i]);
			}// for end

			return lcm;

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

		// 최소 공배수 계산
		private int lcm(int a, int b) {
			return (a * b) / gcd(a, b);
		}

	}// Solution class end

}// one class end
