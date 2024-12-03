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
public class 여행경로3 {

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
        private boolean[] visitedArr; // 티켓 사용 여부
        private ArrayList<String> answer; // 정답 경로

        public String[] solution(String[][] tickets) {
            visitedArr = new boolean[tickets.length];
            answer = new ArrayList<>();

            System.out.println(Arrays.deepToString(tickets));
            // 정렬 먼저
            Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
            System.out.println(Arrays.deepToString(tickets));

            ArrayList<String> path = new ArrayList<>();
            path.add("ICN"); // 경로 시작점 추가

            backTracking(tickets, "ICN", path);

            return answer.toArray(new String[0]);
        }// solution end

        public void backTracking(String[][] tickets, String targetString, ArrayList<String> path) {
            // 모든 티켓을 사용한 경우 종료
            if (path.size() == tickets.length + 1) {
                answer = new ArrayList<>(path); // 정답 저장
                System.out.println("멈추시오:" + path);
                return;
            }

            //반복 작업
            //targetString 위치를 찾는다, 방문한적이 없고
            for (int i = 0; i < tickets.length; i++) {
                if (!visitedArr[i] && tickets[i][0].equals(targetString)) {
                    visitedArr[i] = true; // 티켓 사용
                    path.add(tickets[i][1]); // 다음 공항 추가

                    System.out.println(
                        "[호출전] tickets[i]:" + i + " 현재 공항-> " + tickets[i][0] + ", 추가한 공항:" + tickets[i][1] + ", answer:" + answer + ", path:" + path + ", visitedArr[i]:" + visitedArr[i]);
                    backTracking(tickets, tickets[i][1], path);
                    System.out.println(
                        "[호출후] tickets[i]:" + i + " 현재 공항-> " + tickets[i][0] + ", 추가한 공항:" + tickets[i][1] + ", answer:" + answer + ", path:" + path + ", visitedArr[i]:" + visitedArr[i]);


                    if (!answer.isEmpty()) {
                        System.out.println("이미 종료되었음:" + path);
                        return; // 정답이 이미 발견되었으면 탐색 종료
                    }

                    // 백트래킹
                    System.out.println(
                        "[백 전] tickets[i]:" + i + " 현재 공항-> " + tickets[i][0] + ", 추가한 공항:" + tickets[i][1] + ", answer:" + answer + ", path:" + path + ", visitedArr[i]:" + visitedArr[i]);
                    visitedArr[i] = false;
                    path.remove(path.size() - 1); // 마지막 공항 제거
                    System.out.println(
                        "[백 후] tickets[i]:" + i + " 현재 공항-> " + tickets[i][0] + ", 추가한 공항:" + tickets[i][1] + ", answer:" + answer + ", path:" + path + ", visitedArr[i]:" + visitedArr[i]);

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
