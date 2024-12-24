import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Scovile {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));// 2
    }


    public static int solution(int[] scoville, int K) {
        Queue<Integer> smallQueue = new PriorityQueue<>();// 자동으로 값이 정렬됨
        int biggerCounter = 0;
        int changeCount = 0;

        // K기준으로 작은 무리, 큰것의 개수 구하기
        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] < K) {
                smallQueue.add(scoville[i]);
            } else {
                biggerCounter++;
            }
        }

        // 작은거 0개인 경우
        if (smallQueue.size() == 0) {
            return 0;
        }

        // 반복된 패턴 적용
        while (!smallQueue.isEmpty()) {

            // 작은거 1개인 경우, break point
            if (smallQueue.size() == 1) {
                if (biggerCounter < 1) {
                    return -1;// 실패
                }
                changeCount++;
                return changeCount;
            }// end 1

            // 작은거 2개인 경우
            if (smallQueue.size() >= 2) {
                int a = smallQueue.poll();
                int b = smallQueue.poll();
                int newValue = a + (b * 2);

                if (newValue >= K) {
                    biggerCounter++;
                } else {
                    //작은거 1개 추가
                    smallQueue.add(newValue);
                }
                changeCount++;// 증가

            }// end 2


        }//while end
        return changeCount;
    }// solve end
}
