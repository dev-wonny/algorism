package main._202505.binarysearch;

import java.util.Arrays;
import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/43236
public class 징검다리 {
    public static void main(String[] args) {
        징검다리 o = new 징검다리();
        System.out.println(o.solution(25, new int[] {2, 14, 11, 21, 17}, 2));//4

    }

    public int solution(int distance, int[] rocks, int n) {
        int l = 1;
        int r = distance;
        Arrays.sort(rocks);
        int answer = 0;

        while (l <= r) {
            // count의 개수가 n 개수보다 작은경우가 가능한 형태, count 개수가 훨씬 많으면 mid값을 낮춰서 계속해서 시도해야함
            int prevVal = 0;
            int removed = 0;
            int mid = (l + r) / 2;

            // -1 을 하면 안됨 < 라서
            for (int i = 0; i < rocks.length; i++) {
                int gap = rocks[i] - prevVal;
                if (gap < mid) {
                    removed++;//제거
                } else {
                    prevVal = rocks[i];//연속
                }
            }

            // 마지막 바위~도착 거리 확인
            int gap = distance - prevVal;
            if (gap < mid) {
                removed++;
            }

            // 제거수 > 기준, 불가능, r을 축소 시킨다
            if (removed > n) {
                r = mid - 1;
            }
            // 제거수 < 기준, 불가능, l을 증가 시킨다
            else {
                l = mid + 1;
                answer = mid;
            }
        }//while end
        return answer;
    }


    public int solution2(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int[] distanceArr = new int[rocks.length + 1];

        int left = 0;
        for (int i = 0; i < rocks.length; i++) {
            distanceArr[i] = rocks[i] - left;
            left = rocks[i];
        }
        distanceArr[distanceArr.length - 1] = distance - left;

        //n개를 제거해서 최소값 구하기
        //2,9,3,3,4,4

        // 2 ->2,  3->2, 4->2 9->1,

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < distanceArr.length - 1; i++) {
            map.put(distanceArr[i], map.getOrDefault(distanceArr[i], 0) + 1);
        }

        System.out.println(map);
        Integer[] array = map.keySet().stream().sorted(Integer::compare).toArray(Integer[]::new);
        System.out.println(array);


        // 2,3,3 에서 2개를 제거
        // 0, 2, 5, 8
        // 0, 8 --> 모든수를 합한 8이 가장 작음

        if (array.length <= n) {
            //합을 리턴
            return distance;
        }

        return array[n];
    }
}
