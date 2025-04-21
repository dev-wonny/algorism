package main._202504.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote o = new RansomNote();
        System.out.println(o.canConstruct("a", "b"));//f
        System.out.println(o.canConstruct("aa", "ab"));//f
        System.out.println(o.canConstruct("aa", "aab"));//t

        //exception
        System.out.println(o.canConstruct("aab", "baa"));//t
        System.out.println(o.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));//t
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int count = magazine.indexOf(c, frequency[c - 'a']);
            if (count == -1) {
                return false;
            }
            frequency[c - 'a'] = count + 1;
        }
        return true;
    }

    private boolean canConstruct3(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        // ransomNote 만들 수 있는지 확인
        for (char c : ransomNote.toCharArray()) {
            int count = magazineMap.getOrDefault(c, 0);
            if (count == 0) {
                return false; // 해당 문자가 부족함
            }
            magazineMap.put(c, count - 1); // 사용한 문자 제거
        }

        return true;
    }

    private boolean canConstruct2(String ransomNote, String magazine) {
        char[] charArray = ransomNote.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            builder.append(charArray[i]);
        }
        String string = builder.toString();
        return magazine.contains(ransomNote) && magazine.contains(string);
    }
}
