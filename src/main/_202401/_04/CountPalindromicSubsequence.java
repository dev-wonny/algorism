package main._202401._04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca")); // Expected output: 3

    }

    public static int countPalindromicSubsequence(String s) {
        //for 문으로 s 를 set넣기

        Map<String, Integer> duplicateNumberMap = new HashMap<>();
        for (String c : s.split("")) {
            duplicateNumberMap.putIfAbsent(c, duplicateNumberMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(duplicateNumberMap);


        // 중복된거 있으면 체크 시작
        Set<String> duplicatedSetKey = duplicateNumberMap.keySet();

        for (String key : duplicatedSetKey) {//check
            Integer i = duplicateNumberMap.get(key);

            if (i < 2) {
                // 중복된거 없으면 return 0;
                return 0;
            } else {
                //key 2개 이상있음
                // 중복 글씨 indexof 찾아서 서로의 거리를 구함
                // abs(indexA - indexB) -1 개수가 생성할수 있는 문자 개수임
                // 구한 값 중에서 return max();

            }
        }// for end


        return 0;
    }
}
