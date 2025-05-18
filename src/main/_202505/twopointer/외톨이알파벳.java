package main._202505.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/15008/lessons/121683
public class 외톨이알파벳 {
    public static void main(String[] args) {
        외톨이알파벳 o = new 외톨이알파벳();
        System.out.println(o.solution("edeaaabbccd"));//de
        System.out.println(o.solution("eeddee"));//e
        System.out.println(o.solution("string"));
        System.out.println(o.solution("zbzbz"));//bz
    }

    public String solution(String input_string) {
        Set<Character> set = new HashSet<>();
        char[] stringRemoved = new char[input_string.length()];
        int index = 0;

        //연속된 문자를 제거한 결과를 stringRemoved에 저장.
        //ede aaa bb cc d → ede abc d
        for (char c : input_string.toCharArray()) {
            set.add(c);

            //처음 넣을때 || 이전 문자와 다르면 저장
            if (index == 0 || c != stringRemoved[index - 1]) {
                stringRemoved[index] = c;
                index++;
            }
        }

        //edeabcd → abcddee
        Arrays.sort(stringRemoved, 0, index);

        StringBuilder result = new StringBuilder();

        //정렬된 stringRemoved에서 각 문자의 등장 횟수를 세어, 2번 이상 나타나면 외톨이 알파벳이라고 판단.
        int i = 0;
        for (char c : set) {
            int count = 0;
            for (int k = i; k < stringRemoved.length; k++) {
                if (c != stringRemoved[k]) {
                    // 다음 탐색 시작 위치를 갱신
                    i = k;
                    break;
                }
                count++;
            }

            //정렬된 문자 배열을 탐색하며 count > 1인 문자를 찾아서 결과에 추가.
            if (count > 1) {
                result.append(c);
            }
        }
        if (result.length() == 0) {
            return "N";
        }
        return result.toString();
    }
}
