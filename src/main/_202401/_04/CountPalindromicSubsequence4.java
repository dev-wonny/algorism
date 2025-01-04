package main._202401._04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPalindromicSubsequence4 {
    public static void main(String[] args) {
        System.out.println("Expected output: 3, " + countPalindromicSubsequence("aabca"));
        System.out.println("Expected output: 0, " + countPalindromicSubsequence("adc"));
        System.out.println("Expected output: 4, " + countPalindromicSubsequence("bbcbaba"));
    }

    static class Pos {
        int start;
        int end;

        Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int countPalindromicSubsequence(String s) {
        Map<Character, Pos> positionByAlphabet = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Pos pos = positionByAlphabet.getOrDefault(c, new Pos(Integer.MAX_VALUE, Integer.MIN_VALUE));
            pos.start = Math.min(pos.start, i);
            pos.end = i;
            positionByAlphabet.put(c, pos);
        }

        int res = 0;
        for (Pos v : positionByAlphabet.values()) {
            if (v.start < v.end) {
                Set<Character> uniqueAlpha = new HashSet<>();
                for (int i = v.start + 1; i < v.end; i++) {
                    uniqueAlpha.add(s.charAt(i));
                }
                res += uniqueAlpha.size();
            }
        }

        return res;
    }
}
