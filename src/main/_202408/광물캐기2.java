package main._202408;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 광물캐기2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1, 3, 2};
		String[] arr2 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		int result = solution.solution(arr, arr2);
		System.out.println(result);//12

	}

	static class Solution {
		public int solution(int[] picks, String[] minerals) {

			Map<Integer, Integer> toolsMap = new HashMap<>();
			toolsMap.put(125, picks[0]);
			toolsMap.put(25, picks[1]);
			toolsMap.put(5, picks[2]);

			int picksSum = toolsMap.values().stream()
					.mapToInt(Integer::intValue)
					.sum();

			if (picksSum <= 0) {
				return 0;
			}

			int len = Math.min(minerals.length, picksSum * 5);

			ArrayList<FiveMineralGroup> fiveMineralGroupsList = new ArrayList<>();
			for (int i = 0; i < len; i += 5) {

				int diamondCount = 0;
				int partTotalPonit = 0;
				int count = 0;


				// minerals을 0~4, 5~9 이런식으로 5묶음으로 key: 총합, value: dimond
				for (int j = 0; j < 5 && i + j < minerals.length; j++) {
					// key: 총합, value: dimond 개수
					if (minerals[i + j].equals("diamond")) {
						diamondCount += 1;
						partTotalPonit += 25;
					} else {
						partTotalPonit += (minerals[i + j].equals("iron")) ? 5 : 1;
					}

					count += 1;
				}

				// partTotalPonit가 같은 경우도 있을 수도? map -> ArrayList 변경
				fiveMineralGroupsList.add(new FiveMineralGroup(partTotalPonit, diamondCount, count));

			}

			// partTotalPonit가 값이 큰 순서대로 정렬
			fiveMineralGroupsList.sort((p1, p2) -> Integer.compare(p2.getTotalPoint(), p1.getTotalPoint()));

			int result = 0;
			int index = 0;

			// 다이아몬드 도구 사용
			if (picks[0] > 0) {
				for (int i = 0; i < picks[0] && index < fiveMineralGroupsList.size() && index < len; i++, index++) {
					// [예외] 중간에 짤릴 수도 있음
					int count = fiveMineralGroupsList.get(index).getGroupIndex();

					result += count;
				}
			}


			// 철 도구 사용
			if (picks[1] > 0) {
				for (int i = 0; i < picks[1] && index < fiveMineralGroupsList.size() && index < len; i++, index++) {
					FiveMineralGroup fiveMineralGroup = fiveMineralGroupsList.get(index);
					int diamondCount = fiveMineralGroup.getDiamondCount();
					// [예외] 중간에 짤릴 수도 있음
					result += (diamondCount * 5) + (fiveMineralGroup.getGroupIndex() - diamondCount); // 철 도구로 채굴 시 점수 계산
				}

			}

			// 돌 도구 사용
			if (picks[2] > 0) {
				for (int i = 0; i < picks[2] && index < fiveMineralGroupsList.size() && index < len; i++, index++) {
					result += fiveMineralGroupsList.get(index).getTotalPoint(); // 돌 도구로 채굴 시 점수 그대로 추가
				}

			}

			return result;
		}

		class FiveMineralGroup {
			private int totalPoint;
			private int diamondCount;
			private int groupIndex;

			public FiveMineralGroup(int totalPoint, int diamondCount, int groupIndex) {
				this.totalPoint = totalPoint;
				this.diamondCount = diamondCount;
				this.groupIndex = groupIndex;
			}

			private int getDiamondCount() {
				return diamondCount;
			}

			private int getTotalPoint() {
				return totalPoint;
			}

			public int getGroupIndex() {
				return groupIndex;
			}
		}


	}// Solution class end


}//class end
