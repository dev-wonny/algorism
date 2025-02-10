package main._202501._17;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

// https://leetcode.com/problems/removing-stars-from-a-string
public class RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println("expect: lecoe, result:" + removeStars("leet**cod*e"));
        System.out.println("expect: , result:" + removeStars("erase*****"));
    }

    // 별표 왼쪽 글씨 제거
    public static String removeStars(String s) {
        char[] charArray = s.toCharArray();

        // stack 사용
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : charArray) {
            if (ch == '*') {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }


        // Stream API로 스택 내용을 문자열로 변환
        String result = stack.stream()
            .map(String::valueOf) // Character를 String으로 변환
            .collect(Collectors.joining("")); // 문자열로 합치기

        // 역순 변환 (StringBuilder 사용)
        return new StringBuilder(result).reverse().toString();
    }
}
