import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 로또최고순와최저순위 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/77484

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {2, 3, 4, 5, 7, 9};
		int[] arr2 = {31, 10, 45, 1, 6, 19};
		int[] result = solution.solution(arr, arr2);
		System.out.println(Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			// 정렬
			Arrays.sort(lottos);
			Arrays.sort(win_nums);

			// 1. 전체가 같은 경우
			if (Arrays.equals(lottos, win_nums)) {
				return new int[] {1, 1};
			}

			// 2. 전체 값이 0인 경우
			if (Arrays.stream(lottos).allMatch(n -> n == 0)) {
				return new int[] {1, 6};
			}

			List<Integer> lottosList = Arrays.stream(lottos)
					.boxed()
					.collect(Collectors.toList());

			// 0을 제거한 나머지 숫자 list
			lottosList.removeIf(n -> n == 0);

			List<Integer> winList = Arrays.stream(win_nums)
					.boxed()
					.collect(Collectors.toList());

			// 일치하는 숫자를 구한다 : 최소 매칭
			int matchMinCount = (int) lottosList.stream()
					.filter(winList::contains)
					.count();

			//0 개수
			int zeroCount = 6 - lottosList.size();
			int matchMaxCount = matchMinCount + zeroCount;

			int max = (Math.abs(matchMaxCount - 7) == 7) ? 6 : Math.abs(matchMaxCount - 7);
			int min = (Math.abs(matchMinCount - 7) == 7) ? 6 : Math.abs(matchMinCount - 7);


			//예외: 하나도 안 맞을 때 [0,0] -> [7,7] X

			// 등수 구하기 (일치 수-7)*-1
			//최대 맞춘 수, 최소 맞춘 수
			return new int[] {max, min};
		}
	}// Solution class end

}// one class end
