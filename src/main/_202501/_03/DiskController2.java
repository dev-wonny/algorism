package main._202501._03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController2 {
    public static void main(String[] args) {
        System.out.println("expect: 8, result:" + solution(
                new int[][]
                    {
                        {0, 3}
                        , {1, 9}
                        , {3, 5}
                    }
            )
        );

        // 작업이 요청 시간순으로 정렬되지 않은 경우:
        System.out.println("expect: 31, result:" + solution(
                new int[][]
                    {
                        {5, 10},  // 요청 시간: 5, 실행 시간: 10
                        {0, 3},   // 요청 시간: 0, 실행 시간: 3
                        {1, 9}    // 요청 시간: 1, 실행 시간: 9

                    }
            )
        );
        // 요청 시간이 서로 다른 작업이 교차될 경우
        System.out.println("expect: 27, result:" + solution(
                new int[][]
                    {
                        {0, 3},   // 요청 시간: 0, 실행 시간: 3
                        {1, 9},   // 요청 시간: 1, 실행 시간: 9
                        {2, 6}    // 요청 시간: 2, 실행 시간: 6

                    }
            )
        );
    }


    public static int solution(int[][] jobs) {
        // 1. 작업을 요청 시간 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> diskController = new PriorityQueue<>((a, b) -> {
            // 소요시간 고려
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            // 실행 시간이 같으면 요청 시간 고려
            return Integer.compare(a[0], b[0]);
        });

        int totalTime = 0;   // 총 대기 시간

        int currentTime = 0; // 현재 시간, 변한다
        int index = 0;       // jobs 배열의 인덱스
        int completedJobs = 0;// 처리 완료된 작업 개수

        while (completedJobs < jobs.length) {// break point

            // 큐 넣기
            while (
                index < jobs.length
                    && jobs[index][0] <= currentTime
            ) {
                diskController.add(jobs[index]);
                index++;
            }

            // 큐 처리
            if (diskController.isEmpty()) {
                // 처리 가능한 작업이 없으면 시간 이동
                currentTime = jobs[index][0];
            } else {
                // 큐에서 가장 짧은 작업을 처리
                int[] job = diskController.poll();
                currentTime += job[1]; // 작업 처리 시간 증가
                totalTime += currentTime - job[0]; // (현재 시간 - 요청 시간)
                completedJobs++;
            }
        }

        return totalTime / jobs.length;


    }
}
