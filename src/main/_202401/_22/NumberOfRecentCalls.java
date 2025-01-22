package main._202401._22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-recent-calls/solutions/6314673/korean-version-solving-by-arraylist-queu-8qou/
public class NumberOfRecentCalls {

    public static void main(String[] args) {
        String[] commands = new String[] {"RecentCounter", "ping", "ping", "ping", "ping"};
        int[][] timeDoubleArr = new int[][] {{}, {1}, {100}, {3001}, {3002}};


        RecentCounter recentCounter = null;


        Integer[] result = new Integer[commands.length];

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "RecentCounter":
                    recentCounter = new RecentCounter();
                    result[i] = null;
                    break;

                case "ping":
                    result[i] = recentCounter.ping(timeDoubleArr[i][0]);
                    break;
            }
        }// for end

        System.out.println("expect: [null, 1, 2, 3, 3], result: " + Arrays.toString(result));

    }

    static class RecentCounter {// 특정 기간 내의 최근 요청 수를 세는 클래스

        Queue<Integer> queue;

        public RecentCounter() {// 최근 요청을 0으로 설정하여 카운터를 초기화
            queue = new LinkedList<>();
        }

        /**
         * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
         * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
         * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
         * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
         */
        public int ping(int t) {
            queue.add(t);
            //[t - 3000, t]
            while (queue.peek() < t - 3000) {
                queue.poll();// 제거한 값 or null
            }

            return queue.size();
        }
    }

    static class RecentCounter2 {// 특정 기간 내의 최근 요청 수를 세는 클래스

        private static ArrayList<Integer> recordArr;
        private static int start;
        private static int end;

        public RecentCounter2() {// 최근 요청을 0으로 설정하여 카운터를 초기화
            recordArr = new ArrayList<>();
            start = 0;
            end = 0;
        }

        /**
         * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
         * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
         * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
         * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
         */
        public static int ping(int t) {
            recordArr.add(t);
            start = t - 3000;
            end = t;
            int count = 0;
            for (Integer record : recordArr) {
                if (record >= start && record <= end) {
                    count++;
                }
            }
            // 범위를 이렇게 만들어서 사용해라 [t - 3000, t]
            //t밀리초 단위의 시간
            // 지난 밀리초 동안 발생한 요청 수
            // 3000(새 요청 포함)를 반환
            return count;

        }
    }


}
