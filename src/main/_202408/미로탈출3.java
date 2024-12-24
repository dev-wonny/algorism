package main._202408;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출3 {

	public static void main(String[] args) {
		미로탈출3.Solution solution = new 미로탈출3.Solution();
		String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
		int result = solution.solution(maps);
		System.out.println("result >>> " + result); // 16
	}

	static class Solution {
		private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

		public int solution(String[] maps) {
			int rows = maps.length;
			int cols = maps[0].length();

			Point start = null, lever = null, exit = null;

			// 출발점(S), 레버(L), 출구(E)의 위치를 찾기
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					// 이중 배열 만들지도 않네, 포인트만 찾는 군
					if (maps[i].charAt(j) == 'S') {
						start = new Point(i, j);
					}
					if (maps[i].charAt(j) == 'L') {
						lever = new Point(i, j);
					}
					if (maps[i].charAt(j) == 'E') {
						exit = new Point(i, j);
					}
				}
			}

			// 출발점에서 레버까지의 최단 거리
			int startToLever = bfs(maps, start, lever, rows, cols);
			// 레버에서 출구까지의 최단 거리
			int leverToExit = bfs(maps, lever, exit, rows, cols);

			// 만약 하나라도 도달할 수 없다면 -1 반환
			if (startToLever == -1 || leverToExit == -1) {
				return -1;
			}

			return startToLever + leverToExit;
		}

		private int bfs(String[] maps, Point start, Point end, int rows, int cols) {

			// 방문체크는 꼭 들어간다
			boolean[][] visited = new boolean[rows][cols];

			// BFS: Queue 사용
			Queue<Point> queue = new LinkedList<>();
			queue.add(start);
			visited[start.x][start.y] = true;

			int distance = 0;

			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					Point current = queue.poll();//큐에서 꺼낸다

					if (current.x == end.x && current.y == end.y) {
						return distance;
					}// end에 도착하면 distance 리턴

					// distance 늘리는 로직
					for (int[] direction : directions) {
						int nx = current.x + direction[0];
						int ny = current.y + direction[1];

						if (
								nx >= 0
								&& nx < rows

								&& ny >= 0
								&& ny < cols

								&& maps[nx].charAt(ny) != 'X'// 벽이 아닐 때
								&& !visited[nx][ny]//이미 방문 중이 아닐 때
						)
						{
							visited[nx][ny] = true;//방문중으로 체크
							queue.add(new Point(nx, ny));// 큐에 넣는다
						}
					}
				}

				distance++;
			}

			return -1; // 도달할 수 없는 경우
		}

		static class Point {
			int x, y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}// class end
}
