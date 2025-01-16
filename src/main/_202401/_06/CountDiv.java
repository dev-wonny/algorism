package main._202401._06;

public class CountDiv {
    public static void main(String[] args) {
        System.out.println("expect: 3, result:" + solution(6, 11, 2));
    }


    public static int solution(int A, int B, int K) {

        int count = 0;

        // rangeArr 만들기
        for (int element = A; element <= B; element++) {

            if (element % K == 0) {
                count++;

            }
        }

        return count;
    }
}
