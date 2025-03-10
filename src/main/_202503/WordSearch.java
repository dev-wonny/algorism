package main._202503;

//https://leetcode.com/problems/word-search/description/
public class WordSearch {
    public static void main(String[] args) {
//        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//
//        System.out.println("Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = \"ABCCED\" Output: true");
//        System.out.println(new WordSearch().exist(board, "ABCCED"));
//
//        char[][] board2 = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println("Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = \"ABCB\" Output: false");
//        System.out.println(new WordSearch().exist(board2, "ABCB"));

//
//        char[][] board3 = new char[][] {{'a', 'a'}};
//        System.out.println("Input: board = {{'a', 'a'}}, word = \"aaa\" Output: false");
//        System.out.println(new WordSearch().exist(board3, "aaa"));


        // 실패한 경우 방문을 초기화
//        char[][] board4 = new char[][] {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        System.out.println("Input: board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}}, word = \"AAB\" Output: false");
//        System.out.println(new WordSearch().exist(board4, "AAB"));


        // 4번째 E에서 왼쪽, 아래 둘다 E가 존재함 -> 왼쪽은 실패, 오른쪽은 성공 -> 서로 다른 분기로 체크 해야함
//        char[][] board5 = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println("Input: board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, word = \"ABCESEEEFS\" Output: true");
//        System.out.println(new WordSearch().exist(board5, "ABCESEEEFS"));

        //Time Limit Exceeded
        char[][] board6 = new char[][] {
            {'A', 'A', 'A', 'A', 'A', 'A'}
            , {'A', 'A', 'A', 'B', 'A', 'A'}
            , {'A', 'A', 'A', 'A', 'A', 'A'}
            , {'A', 'A', 'A', 'A', 'A', 'A'}
            , {'A', 'A', 'A', 'A', 'A', 'A'}
            , {'A', 'A', 'A', 'A', 'A', 'A'}
        };
        System.out.println(new WordSearch().exist(board6, "AB"));
    }

    private boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                // 첫번째 글자와 일치하는 곳을 찾는다
                if (board[x][y] == word.charAt(0)) {
                    if (DFS(x, y, board, word.toCharArray(), 0, new boolean[board.length][board[0].length])) {
                        return true; // 단어를 찾으면 즉시 종료
                    }
                }
            }
        }// for end

        return false;
    }// end

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean DFS(int x, int y, char[][] board, char[] targetWords, int index, boolean[][] visited) {
        visited[x][y] = true;// 방문체크

        // break point
        if (index == targetWords.length - 1) {
            return true;
        }
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (
                newX >= 0
                    && newY >= 0
                    && newX < board.length
                    && newY < board[0].length
                    && !visited[newX][newY]
                    && board[newX][newY] == targetWords[index + 1]
            ) {
                // 계속해서 stack call
                if (DFS(newX, newY, board, targetWords, index + 1, visited)) {
                    return true; // 단어를 찾으면 즉시 종료
                }

            }// if end
        }//for end

        visited[x][y] = false; // 백트래킹 (원상 복구)
        return false;

    }//DFS end
}
