package main._202408;

public class 두정수사이의합 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/12912

	class Solution {
		public long solution(int a, int b) {
			if (a == b) {
				return a;
			}

			long start = a > b ? b : a;
			long end = a < b ? b : a;
			long sum = 0;

			for (long i = start; i <= end; i++) {
				sum += i;
			}

			return sum;
		}
	}// Solution class end

	class Solution2 {

		public long solution(int a, int b) {
			return sumAtoB(Math.min(a, b), Math.max(b, a));
		}

		// 등차수열 합 공식
		private long sumAtoB(long a, long b) {
			return (b - a + 1) * (a + b) / 2;
		}
	}// Solution2 class end
}
