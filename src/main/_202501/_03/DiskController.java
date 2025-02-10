package main._202501._03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class DiskController {
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
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Process> diskController = new PriorityQueue<>();

        for (int i = 0; i < jobs.length; i++) {
            diskController.add(new Process(jobs[i][1], jobs[i][0], i));
        }

//        System.out.println(diskController);

        int accumulateDistance = 0;
        int result = 0;

        while (!diskController.isEmpty()) {
            Process process = diskController.poll();
            accumulateDistance += process.spendTime;
            result += (accumulateDistance - process.requireTime);
        }

        return result / jobs.length;
    }


    private static class Process implements Comparable<Process> {
        int spendTime;// 1위 고려 소요시간이 짧은 것
        int requireTime; // 2위 고려 작업의 요청 시각이 빠른 것
        int orderIndex; // 3위 고려 작업의 번호가 작은 것

        public Process(int spendTime, int requireTime, int orderIndex) {
            this.spendTime = spendTime;
            this.requireTime = requireTime;
            this.orderIndex = orderIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Process process)) {
                return false;
            }
            return spendTime == process.spendTime && requireTime == process.requireTime && orderIndex == process.orderIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(spendTime, requireTime, orderIndex);
        }

        @Override
        public int compareTo(Process o) {
            int result;
            // 소요시간 고려
            result = Integer.compare(this.spendTime, o.spendTime);

            // 요청 시간 먼저 고려
            if (result == 0) {
                result = Integer.compare(this.requireTime, o.requireTime);

            }

            // 인덱스 고려
            if (result == 0) {
                result = Integer.compare(this.orderIndex, o.orderIndex);
            }
            return result;
        }

        @Override
        public String toString() {
            return "Process{" +
                "spendTime=" + spendTime +
                ", requireTime=" + requireTime +
                ", orderIndex=" + orderIndex +
                '}';
        }
    }
}
