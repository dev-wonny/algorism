package main.simulation;

import java.util.LinkedList;
import java.util.List;

public class 크레인인형뽑기 {

    public static void main(String[] args) {
        System.out.println(new 크레인인형뽑기().solution(
            new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
            }
            , new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
    }
    /*
    2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하
    board의 각 칸에는 0 이상 100 이하인 정수
    0은 빈 칸
    moves 배열의 크기는 1 이상 1,000 이하
    moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하
    크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return
    */

    static int removedCount = 0;

    public int solution(int[][] board, int[] moves) {
        List<Integer> cart = new LinkedList<>();

        //moves 다 움직이기
        for (int i = 0; i < moves.length; i++) {
            moveCart(moves[i] - 1, board, cart);
        }
        return removedCount;
    }

    void moveCart(int fixedCol, int[][] board, List<Integer> cart) {
        // row만 아래로 이동, 0이 아닐 때 까지
        for (int row = 0; row < board.length; row++) {
            if (board[row][fixedCol] != 0) {
                removedInCart(board[row][fixedCol], cart);
                board[row][fixedCol] = 0;
                return;
            }
        }
    }

    void removedInCart(int value, List<Integer> cart) {
        if (cart.isEmpty()) {
            cart.add(value);
        } else {
            if (cart.get(cart.size() - 1) == value) {
                cart.remove(cart.size() - 1);
                removedCount += 2;
            } else {
                cart.add(value);
            }
        }
    }
}
