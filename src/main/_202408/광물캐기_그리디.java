package main._202408;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기_그리디 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1, 3, 2};
		String[] arr2 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		int result = solution.solution(arr, arr2);
		System.out.println(result);//12

	}

	static class Solution {
		public int solution(int[] picks, String[] minerals) {
			int len = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);

			List<Mineral> mineralsList = new ArrayList<>();
			for (int i = 0; i < len; i += 5) {
				int diamondCount = 0;
				int ironCount = 0;
				int stoneCount = 0;

				for (int j = 0; j < 5 && i + j < minerals.length; j++) {
					switch (minerals[i + j]) {
						case "diamond":
							diamondCount++;
							break;
						case "iron":
							ironCount++;
							break;
						case "stone":
							stoneCount++;
							break;
					}
				}

				mineralsList.add(new Mineral(diamondCount, ironCount, stoneCount));
			}

			int result = 0;
			for (Mineral mineral : mineralsList) {
				int pickToUse = -1;
				int minFatigue = Integer.MAX_VALUE;

				// 곡괭이를 선택, 각각의 곡괭이로 광물을 캔 피로도 구함 -> 그중에서 최소 피로도를 선택
				for (int i = 0; i < 3; i++) {
					if (picks[i] > 0) {
						int fatigue = mineral.getFatigue(i);
						// 최소의 값을 구하는 방법
						if (fatigue < minFatigue) {
							minFatigue = fatigue;
							pickToUse = i;
						}
					}
				}

				// 선택된 곡괭이를 사용하여 피로도 추가하고 곡괭이 수량 감소
				if (pickToUse != -1) {
					result += minFatigue;
					picks[pickToUse]--;
				}
			}

			return result;
		}

		class Mineral {
			private int diamondCount;
			private int ironCount;
			private int stoneCount;

			public Mineral(int diamondCount, int ironCount, int stoneCount) {
				this.diamondCount = diamondCount;
				this.ironCount = ironCount;
				this.stoneCount = stoneCount;
			}

			// 특정 곡괭이로 광물을 캘 때의 피로도 반환 메서드
			public int getFatigue(int pickType) {
				switch (pickType) {
					case 0: // 다이아몬드 곡괭이
						return diamondCount * 1 + ironCount * 1 + stoneCount * 1;
					case 1: // 철 곡괭이
						return diamondCount * 5 + ironCount * 1 + stoneCount * 1;
					case 2: // 돌 곡괭이
						return diamondCount * 25 + ironCount * 5 + stoneCount * 1;
					default:
						return 0;
				}
			}
		}
	}// Solution class end
}//class end
