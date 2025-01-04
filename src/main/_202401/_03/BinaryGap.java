package main._202401._03;

public class BinaryGap {
    public static void main(String[] args) {

// 테스트 케이스
        System.out.println(solution(1041)); // 출력: 5
        System.out.println(solution(9));    // 출력: 2
        System.out.println(solution(529));  // 출력: 4
        System.out.println(solution(20));   // 출력: 1
        System.out.println(solution(15));   // 출력: 0
        System.out.println(solution(32));   // 출력: 0    }
    }

    public static int solution(int N) {
        System.out.println();
        String bitString = Integer.toBinaryString(N);
        System.out.println("N:" + N + ", bitStirng:" + bitString);

        int max = 0;
        int currentGap = 0;
        boolean isClosed = false;

        for (char c : bitString.toCharArray()) {
            if (c == '1') {
                if (isClosed) {
                    max = Math.max(max, currentGap);
                }
                // 초기화
                isClosed = true;
                currentGap = 0;
            } else if (c == '0') {
                // 0 일때 currentGap 증가
                if (isClosed) {
                    currentGap++;
                }
            }

        }// for end
        return max;
    }

}
