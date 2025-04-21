package main._202504.순열;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationExample {
    public static void main(String[] args) {
        String[] words = {"foo", "bar"};

//        List<String> result = new ArrayList<>();
        Set<String> result = new HashSet<>();

        boolean[] used = new boolean[words.length];

        backtrack(words, new ArrayList<>(), used, result);

        for (String s : result) {
            System.out.println(s);
        }

    }

    static void backtrack(String[] words, List<String> current, boolean[] used, Set<String> result) {
        //break point
        if (current.size() == words.length) {
            result.add(String.join("", current));
            return;
        }

        for (int i = 0; i < words.length; i++) {
            //filter
            if (used[i]) {
                continue;
            }

            //방문체크
            used[i] = true;
            current.add(words[i]);

            //재귀호출
            backtrack(words, current, used, result);

            // 백트래킹
            current.remove(current.size() - 1);
            used[i] = false;

        }
    }
}
