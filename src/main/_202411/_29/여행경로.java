package main._202411._29;

import java.util.ArrayList;
import java.util.Arrays;

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
public class 여행경로 {

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

        System.out.println();
        System.out.println();
        System.out.println();

        String[] result3 = solution.solution(tickets.make3());
        System.out.println("예상 결과([ICN, B, D, B, ICN, A, C]), 실제 값:" + Arrays.toString(result3));
    }


    static class Solution {
        public String[] solution(String[][] tickets) {
            ArrayList<String> resultList = new ArrayList<>();

//            Arrays.stream(tickets).sorted();
            boolean[] visitedArr = new boolean[tickets.length];
            for (int i = 0; i < tickets.length; i++) {
                if (!visitedArr[i]) {
                    DFS(tickets, visitedArr, "ICN", resultList);
                }
            }
            System.out.println("원래 리스트: " + resultList);

            // 리스트 뒤집기
//            Collections.reverse(resultList);
//            System.out.println("뒤집힌 리스트: " + resultList);


            return resultList.toArray(new String[0]);
        }// solution end

        public void DFS(String[][] tickets, boolean[] visitedArr, String targetString, ArrayList<String> resultList) {
            ArrayList<Integer> sameWordList = new ArrayList<>();//초기화
            int choiceIndex = -1;// 초기화
            // 글자 추가
            resultList.add(targetString);
            //반복 작업
            //targetString 위치를 찾는다
            // 방문한적이 없고
            for (int i = 0; i < tickets.length; i++) {
                if (!visitedArr[i] && tickets[i][0].equals(targetString)) {
                    sameWordList.add(i);
                }
            }//for end


            //출발지는 같고 목적지가 여러개중 하나를 고름
            if (!sameWordList.isEmpty()) {
                choiceIndex = sameWordList.get(0);
                // 글자비교
                for (int index : sameWordList) {
                    if (tickets[index][1].compareTo(tickets[choiceIndex][1]) < 0) {
                        choiceIndex = index;
                    }
                }// for end

                //고른 것은 방문체크
                visitedArr[choiceIndex] = true;
                //다음 호출한다, 계속 연관에 연관에 연관에 땅굴판다
                DFS(tickets, visitedArr, tickets[choiceIndex][1], resultList);

            }// if end

            //이미 다 방문했고, 같은 단어가 없다면 할게없어 그럼 현재 단어 리턴해
            // 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
            // 다돌았다 == for문 끝남
//            resultList.add(targetString);
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

        public String[][] make3() {
            return new String[][] {
                {"ICN", "A"}
                , {"ICN", "B"}
                , {"A", "C"}
                , {"C", "A"}
                , {"B", "D"}
                , {"D", "B"}
                , {"B", "ICN"}
            };
        }
    }
}
