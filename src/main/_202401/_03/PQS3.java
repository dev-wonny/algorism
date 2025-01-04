package main._202401._03;

import java.util.HashSet;
import java.util.Set;

public class PQS3 {
    private static int minDistinctCount;

    public static void main(String[] args) {

        System.out.println("expect:2 ,result:" + solution("abc", "bcd"));
        System.out.println("expect:2 ,result:" + solution("axxz", "yzwy"));
        System.out.println("expect:1 ,result:" + solution("bacad", "abada"));
        System.out.println("expect:3 ,result:" + solution("amz", "amz"));
    }

    public static int solution(String P, String Q) {
        // you can also use imports, for example:
        return dfs(P, Q, 0, new HashSet());

    }

    public static int dfs(String P, String Q, int step, Set<Character> set) {
        // break point
        if (step == P.length()) {
            return set.size();
        }

        HashSet<Character> PS = new HashSet<>(set);
        HashSet<Character> QS = new HashSet<>(set);

        PS.add(P.charAt(step));
        QS.add(Q.charAt(step));
        return Math.min(dfs(P, Q, step + 1, PS), dfs(P, Q, step + 1, QS));
    }

}