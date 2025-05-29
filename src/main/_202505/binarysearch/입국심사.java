package main._202505.binarysearch;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        입국심사 o = new 입국심사();
        System.out.println(o.solution(6, new int[] {7, 10}));//28
    }

    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) {
                answer = mid;       // 가능한 시간, 더 줄여본다
                right = mid - 1;
            } else {
                left = mid + 1;     // 시간 부족 → 늘려야 함
            }
        }

        return answer;
    }

    public long solution3(int n, int[] times) {
        return recursieve(1, Arrays.stream(times).max().getAsInt() * n, n, times);
    }

    public int recursieve(int min, int max, int n, int[] times) {
        int mid = (min + max) / 2;

        int count = 0;
        for (int i = 0; i <= times.length - 1; i++) {
            count += mid / times[i];
        }

        if (count == n) {
            return mid;
        } else if (count > n) {
            max = mid - 1;
        } else if (count < n) {
            min = mid + 1;
        }
        return recursieve(min, max, n, times);
    }


    public long solution2(int n, int[] times) {
        Arrays.sort(times);

        // 시간이 흘러간다
        for (int i = 1; i < 1_000_000_000; i++) {
            //break point
            if (n <= 0) {
                return i;
            }

            // 사람 제거
            for (int index = 0; index < times.length; index++) {
                int temp = i % times[index];
                if (temp == 0) {
                    n--;
                }

                if (n <= 0) {
                    return i;
                }
            }

        }// for end
        return -1;
    }
}