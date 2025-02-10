package main._202501._03;

import java.util.HashSet;
import java.util.Set;

public class PQS2 {
    private static int minDistinctCount;

    public static void main(String[] args) {

        System.out.println("expect:2 ,result:" + solution("abc", "bcd"));
        System.out.println("expect:2 ,result:" + solution("axxz", "yzwy"));
        System.out.println("expect:1 ,result:" + solution("bacad", "abada"));
        System.out.println("expect:3 ,result:" + solution("amz", "amz"));
    }

    public static int solution(String P, String Q) {
        minDistinctCount = Integer.MAX_VALUE; // 최소 고유 문자 수 초기화
        StringBuilder current = new StringBuilder();

        // DFS 시작
        dfs(P, Q, 0, current, '\0');

        return minDistinctCount;
    }

    private static void dfs(String P, String Q, int index, StringBuilder current, char lastChar) {
        // 종료 조건: 문자열 끝까지 탐색
        if (index == P.length()) {
            // 고유 문자의 개수를 계산
            minDistinctCount = Math.min(minDistinctCount, countDistinct(current));
            return;
        }

        // P[index]를 선택하는 경우
        if (P.charAt(index) != lastChar) {
            current.append(P.charAt(index));
            dfs(P, Q, index + 1, current, P.charAt(index));
            current.deleteCharAt(current.length() - 1); // 백트래킹
        } else {
            dfs(P, Q, index + 1, current, P.charAt(index)); // 동일한 문자는 추가하지 않고 진행
        }

        // Q[index]를 선택하는 경우
        if (Q.charAt(index) != lastChar) {
            current.append(Q.charAt(index));
            dfs(P, Q, index + 1, current, Q.charAt(index));
            current.deleteCharAt(current.length() - 1); // 백트래킹
        } else {
            dfs(P, Q, index + 1, current, Q.charAt(index)); // 동일한 문자는 추가하지 않고 진행
        }
    }

    private static int countDistinct(StringBuilder s) {
        // 고유 문자의 개수 계산
        Set<Character> distinctSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            distinctSet.add(s.charAt(i));
        }
        return distinctSet.size();
    }

}
