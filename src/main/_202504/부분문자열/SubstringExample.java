package main._202504.부분문자열;

import java.util.ArrayList;
import java.util.List;

//브루트포스 방식의 문자열 탐색
public class SubstringExample {
    public static void main(String[] args) {
        String s = "abc";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }

        getAllSubstrings("abcd");
    }

    public static List<String> getAllSubstrings(String s) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }

        return substrings;
    }

}
