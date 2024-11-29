import java.util.Arrays;

/**
 * 컴퓨터 개수 1~200, 컴퓨터 번호는 0 ~ n-1
 * <p>
 * 컴퓨터 연결 정보: 이중 배열
 * <p>
 * i와 j가 연결되어있으면 값 1
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class 네트워크2 {
    public static void main(String[] args) {


        // numbers 2이상 20이하
        이중배열생성 computers = new 이중배열생성();

        Solution solution = new Solution();

        // 풀이
        int result = solution.solution(3, computers.make1());
        System.out.println("예상 결과(2), 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();

        int result2 = solution.solution(3, computers.make2());
        System.out.println("예상 결과(1), 실제 값:" + result2);

    }

    static class Solution {
        public int solution(int n, int[][] computers) {

            // 방문여부를 배열, 최대 네트워크는 n개이다. networkVisitArr[3]
            boolean[] nodeVisited = new boolean[n];
            // 초기 nodeVisited: [false, false, false]
            System.out.println("초기 nodeVisited: " + Arrays.toString(nodeVisited));
            System.out.println();

            // 전체 네트워크 개수
            int networkCount = 0;

            // 모든 노드에 대해 DFS 탐색
            for (int i = 0; i < n; i++) {
                //브레이크 포인트
                System.out.println("for문 i:" + i + ",  nodeVisited:" + Arrays.toString(nodeVisited));

                if (!nodeVisited[i]) {
                    nodeVisited[i] = true;
                    networkCount++;
                    System.out.println("DFS 호출");
                    DFS(computers, i, nodeVisited);
                }
            }


            return networkCount;
        }

        public void DFS(int[][] computers, int startNode, boolean[] nodeVisited) {
            System.out.println("깊이:" + startNode);
            System.out.println("->".repeat(startNode) + "DFS for문 시작 전");
            for (int j = 0; j < computers[startNode].length; j++) {
                System.out.println("->".repeat(startNode) + "DFS for문 시작");
                //브레이크 포인트
                System.out.println("->".repeat(startNode) + "[입장] " + startNode + ", " + j + ": nodeVisited: " + nodeVisited[j] + ", 값: " + computers[startNode][j]);

                // 반복 작업 -> 새로운 곳이면 마킹한다
                if (computers[startNode][j] == 1 && !nodeVisited[j] && startNode != j) {
                    nodeVisited[j] = true;
                    System.out.println("->".repeat(startNode) + "[변경] " + startNode + ", " + j + ": nodeVisited: " + nodeVisited[j]);
                    // 더 땅꿀파야함 -> 네트워킹 적용 1-> 2를 연결해야함
//                    입장-> 0, 1: nodeVisited: false, 값: 1
//                    변경-> 0, 1: nodeVisited: true
//                    입장-> 0, 1: nodeVisited: true, 값: 1   이게아니라
//                    입장-> 1, 2: nodeVisited: false, 값: 1  이걸로

//                    DFS(computers, startNode, j, nodeVisited);
                    DFS(computers, j, nodeVisited);
                }

                //연결안됐으면 마킹 그대로 false로 둔다
                // 아무 작업안함
                System.out.println("->".repeat(startNode));
            }//for end

            System.out.println("깊이:" + startNode + "DFS for문 종료");
            System.out.println();
        }


    }

    static class 이중배열생성 {
        public int[][] make1() {
            int[][] arr = new int[3][3];
            arr[0] = new int[] {1, 1, 0};
            arr[1] = new int[] {1, 1, 0};
            arr[2] = new int[] {0, 0, 1};
            return arr;
        }

        public int[][] make2() {
            return new int[][] {
                {1, 1, 0}
                , {1, 1, 1}
                , {0, 1, 1}
            };
        }
    }


}
