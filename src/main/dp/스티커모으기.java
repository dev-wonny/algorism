package main.dp;

//https://school.programmers.co.kr/learn/courses/30/lessons/12971
public class 스티커모으기 {
    public static void main(String[] args) {
        System.out.println(new 스티커모으기().solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10}));//36

    }

    public int solution(int sticker[]) {
        int eventSum = 0;
        int oddSum = 0;
        for (int i = 0; i < sticker.length; i++) {

            if (i % 2 == 0) {
                eventSum += sticker[i];

            } else {
                oddSum += sticker[i];
            }
        }// end for

        return Math.max(eventSum, oddSum);
    }
}
