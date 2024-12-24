package main._202412._24;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Scovile2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));// 2
    }


    public static int solution(int[] scoville, int K) {
        // 최소 힙 (우선순위 큐)
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();//알아서 정렬됨
        for (int num : scoville) {
            smallQueue.add(num);
        }

        int changeCount = 0;

        // 반복된 패턴 적용
        while (smallQueue.size() > 1) {
            // 작은거 1개가 K보다 큰 경우 더이상 진행 안함, break point
            int first = smallQueue.poll();
            if (first >= K) {
                return changeCount;
            }

            int second = smallQueue.poll();
            int newScoville = first + (second * 2);
            smallQueue.add(newScoville);
            changeCount++;
        }//while end

        return changeCount;
    }// solve end

}
