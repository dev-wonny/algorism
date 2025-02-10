package main._202501._31;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/1830
public class 브라이언의고민 {
    public static void main(String[] args) {
        System.out.println("HaEaLaLaObWORLDb -> expect: HELLO WORLD , result :" + solution("HaEaLaLaObWORLDb"));
        System.out.println("SpIpGpOpNpGJqOqA -> expect: SIGONG JOA, result: " + solution("SpIpGpOpNpGJqOqA"));
        System.out.println("AxAxAxAoBoBoB -> expect: invalid , result: " + solution("AxAxAxAoBoBoB"));

    }

    public static String solution(String sentence) {
        Map<Character, Integer> lowAlphabetMap = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        StringBuilder stringSb = new StringBuilder();
        StringBuilder currentString = new StringBuilder();
        Set<Character> usedRules = new HashSet<>();

        char[] charArr = sentence.toCharArray();
        boolean isRule1 = false;
        //규칙1 적용
        // 대문자로 시작
        // 대소대소대소.. 대대 오면 끝남
        // 대소대소대소.. 대소에서 소가 다른 문자이면 끝남
        // 자신의 길이가 소문자의 개수가 -1
        boolean isRule2 = false;
        // 규칙2 적용
        // 소문자로 시작
        // 같은 소문자가 2개면 끝난다
        // 소대대대대대대소 끝
        // 소대대대대대대소 -> 대||소 새로운 시작

        System.out.println(currentString);

        for (int i = 0; i < charArr.length; i++) {
            // 대문자면
            if (Character.isUpperCase(charArr[i])) {
                currentString.append(charArr[i]);
            }
            // 소문자면, 규칙 체크
            else {
                // 이미 존재하는 key
                if (!usedRules.contains(charArr[i])) {
                    lowAlphabetMap.compute(charArr[i], (k, v) -> (v == null) ? 1 : v + 1);
                }
                // 새로운 key
                else {
                    usedRules.add(charArr[i]);
                    lowAlphabetMap.compute(charArr[i], (k, v) -> (v == null) ? 1 : v + 1);
                    // 새로운 stack 시작
                }


            }


        }


        return "";
    }
}
