package main.ArrayTest;

public class 과일장수 {
    public static void main(String[] args) {
        System.out.println(new 과일장수().solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));

        /**
         * 1,1
         * ,2,2,2,2
         * ,4,4,4,4,4,4
         *
         * 규칙1) 못하는 것을 몰자
         * [1, 1, 2] 1 x 3 = 3
         * [2, 2, 2] 2 x 3 = 6
         * [4, 4, 4] 4 x 3 = 12
         * [4, 4, 4] 4 x 3 = 12
         *
         */
        System.out.println(new 과일장수().solution(4, 3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    /*
    상자에 담긴 사과 중 가장 낮은 점수가 p
    사과 한 상자의 가격은 p * m
    (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
    최대 이익을 return
     */
    public int solution(int k, int m, int[] score) {

        int min = 0;
        int max = k;
        int boxCount = score.length / m;

        for (int i = 0; i < score.length; i++) {

        }
        return min * m * boxCount;
    }
}