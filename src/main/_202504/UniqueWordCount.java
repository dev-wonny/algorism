package main._202504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueWordCount {
    public static void main(String[] args) {
        UniqueWordCount o = new UniqueWordCount();
        System.out.println(o.solution("ACAX"));//16
        System.out.println(o.solution("CODILITY"));//96

    }


    public int solution(String S) {
        int n = S.length();
        int mod = 1_000_000_007;

        // 각 알파벳마다 등장 위치 저장
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        // 각 알파벳마다 등장 위치 기록
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            positions[ch - 'A'].add(i);
        }

        long result = 0;

        // 각 문자마다 기여 계산
        for (int i = 0; i < 26; i++) {
            List<Integer> pos = positions[i];

            if (pos.isEmpty()) {
                continue;
            }

            // 양쪽 끝에 -1과 n을 더해줌 (범위 밖)
            pos.add(0, -1);//처음등장
            pos.add(n);

            for (int j = 1; j < pos.size() - 1; j++) {
                int prev = pos.get(j - 1);
                int curr = pos.get(j);
                int next = pos.get(j + 1);

                //(현재인덱스 - 이전 등장 인덱스) * (디음 등장 인덱스 - 현재 인덱스)
                long contribution = (long) (curr - prev) * (next - curr);
                result = (result + contribution) % mod;
            }
        }

        return (int) result;
    }

    public int solution2(String S) {
        //모든 부분 문자열을 구한다
        int mod = 1_000_000_007;
        int n = S.length();
        int[] last = new int[26];
        int[] prev = new int[26];

        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);

        long result = 0;

        for (int i = 0; i < n; i++) {
            int c = S.charAt(i) - 'A';

            result += (long) (i - last[c]);
        }

        // 각 부분 문자열에서 딱한번 등장하는 문자 개수를 센다

        //총합을 구한다

        return (int) result;
    }
}
