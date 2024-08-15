import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 광물캐기_정답 {

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

			List<Part> mineralsList = new ArrayList<>();
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

				mineralsList.add(new Part(diamondCount, ironCount, stoneCount));
			}

			// 피로도 합계가 높은 순서대로 정렬
			Collections.sort(mineralsList, (p1, p2) -> p2.calculateFatigue() - p1.calculateFatigue());

			int result = 0;
			int index = 0;

			// 다이아몬드 곡괭이 사용
			for (int i = 0; i < picks[0] && index < mineralsList.size(); i++, index++) {
				result += mineralsList.get(index).getFatigue(0);
			}

			// 철 곡괭이 사용
			for (int i = 0; i < picks[1] && index < mineralsList.size(); i++, index++) {
				result += mineralsList.get(index).getFatigue(1);
			}

			// 돌 곡괭이 사용
			for (int i = 0; i < picks[2] && index < mineralsList.size(); i++, index++) {
				result += mineralsList.get(index).getFatigue(2);
			}

			return result;
		}

		class Part {
			private int diamondCount;
			private int ironCount;
			private int stoneCount;

			public Part(int diamondCount, int ironCount, int stoneCount) {
				this.diamondCount = diamondCount;
				this.ironCount = ironCount;
				this.stoneCount = stoneCount;
			}

			// 피로도 계산 메서드
			public int calculateFatigue() {
				return diamondCount * 25 + ironCount * 5 + stoneCount * 1;
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
