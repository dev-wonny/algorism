package main._202505.dp;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(new N으로표현().solution(5, 12));//4
    }

    Queue<Point> queue = new LinkedList<>();

    public int solution(int N, int number) {
        // 1~8까지 사용할 때 만들 수 있는 수들을 저장
        List<Set<Integer>> dp = new ArrayList<>();

        // dp[0]은 사용하지 않음 (index 맞추기용)
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        //본격 계산
        for (int i = 1; i <= 8; i++) {
            // 예: 5, 55, 555, ...
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            // 점화식: j + (i-j) 조합
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if (y != 0) dp.get(i).add(x / y);
                    }
                }
            }

            // number가 만들어졌다면 반환
            if (dp.get(i).contains(number)) return i;
        }

        return -1; // 8번까지 못 만들면
    }

    public int solution2(int N, int number) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 8; i++) {
            int current = Integer.parseInt(String.valueOf(N).repeat(i));
            map.put(current, i);
            //사칙연산
            calc(current, N, map, i + 1, number);

            // 값 찾기
            if (map.containsKey(number)) {
                return map.get(number);
            }

            int test = 0;
            while (!queue.isEmpty() && test < 5) {
                Point poll = queue.poll();
                calc(poll.x, N, map, poll.y + 1, number);
                test++;
            }

            // 값 찾기
            if (map.containsKey(number)) {
                return map.get(number);
            }
        }


        return -1;
    }


    private void calc(int current, int N, Map<Integer, Integer> map, int thisNumbering, int number) {
        int plus = current + N;
        int minus = current - N;
        int mul = current * N;
        int div = current / N;

        setSmaller(map, plus, thisNumbering);
        if (minus > 0) {
            setSmaller(map, minus, thisNumbering);
        }
        setSmaller(map, mul, thisNumbering);

        if (current % N == 0) {
            setSmaller(map, div, thisNumbering);
        }

        // 값 찾기
        if (map.containsKey(number)) {
            return;
        }

        queue.add(new Point(plus, thisNumbering));
        if (minus > 0) {
            queue.add(new Point(minus, thisNumbering));
        }
        queue.add(new Point(mul, thisNumbering));
        if (current % N == 0) {
            queue.add(new Point(div, thisNumbering));
        }
    }

    private void setSmaller(Map<Integer, Integer> map, int value, int numbering) {
        if (map.containsKey(value)) {
            map.put(value, Math.min(numbering, map.get(value)));
        } else {
            map.put(value, numbering);
        }
    }
}
