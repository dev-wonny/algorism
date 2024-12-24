package main._202411._29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * <p>
 * 여행경로는 [a,b]가 주어지면 b와 일치하는 것을 찾는다. 사용했으니 사용체크한다. 다시 사용못한다
 * [b, d]를 찾으면 다음거를 또 찾는다. 체크여부 확인
 * [b,가], [b, 나]가 있으면 알파벳순으로 가 를 사용한다, 비교한다
 * <p>
 * 주어진 항공권은 모두 사용해야 한다고한다 이게 예외가 될지도
 * <p>
 * return a, b, 가 를 리턴한다
 */
public class 여행경로2 {

    public static void main(String[] args) {
        // numbers 2이상 20이하
        이중배열생성 tickets = new 이중배열생성();

        Solution solution = new Solution();

        // 풀이
        String[] result = solution.solution(tickets.make1());
        System.out.println("예상 결과([ICN, JFK, HND, IAD]), 실제 값:" + Arrays.toString(result));

        System.out.println();
        System.out.println();
        System.out.println();

        String[] result2 = solution.solution(tickets.make2());
        System.out.println("예상 결과([ICN, ATL, ICN, SFO, ATL, SFO]), 실제 값:" + Arrays.toString(result2));
    }


    static class Solution {
        boolean[] visitedArr;
        boolean finished = false; // 모든 경로를 찾으면 탐색 종료

        public String[] solution(String[][] tickets) {
            visitedArr = new boolean[tickets.length];
            ArrayList<String> resultList = new ArrayList<>();

            // 정렬 먼저
            Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
            resultList.add("ICN");

            backTracking(tickets, "ICN", resultList, 0);
            System.out.println("resultList: " + resultList);


            return resultList.toArray(new String[0]);
        }// solution end

        public void backTracking(String[][] tickets, String targetString, ArrayList<String> resultList, int idx) {

            // break point
            if (idx == tickets.length) {
                finished = true; // 모든 티켓 사용 완료
                return;
            }


            //반복 작업
            //targetString 위치를 찾는다, 방문한적이 없고
            for (int i = 0; i < tickets.length; i++) {
                if (!visitedArr[i] && tickets[i][0].equals(targetString)) {
                    visitedArr[i] = true;
                    resultList.add(targetString);// 글자 추가
                    backTracking(tickets, tickets[i][1], resultList, idx + 1);

                    if (finished) {
                        return; // 모든 경로를 찾은 경우 더 이상 탐색하지 않음
                    }
                    // 백트래킹
                    visitedArr[i] = false;
                    resultList.remove(resultList.size() - 1); // 마지막 추가된 공항 제거
                }
            }//for end


        }// DFS end

    }// class end


    static class 이중배열생성 {
        public String[][] make1() {
            String[][] arr = new String[3][2];
            arr[0] = new String[] {"ICN", "JFK"};
            arr[1] = new String[] {"HND", "IAD"};
            arr[2] = new String[] {"JFK", "HND"};
            return arr;
        }

        public String[][] make2() {
            return new String[][] {
                {"ICN", "SFO"}
                , {"ICN", "ATL"}
                , {"SFO", "ATL"}
                , {"ATL", "ICN"}
                , {"ATL", "SFO"}
            };
        }
    }
}
