package main._202504.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern o = new WordPattern();
        System.out.println(o.wordPattern("abba", "dog cat cat dog"));//t
        System.out.println(o.wordPattern("abba", "dog cat cat fish"));//f
        System.out.println(o.wordPattern("aaaa", "dog cat cat dog"));//f

        //예외
        System.out.println(o.wordPattern("abba", "dog dog dog dog"));//f -> 이미 결과 dog 사용함

    }

    public boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] splitArr = s.split(" ");

        if (charArray.length != splitArr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWord = new HashSet<>();


        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            //존재하면
            if (map.containsKey(c)) {
                String value = map.get(c);
                if (!value.equals(splitArr[i])) {
                    return false;
                }
            }
            //새로 추가
            else {
                map.put(c, splitArr[i]);
                if (usedWord.contains(splitArr[i])) {
                    return false;
                }
                usedWord.add(splitArr[i]);
            }
        }
        return true;
    }
}
