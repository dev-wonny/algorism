package main._202501._03;

public class PQS {
    private static int minDistinctCount;

    public static void main(String[] args) {

        System.out.println("expect:2 ,result:" + solution("abc", "bcd"));
        System.out.println("expect:2 ,result:" + solution("axxz", "yzwy"));
        System.out.println("expect:1 ,result:" + solution("bacad", "abada"));
        System.out.println("expect:3 ,result:" + solution("amz", "amz"));
    }

    public static int solution(String P, String Q) {
        minDistinctCount = P.length();
        StringBuilder current = new StringBuilder();

        // DFS 시작
        dfs(P, Q, 0, current);

        return minDistinctCount;
    }

    private static void dfs(String P, String Q, int index, StringBuilder current) {
        // 종료 조건: 문자열 끝까지 탐색
        if (index == P.length()) {
            // 현재 문자열에서 연속된 중복 문자 제거 후 고유 문자 수 계산
            minDistinctCount = Math.min(minDistinctCount, countDistinct(current.toString()));
            return;
        }

        // P[index]를 선택하는 경우
        current.append(P.charAt(index));
        dfs(P, Q, index + 1, current);
        current.deleteCharAt(current.length() - 1); // 백트래킹

        // Q[index]를 선택하는 경우
        current.append(Q.charAt(index));
        dfs(P, Q, index + 1, current);
        current.deleteCharAt(current.length() - 1); // 백트래킹
    }

    private static int countDistinct(String s) {
        int distinctCount = 0;
        char prevChar = '\0'; // 초기값: 빈 문자

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != prevChar) {
                distinctCount++;
                prevChar = currentChar;
            }
        }

        return distinctCount;
    }
}
