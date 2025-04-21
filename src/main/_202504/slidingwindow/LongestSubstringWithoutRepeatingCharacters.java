package main._202504.slidingwindow;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
//        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));//3
//        System.out.println(o.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(o.lengthOfLongestSubstring("pwwkew"));//3 ->wke
    }

    private int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, max = 0;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }

        return max;
    }


    private int lengthOfLongestSubstring2(String s) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        Set<Character> set = new HashSet<>();
        int r;
        char[] charArray = s.toCharArray();
        for (r = 0; r < s.length(); r++) {
            if (set.contains(charArray[r])) {
                if (charArray[r] == charArray[r - 1]) {
                    //초기화
                    set = new HashSet<>();
                } else {
                    set.remove(charArray[r]);
                }

                max = Math.max(max, r - l);
                //l 증가
                l++;
                --r;
            } else {
                set.add(charArray[r]);
            }
        }
        return max;
    }
}
