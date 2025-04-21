package main._202504.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings o = new IsomorphicStrings();
        System.out.println(o.isIsomorphic("egg", "add"));//t e:a g:d
        System.out.println(o.isIsomorphic("foo", "bar"));// f:b o:a o:r(값 불일치 a)
        System.out.println(o.isIsomorphic("paper", "title"));//t --> p:t a:i e:l r:e
        System.out.println(o.isIsomorphic("badc", "baba"));//f -> b:b a:a d:b(이미 결과 b 존재) c:a(오지도 못함)
    }

    public boolean isIsomorphic(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sArr.length != tArr.length) {
            return false;
        }

        HashMap<Character, Character> startMap = new HashMap<>();
        Set<Character> endSet = new HashSet<>();

        if (sArr.length != tArr.length) {
            return false;
        }

        for (int i = 0; i < sArr.length; i++) {
            char sCharacter = sArr[i];
            char tCharacter = tArr[i];

            // 들어있는 경우 결과가 같은지 체크
            if (startMap.containsKey(sCharacter)) {
                Character sMatched = startMap.get(sCharacter);
                if (sMatched != tCharacter) {
                    return false;
                }
            }
            // 새로운 키 넣기
            else {
                startMap.put(sCharacter, tCharacter);
                if (endSet.contains(tCharacter)) {
                    return false;
                }
                endSet.add(tCharacter);
            }
        }

        return true;
    }
}
