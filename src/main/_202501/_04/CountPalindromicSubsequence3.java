package main._202501._04;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence3 {
    public static void main(String[] args) {
        System.out.println("Expected output: 3, " + countPalindromicSubsequence("aabca"));
        System.out.println("Expected output: 0, " + countPalindromicSubsequence("adc"));
        System.out.println("Expected output: 4, " + countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {
        // 고유 문자 추출
        Set<Character> letters = new HashSet<>();
        for (Character c : s.toCharArray()) {
            letters.add(c);
        }

        int ans = 0;
        // 각 고유 문자에 대해 처리
        for (Character letter : letters) {
            int i = -1; // 첫 번째 위치
            int j = 0;  // 마지막 위치

            // 첫 번째와 마지막 위치 탐색
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) { // 첫 번째 위치 설정
                        i = k;
                    }
                    j = k; // 마지막 위치 업데이트
                }
            }

            // 첫 번째와 마지막 사이의 고유 문자 추출
            Set<Character> between = new HashSet<>();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }

            // 고유 중간 문자의 개수를 누적
            ans += between.size();
        }

        return ans; // 결과 반환
    }
}
