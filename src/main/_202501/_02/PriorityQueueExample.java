package main._202501._02;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        System.out.println("expect: [0,0], result:" + solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        System.out.println("expect: [333, -45], result:" + solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));

    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String oper : operations) {
            if (oper.startsWith("I")) {
                String[] split = oper.split(" ");
                minHeap.add(Integer.parseInt(split[1]));
                maxHeap.add(Integer.parseInt(split[1]));
            } else if (oper.startsWith("D 1")) {
                if (!maxHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }

            } else if (oper.equals("D -1")) {
                if (!minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }

            }
        }


        // 결과 계산
        int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();
        int min = minHeap.isEmpty() ? 0 : minHeap.peek();
        return new int[] {max, min};
    }
}
