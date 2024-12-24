package main._202411._27;

import java.util.Arrays;

public class 타겟넘버 {

    /**
     * 주의 숫자의 위치는 바뀌지 않는다, 오직 부호만 바뀐다
     * [1, 1, 1, 1, 1]	-> 합이 3
     * 여기서 마이너스는 1개만 필요하다
     * 같은 숫자일때만 부호를 바꿔서 부호 변경의 카운트 == 5
     * 정답: 5
     * <p>
     * [4, 1, 2, 1]	-> 합이 4
     * -1 +2 -1
     * +1 -2 +1
     * 2만 부호가 달라야해서 경우가 2
     * 2의 부호의 반대만 가지면 된다, 1은 서로 부호가 같아야해서 경우가 1
     * 2*1 = 모든 경우의 수 2
     * 정답: 2
     * <p>
     * 하지만 이건 DFS, BFS이니까 컴퓨터는 모든 경우의 수를 돌려서
     * 합이 되는걸 찾으면 되겠지?
     * <p>
     * 각자 위치에서 부호만 바꾸면서 합이 target이랑 같으면 카운트 올리면 되는거 아닌가?
     * 그냥 다 모든 경우를 구해버리는거야
     * 2 * 2 * 2 * .. 길어지면 길어질수록 부담이 커지긴해
     *
     * <p>
     * https://school.programmers.co.kr/learn/courses/30/lessons/43165
     */
    public static void main(String[] args) {

        // numbers 2이상 20이하
        배열을생성하는여러가지방법 numbers = new 배열을생성하는여러가지방법();

        Solution solution = new Solution();
        int result = solution.solution(numbers.make(), 3);
        System.out.println("예상 결과(5), 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();

        int result2 = solution.solution(numbers.make2(), 4);
        System.out.println("예상 결과(2), 실제 값:" + result2);

    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            int result = 0;
            return DFS(numbers, target, result, 0);
        }

        // 끝까지 가서 더해서 올라오고, 마지막에 값이 target과 같다면 카운트 올리자
        // 재귀를 사용하자

        public int DFS(int[] numbers, int target, int sum, int currentIndex) {
            // 브레이크 포인트
            if (numbers.length == currentIndex) {
                return (sum == target) ? 1 : 0;
            }

            // 마지막 아니면 계속 더해주고 다음으로 재귀해줄래?
            // 부호 바꿔주는 부분
            // 현재 숫자를 더하거나 뺀 두 가지 경우로 재귀 호출
            int add = DFS(numbers, target, sum + numbers[currentIndex], currentIndex + 1);
            int subtract = DFS(numbers, target, sum - numbers[currentIndex], currentIndex + 1);
            System.out.println("currentIndex:" + currentIndex + ", add:" + add + ", subtract:" + subtract);


            // 재귀적으로 탐색한 두 가지 경우의 수를 합산
            return add + subtract;
        }// Solution class end


    }

    static class 배열을생성하는여러가지방법 {
        public int[] make() {
            // [1, 1, 1, 1, 1]
            int[] array = new int[5];
            array[0] = 1;
            array[1] = 1;
            array[2] = 1;
            array[3] = 1;
            array[4] = 1;

            System.out.println(Arrays.toString(array));

            return array;
        }

        public int[] make2() {
            // [4, 1, 2, 1]
            int[] array =
                {
                    4, 1, 2, 1
                };

            System.out.println(Arrays.toString(array));
            return array;
        }

    }
}