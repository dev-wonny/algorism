package main._202505.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=java
public class CellphonePad {
    public static void main(String[] args) {
        CellphonePad o = new CellphonePad();
        System.out.println(Arrays.toString(o.solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"})));//[9, 4]
        System.out.println(Arrays.toString(o.solution(new String[] {"AA"}, new String[] {"B"})));//-1
        System.out.println(Arrays.toString(o.solution(new String[] {"AGZ", "BSSS"}, new String[] {"ASA", "BGZ"})));//[4, 6]
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] alphabetArr = new int[26];
        Arrays.fill(alphabetArr, Integer.MAX_VALUE);

        // 각 알파벳 최소 누르는 횟수 저장
        for (String keys : keymap) {
            char[] charArray = keys.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'A';
                // 1부터 시작
                alphabetArr[index] = Math.min(alphabetArr[index], i + 1);
//                int value = alphabetArr[index];
//                //최소값으로 세팅
//                if (value > i) {
//                    alphabetArr[index] = i;
//                }
            }

        }

        List<Integer> result = new ArrayList();

        // 각 target의 최소값 합 구하기
        for (String target : targets) {
            int sum = 0;
            char[] targetCharArray = target.toCharArray();
            boolean isContinue = false;

            for (int i = 0; i < targetCharArray.length; i++) {
                int index = targetCharArray[i] - 'A';
                int value = alphabetArr[index];
                if (value == Integer.MAX_VALUE) {
                    result.add(-1);
                    isContinue = true;
                    break;
                }
                sum += value;
            }

            if (!isContinue) {
                result.add(sum);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
