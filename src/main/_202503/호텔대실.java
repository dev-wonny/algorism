package main._202503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 호텔대실 {
    public static void main(String[] args) {
        String[][] test1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] test2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        String[][] test3 = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};

        호텔대실 호텔대실 = new 호텔대실();
        System.out.println(호텔대실.solution(test1));//3
        System.out.println(호텔대실.solution(test2));//1
        System.out.println(호텔대실.solution(test3));//3
    }

    public int solution(String[][] book_time) {
        // 1. 시작 시간을 기준으로 정렬
        Arrays.sort(book_time, (a, b) -> toMinutes(a[0]) - toMinutes(b[0]));

        // 2. 종료 시간을 저장하는 최소 힙 (방마다 언제 비는지)
        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]) + 10; // 청소 시간 포함

            if (!roomQueue.isEmpty() && roomQueue.peek() <= start) {
                roomQueue.poll(); // 방 재사용
            }

            roomQueue.offer(end); // 새로운 예약
        }

        return roomQueue.size();
    }

    private int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private class Schedule implements Comparable<Schedule> {
        Integer start;
        Integer end;

        public Schedule(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            return this.start.compareTo(o.start); // 시작 시간이 빠른 순으로 정렬
        }
    }

    private int solution2(String[][] book_time) {
        // 자료구조 이른시간이 최상단에
        Queue<Schedule> timeQueue = new PriorityQueue<>();
        for (String[] time : book_time) {
            String[] splitStart = time[0].split(":");
            String s1 = splitStart[0] + splitStart[1];


            String[] splitEnd = time[1].split(":");
            String s2 = splitEnd[0] + splitEnd[1];

            timeQueue.offer(new Schedule(Integer.parseInt(s1), Integer.parseInt(s2)));
        }

        int count = 0;

        // count 증가
        while (!timeQueue.isEmpty()) {
            Schedule current = timeQueue.poll();
            DFS(current, timeQueue);
            count++;
        }

        return count;
    }

    //2) 끝나는 시간+10분 보다 이후에 있고 && book_time 에서 가장 이른 시간을 구한다
    // 존재한다: 1),2) 반복
    // 존재하지않는다: count증가, 1),2) 반복
    // 더이상 진행 못한다 return count
    private void DFS(Schedule current, Queue<Schedule> timeQueue) {
        int nextStart = current.end + 10;
        List<Schedule> tempList = new ArrayList<>();

        while (!timeQueue.isEmpty()) {
            Schedule next = timeQueue.poll();

            if (next.start >= nextStart) {
                DFS(next, timeQueue); // 다음 예약과 연결되는 DFS
                break;
            } else {
                tempList.add(next); // 아직 연결 불가능한 예약들
            }
        }

        // 다시 큐에 넣기 (순서 유지를 위해 addAll)
        timeQueue.addAll(tempList);

    }//DFS end
}
