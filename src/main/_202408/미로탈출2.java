package main._202408;

public class 미로탈출2 {

	public static void main(String[] args) {
		미로탈출2.Solution solution = new 미로탈출2.Solution();
		String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
		int result = solution.solution(maps);
		System.out.println("result>>>" + result); // 16
	}

	static class Solution {

		// 공통 상수 처리
		final static Integer ZERO = 0;
		final static Integer NO_EXIT = -1;
		private int totalMovingCount = ZERO; // 값에 의한 전달로 인해 공통 변수로 변경

		// 추가) 중복 방문 체크 용
		private boolean[][] visited;//초기값은 false

		public int solution(String[] maps) {
			int leng = maps.length;

			String[][] arrTwo = new String[leng][];
			visited = new boolean[leng][leng];

			// 2차원 배열 만들기
			for (int i = 0; i < leng; i++) {
				arrTwo[i] = maps[i].split("");
			}

			// DFS 시작
			for (int i = 0; i < leng; i++) {
				for (int j = 0; j < arrTwo[i].length; j++) {
					// Start 지점 찾기
					int[] startPoint = findStartPoint(i, j, arrTwo);

					if (startPoint != null) {
						DFS(startPoint[0], startPoint[1], arrTwo, ZERO);// 값에의한 전달로 인해 totalMovingCount 변수 제거
					}
				}
			}

			return (totalMovingCount == ZERO) ? NO_EXIT : totalMovingCount;
		}

		private int[] findStartPoint(int x, int y, String[][] twoArrays) {
			if ("S".equals(twoArrays[x][y])) {
				return new int[] {x, y};
			} else {
				return null;
			}
		}

		private void DFS(int x, int y, String[][] twoArrays, int currentCount) {
			if (x < ZERO || y < ZERO || x >= twoArrays.length || y >= twoArrays[0].length) {
				return; // 수정) 경계 체크
			}

			if (twoArrays[x][y].equals("X") || visited[x][y]) {
				return; // 벽이거나 이미 방문한 경우
			}

			if (twoArrays[x][y].equals("E")) { // 출구를 찾은 경우
				totalMovingCount = Math.max(totalMovingCount, currentCount);
				return;// 게임 끝
			}

			visited[x][y] = true; // 현재 위치를 방문했다고 표시

			// 상하좌우로 DFS 탐색
			DFS(x - 1, y, twoArrays, currentCount + 1);
			DFS(x + 1, y, twoArrays, currentCount + 1);
			DFS(x, y - 1, twoArrays, currentCount + 1);
			DFS(x, y + 1, twoArrays, currentCount + 1);

			visited[x][y] = false; // 백트래킹을 위해 방문 표시를 해제
		}
	}// class end
}
