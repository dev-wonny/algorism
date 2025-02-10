package main._202501._04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {
    public static void main(String[] args) {
        System.out.println("Expected output: 3, " + maxVowels("abciiidef", 3));
        System.out.println("Expected output: 2, " + maxVowels("aeiou", 2));
        System.out.println("Expected output: 2, " + maxVowels("leetcode", 3));
    }


    // 윈도우
    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxVowels = 0;
        int currentVowels = 0;

        // 1. 윈도우 초기화
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // 2. 윈도우 이동
        for (int i = k; i < s.length(); i++) {
            // 오른쪽
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            //왼쪽
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }
}
