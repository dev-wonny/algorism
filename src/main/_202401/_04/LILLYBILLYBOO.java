package main._202401._04;

import java.util.HashMap;
import java.util.Map;

public class LILLYBILLYBOO {
    public static void main(String[] args) {
        System.out.println("Expected output: 2, " + maxNames("LILLYBILLYBOO", new String[] {"BILL", "MARIA", "LILLY"}));
    }

    public static int maxNames(String s, String[] names) {
        // S의 문자 빈도 계산
        Map<Character, Integer> sFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            sFrequency.put(c, sFrequency.getOrDefault(c, 0) + 1);
        }

        int maxCount = 0;

        // 각 이름에 대해 최대 제작 가능 횟수 계산
        for (String name : names) {
            Map<Character, Integer> nameFrequency = new HashMap<>();
            for (char c : name.toCharArray()) {
                nameFrequency.put(c, nameFrequency.getOrDefault(c, 0) + 1);
            }

            // 최소 제작 가능 횟수 계산
            int count = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : nameFrequency.entrySet()) {
                char letter = entry.getKey();// 필요한 문자
                int required = entry.getValue();// 필요한 개수
                int available = sFrequency.getOrDefault(letter, 0);// 제공되는 개수

                count = Math.min(count, available / required);
            }

            // 최대 제작 가능 횟수 업데이트
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
