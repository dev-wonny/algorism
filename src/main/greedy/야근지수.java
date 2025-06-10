package main.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 야근지수 {
    //피로도 = 남은 일의 작업량^2 더한 값
    //N시간 동안 야근 피로도를 최소화
    //Demi가 1시간 동안 작업량 1만큼을 처리
    //퇴근까지 남은 N 시간
    //각 일에 대한 작업량 works
    public static void main(String[] args) {
        //4시간동안 일을 한 결과는 [2, 2, 2]입니다. 이 때 야근 지수는 2^2 + 2^2 + 2^2 = 12 입니다.
        System.out.println(new 야근지수().solution(4, new int[] {4, 3, 3}));//12
    }


    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.add(work);
        }

        for (int i = 0; i < n; i++) {
            int work = queue.poll();
            queue.add(work - 1);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int work = queue.poll();
            result += work * work;
        }

        return result;
    }

    public long solution2(int n, int[] works) {
        Map<String, Integer> resultMap = new HashMap();
        int sum = 0;
        for (int i = 0; i < works.length; i++) {
            sum += works[i];
        }

        if (sum <= n) {
            return 0;
        }

        // 경우의 수 만들기
        for (int i = n; i >= 0; i--) {
            int left = works[0] - i;
            if (left < 0) {
                continue;
            }
            ArrayList<Integer> path = new ArrayList<>();
            path.add(left);
            DFS(path, n - i, 1, resultMap, works);
        }

        int min = Integer.MAX_VALUE;

        // resultMap에서 값이 가장 작은것 return
        for (int value : resultMap.values()) {
            min = Math.min(min, value);
        }

        return min;
    }

    void DFS(List<Integer> path, int leftTarget, int depth, Map<String, Integer> resultMap, int[] works) {
        if (depth > works.length) {
            return;
        }

        if (depth == works.length && leftTarget < 0) {
            return;
        }

        //break point
        if (depth == works.length && leftTarget == 0) {
            Collections.sort(path);
            //List path 정렬한 값을 -> key
            String key = path.toString();
            // path 제곱의 합 -> value
            int value = path.stream().mapToInt(i -> i * i).sum();

            // 중복 제거
            resultMap.put(key, value);
            return;
        }// if end


        //반복 작업
        for (int i = leftTarget; i >= 0; i--) {
            if (depth == works.length) {
                continue;
            }
            int left = works[depth] - i;
            if (left < 0) {
                continue;
            }
            path.add(left);
            DFS(path, leftTarget - i, depth + 1, resultMap, works);
            path.remove(path.size() - 1); // 추가!!
        }//for end

    }//DFS end
}
