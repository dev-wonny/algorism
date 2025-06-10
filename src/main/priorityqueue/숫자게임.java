package main.priorityqueue;

import static java.util.Collections.reverseOrder;

import java.util.PriorityQueue;
import java.util.Queue;

public class 숫자게임 {
    public static void main(String[] args) {
        System.out.println(new 숫자게임().solution(new int[] {5, 1, 3, 7}, new int[] {2, 2, 6, 8}));//3
        System.out.println(new 숫자게임().solution(new int[] {2, 2, 2, 2}, new int[] {1, 1, 1, 1}));//0

        // 이런 경우는 숫자가 큰 순서대로 빼면 불리함, 처음에는 1로 져주고, 나머지 3개를 이기는 방법이 있음
        System.out.println(new 숫자게임().solution(new int[] {6, 4, 3, 2}, new int[] {5, 4, 3, 1}));//3
    }

    public int solution(int[] A, int[] B) {
        Queue<Integer> queueA = new PriorityQueue<>(reverseOrder());
        Queue<Integer> queueB = new PriorityQueue<>(reverseOrder());

        for (int i = 0; i < A.length; i++) {
            queueA.add(A[i]);
            queueB.add(B[i]);
        }

        int result = 0;

        while (!queueB.isEmpty()) {
            int b = queueB.poll();

            //b보다 작은 값을 꺼낸다
            while (!queueA.isEmpty()) {
                int a = queueA.poll();
                if (a < b) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}