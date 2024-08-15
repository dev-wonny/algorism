import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 광물캐기 {

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

			ArrayList<Part> mineralsList = new ArrayList<>();
			for (int i = 0; i < len; i += 5) {

				int diamondCount = 0;
				int partTotalPonit = 0;
				int count = 0;


				// minerals을 0~4, 5~9 이런식으로 5묶음으로 key: 총합, value: dimond 개수을 구하고 싶어
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
				mineralsList.add(new Part(partTotalPonit, diamondCount, count));

			}

			// partTotalPonit가 값이 큰 순서대로 정렬
			mineralsList.sort((p1, p2) -> Integer.compare(p2.getTotalPoint(), p1.getTotalPoint()));

			int result = 0;
			//다이아몬드 사용
			if (picks[0] > 0) {
				result += picks[0] * 5;// 무조건 5가 이닐수도 있다.. 중간에 짤릴 수도 있음
				for (int i = 0; i < picks[0] && 0 < mineralsList.size(); i++) {
					mineralsList.remove(0);
				}
			}

			if (picks[1] > 0) {
				// 철 사용
				for (int i = 0; i < picks[1] && 0 < mineralsList.size(); i++) {
					Part part = mineralsList.get(0);
					int Dcount = part.getDiamondCount();//중간에 짤릴 수도 있음
					result += (Dcount * 5) + (part.getCount() - Dcount);
					mineralsList.remove(0);
				}
			}

			// 돌 사용
			if (picks[2] > 0) {
				for (Part part : mineralsList) {
					result += part.getTotalPoint();
				}
			}

			return result;
		}

		class Part {
			private int totalPoint;
			private int diamondCount;
			private int count;

			public Part(int totalPoint, int diamondCount, int count) {
				this.totalPoint = totalPoint;
				this.diamondCount = diamondCount;
				this.count = count;
			}

			private int getDiamondCount() {
				return diamondCount;
			}

			private int getTotalPoint() {
				return totalPoint;
			}

			public int getCount() {
				return count;
			}
		}


	}// Solution class end


}//class end
