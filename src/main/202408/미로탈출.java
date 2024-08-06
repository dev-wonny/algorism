import java.util.Arrays;

public class 미로탈출 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/42860

	public static void main(String[] args) {
		미로탈출.Solution solution = new 미로탈출.Solution();
		String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
		int result = solution.solution(maps);
		System.out.println("result>>>" + result);//16

	}

	static class Solution {
		public int solution(String[] maps) {
			int leng = maps.length;

			String[][] arrTwo = new String[leng][leng];
			int totalMovingCount = -1;

			// 2차원 배열 만들기
			for (int i = 0; i < leng; i++) {
				arrTwo[i] = maps[i].split("");
			}

			// DFS 시작
			for (int i = 0; i < leng; i++) {
				for (int j = 0; j < leng; j++) {

					//Start 지점 찾기
					int[] StringPont = findStartPoint(i, j, arrTwo);

					if (StringPont != null) {
						//Start에서 DFS 시작, start지점 전달
						DFS(StringPont[0], StringPont[1], arrTwo, totalMovingCount);

					}
				}
			}

			return totalMovingCount;
		}

		private int[] findStartPoint(int x, int y, String[][] twoArrays) {
			if ("S".equals(twoArrays[x][y])) {
				return new int[] {x, y};

			} else {
				return null;
			}
		}


		private void DFS(int x, int y, String[][] twoArrays, int totalMovingCount) {
			if (twoArrays[x][y].equals("X")) {//벽 못지나감
				return;
			}

			if (twoArrays[x][y].equals("S")) {// 시작지점 아무것도 안함
//				return;
			}

			if (twoArrays[x][y].equals("O") || twoArrays[x][y].equals("L")) {//통과, 카운트 증가
				totalMovingCount++;
//				return;
			}

			if (twoArrays[x][y].equals("E")) {// 종료
				totalMovingCount++;
				return;
			}

			int leng = twoArrays.length;

			if (y >= 1 && x > 0 && y <= leng - 1 && x < leng) {
				DFS(x, y - 1, twoArrays, totalMovingCount);
			}

			if (y >= -1 && x >= 0 && y < leng - 1 && x < leng) {
				DFS(x, y + 1, twoArrays, totalMovingCount);
			}

			if (y > 0 && x >= 1 && y < leng && x <= leng) {
				DFS(x - 1, y, twoArrays, totalMovingCount);
			}

			if (y > 0 && x >= -1 && y < leng && x < leng - 1) {
				DFS(x + 1, y, twoArrays, totalMovingCount);
			}
		}

	}//class end
}
