package main._202408;

public class 혼자서하는틱택토_2 {

//	https://school.programmers.co.kr/learn/courses/30/lessons/160585

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] arr = {".O.", ".X.", ".O."};
		int result = solution.solution(arr);
		System.out.println(result);

	}

	static class Solution {
		public int solution(String[] board) {
			String[][] newBoard = new String[3][3];
			int XCount = 0;
			int OCount = 0;
			int dotCount = 0;

			// 보드를 2차원 배열로 변환하고 각 기호의 개수를 카운트
			for (int i = 0; i < board.length; i++) {
				String[] temp = board[i].split("");
				for (String t : temp) {
					if (t.equals("O")) {
						OCount++;
					} else if (t.equals("X")) {
						XCount++;
					} else {
						dotCount++;
					}
				}
				newBoard[i] = temp;
			}

			// 초기화
			if (dotCount >= 9) {
				return 1;// true
			}

			// O가 선공
			if (dotCount == 8 && XCount == 1) {
				return 0;// false
			}

			// 체크0) O 존재 하는가?
			if (OCount < 1) {
				return 0;// false
			}

			// X는 O보다 많을 수 없다.
			if (XCount > OCount) {
				return 0;
			}

			// O가 이긴 경우와 X가 이긴 경우를 각각 확인
			boolean OWin = checkWin(newBoard, "O");
			boolean XWin = checkWin(newBoard, "X");

			// O와 X가 모두 이겼다면 잘못된 상태
			if (OWin && XWin) {
				return 0;
			}

			// O가 이겼다면 O가 X보다 1개 더 많아야 함
			if (OWin && OCount != XCount + 1) {
				return 0;
			}

			// X가 이겼다면 O와 X의 개수가 같아야 함
			if (XWin && OCount != XCount) {
				return 0;
			}

			// 그 외의 경우는 정상적인 상태
			return 1;
		}

		// 가로, 세로, 대각선에서 승리 조건을 체크
		private boolean checkWin(String[][] board, String player) {
			for (int i = 0; i < 3; i++) {
				// 가로와 세로를 체크
				if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) ||
						(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
					return true;
				}
			}
			// 대각선을 체크
			if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
					(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
				return true;
			}
			return false;
		}
	}// Solution class end

}// one class end
