package collection.sort;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 4, 2};
        int[] sortedNums = heapSort(nums);

        // 결과 출력
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }

    public static int[] heapSort(int[] nums) {
        // 최대 힙 구현
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 힙에 요소 추가
        for (int num : nums) {
            maxHeap.offer(num);
        }

        // 정렬된 배열에 요소 추가 (큰 값부터 작은 값 순서)
        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sorted[i] = maxHeap.poll(); // 최대값 제거
        }

        return sorted;
    }
}
