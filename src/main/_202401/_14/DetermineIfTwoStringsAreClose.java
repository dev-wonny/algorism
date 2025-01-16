package main._202401._14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println("expect:true, result:" + closeStrings("abc", "bca"));
        System.out.println("expect:true, result:" + closeStrings("cabbba", "abbccc"));
        System.out.println("expect:false, result:" + closeStrings("a", "aa"));
        System.out.println("expect:false, result:" + closeStrings("abbzzca", "babzzcz"));
        System.out.println("expect:false, result:" + closeStrings("abc", "abcdd"));
        System.out.println("expect:false, result:" + closeStrings("ac", "c"));
    }

    public static boolean closeStrings(String word1, String word2) {
        // 길이가 다르면 바로 false 반환
        if (word1.length() != word2.length()) {
            return false;
        }

        // 각 문자 빈도수와 문자 집합 생성
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            set2.add(c);
        }

        // 문자 집합이 다르면 false
        if (!set1.equals(set2)) {
            return false;
        }

        // 빈도수 배열을 정렬하여 비교
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean closeStrings2(String word1, String word2) {
        // 길이가 다르면 바로 false 반환
        if (word1.length() != word2.length()) {
            return false;
        }

        HashSet<Character> checkKey = new HashSet<>();
        HashMap<Character, Integer> hashMapA = new HashMap<>();
        HashMap<Character, Integer> hashMapB = new HashMap<>();

        for (char word : word1.toCharArray()) {
            hashMapA.put(word, hashMapA.getOrDefault(word, 0) + 1);
            checkKey.add(word);
        }

        for (char word : word2.toCharArray()) {
            hashMapB.put(word, hashMapB.getOrDefault(word, 0) + 1);
            if (!checkKey.contains(word)) {
                return false;
            }
        }

        // 길이 차이..

        // 값을 빼주고, 일치하는 여부 확인

        LinkedList<Integer> list = new LinkedList<>();


        for (Map.Entry<Character, Integer> entry : hashMapB.entrySet()) {
            int val1 = entry.getValue();
            list.add(val1);
        }

        for (Map.Entry<Character, Integer> entry2 : hashMapA.entrySet()) {
            int val2 = entry2.getValue();
            if (list.size() > 1 && list.contains(val2)) {
                list.remove((Object) val2);
            } else if (list.size() == 1 && list.contains(val2)) {
                return true;
            } else if (!list.contains(val2)) {
                return false;
            }

        }

        return true;
    }
}
