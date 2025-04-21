package main._202504.matrix;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/?envType=study-plan-v2&envId=top-interview-150
public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku o = new ValidSudoku();
        System.out.println(o.isValidSudoku(new char[][]
            {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            }
        ));
    }

    private boolean isValidSudoku(char[][] board) {
        boolean smallSquareCheck = divideSqaure(board);
        boolean rowCheck = rowCheck(board);
        boolean columnCheck = columnCheck(board);

        return rowCheck && columnCheck && smallSquareCheck;
    }

    private boolean validCheck(char[] target) {
        Set<Character> set = new HashSet<>();
        for (char t : target) {
            if (t != '.' && set.contains(t)) {
                return false;
            }
            set.add(t);
        }
        return true;

    }


    private boolean rowCheck(char[][] board) {
        for (char[] row : board) {
            if (!validCheck(row)) {
                return false;
            }
        }
        return true;
    }

    private boolean columnCheck(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                char c = board[j][i];
                if (c != '.' && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }

        }
        return true;
    }


    private boolean smallSquareCheck(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < i + 3; j++) {
                char c = board[i][j];
                if (c != '.' && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }

        }
        //3, 3씩 자른다
        return true;
    }

    private boolean divideSqaure(char[][] board) {
        boolean result = true;
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                result = result && checkSmallSquare(board, i, j);

                if (!result) {
                    return result;
                }
            }
        }
        return result;
    }

    private boolean checkSmallSquare(char[][] board, int colunmStart, int rowStart) {
        Set<Character> set = new HashSet<>();
        for (int x = colunmStart; x < colunmStart + 3; x++) {
            for (int y = rowStart; y < rowStart + 3; y++) {
                char c = board[x][y];

                if ('.' != c && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }

        }
        return true;
    }
}
