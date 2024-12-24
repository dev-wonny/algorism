package main._202408;

public class 혼자서하는틱택토_실패_규칙모름 {

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

			for (int i = 0; i < board.length; i++) {
				String[] temp = board[i].split("");
				for (String t : temp) {
					switch (t) {
						case "O":
							OCount++;
							break;
						case "X":
							XCount++;
							break;
						case ".":
							dotCount++;
					}

					newBoard[i] = temp;
				}
			}

			System.out.println(newBoard);

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

			//test 10
			// 체크1) O와 X의 숫자가 같은가? O는 X보다 1개 많아야한다
			if (OCount - XCount > 1) {// >= 아님 >
				return 0;// false
			}

			int result = 0;
			result += checkRow(newBoard);
			result += checkColumn(newBoard);
			result += checkDiagonal(newBoard);

			// 체크3) 게임이 끝났는데도 계속 진행하지 않는가?
			if (result > 2) {
				return 0;// false
			}

			return 1;
		}

		private int checkRow(String[][] newBoard) {
			int result = 0;
			for (int i = 0; i < 3; i++) {
				if (!newBoard[i][0].equals(".") && newBoard[i][0].equals(newBoard[i][1]) && newBoard[i][1].equals(newBoard[i][2])) {
					result++;
				}
			}

			return result;
		}

		private int checkColumn(String[][] newBoard) {
			int result = 0;
			for (int i = 0; i < 3; i++) {
				if (!newBoard[0][i].equals(".") && newBoard[0][i].equals(newBoard[1][i]) && newBoard[1][i].equals(newBoard[2][i])) {
					result++;
				}
			}

			return result;
		}

		private int checkDiagonal(String[][] newBoard) {
			int result = 0;
			if (!newBoard[0][0].equals(".") && newBoard[0][0].equals(newBoard[1][1]) && newBoard[1][1].equals(newBoard[2][2])) {
				result++;
			}

			if (!newBoard[0][2].equals(".") && newBoard[0][2].equals(newBoard[1][1]) && newBoard[1][1].equals(newBoard[2][0])) {
				result++;
			}

			return result;
		}
	}// Solution class end

}// one class end
