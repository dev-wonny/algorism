package main._202504.수열;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceExample {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};//2^n -1개 = 7개
        List<List<String>> subsequences = new ArrayList<>();
        //순서 유지
        generateSubsequences(arr, 0, new ArrayList<>(), subsequences);
        //a고정   b여부  -> "a", "ab"
        //          aX고정    c여부  -> "a", "ac"
        //          ab고정    c여부 -> "ab", "abc"
        //Xb고정 c여부 -> "b", "bc"
        //XXc고정 -> "c"
        //중복되는게 있어서 기록해줘야함
        for (List<String> seq : subsequences) {
            System.out.println(seq);
        }
        /**
         * [a]
         * [a, b]
         * [a, b, c]
         * [a, c]
         * [b]
         * [b, c]
         * [c]
         */
    }

    static void generateSubsequences(String[] arr, int index, List<String> current, List<List<String>> result) {
        //break poin
        if (arr.length == index) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        //현재 원소를 포함하지 않는 경우
        generateSubsequences(arr, index + 1, new ArrayList<>(current), result);

        //현재 원소를 포함하는 경우
        current.add(arr[index]);
        generateSubsequences(arr, index + 1, new ArrayList<>(current), result);
    }
}
