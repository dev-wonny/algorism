package main._202504.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords o = new SubstringwithConcatenationofAllWords();
        System.out.println(o.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));//[0,9]
        //bar foo the foo bar man


        System.out.println(o.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"}));//[]
        //word good good good best word


        System.out.println(o.findSubstring("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"}));//[6,9,12]
        //bar foo foo bar the foo bar man
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int windowSize = words[0].length();
        int totalLength = windowSize * words.length;

        // words 배열의 각 단어 빈도수를 카운트
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // 가능한 모든 시작 인덱스를 확인
        //fixed window sliding
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int wordStart = i + j * windowSize;

                //fixed window sliding
                String sub = s.substring(wordStart, wordStart + windowSize);
                if (!wordCountMap.containsKey(sub)) {
                    break;
                }

                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                if (seen.get(sub) > wordCountMap.get(sub)) {
                    break;
                }

                j++;
            }

            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }

}
