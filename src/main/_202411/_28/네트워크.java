package main._202411._28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 컴퓨터 개수 1~200, 컴퓨터 번호는 0 ~ n-1
 * <p>
 * 컴퓨터 연결 정보: 이중 배열
 * <p>
 * i와 j가 연결되어있으면 값 1
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class 네트워크 {
    public static void main(String[] args) {

        // hashSet
        Set<Set<Integer>> set = new HashSet<>();

        // 각 값을 작은 값부터 정렬된 Set으로 저장
        set.add(new HashSet<>(Arrays.asList(0, 0)));
        set.add(new HashSet<>(Arrays.asList(1, 1)));
        set.add(new HashSet<>(Arrays.asList(2, 2)));
        set.add(new HashSet<>(Arrays.asList(3, 3)));

        set.add(new HashSet<>(Arrays.asList(1, 0)));
        set.add(new HashSet<>(Arrays.asList(0, 1)));

        set.add(new HashSet<>(Arrays.asList(3, 2)));
        set.add(new HashSet<>(Arrays.asList(2, 3)));

        set.add(new HashSet<>(Arrays.asList(4, 0)));
        set.add(new HashSet<>(Arrays.asList(0, 4)));


        System.out.println(set); // [[0], [1], [0, 1], [2], [3], [0, 4], [2, 3]]


        // numbers 2이상 20이하
        이중배열생성 computers = new 이중배열생성();

        Solution solution = new Solution();

        // 풀이
        int result = solution.solution(3, computers.make1());
        System.out.println("예상 결과(), 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();

        int result2 = solution.solution(3, computers.make2());
        System.out.println("예상 결과(), 실제 값:" + result2);

    }

    static class Solution {
        public int solution(int n, int[][] computers) {
            // 배열에서 반만 보면 됨

//            연결에 연결된 값을 알아내자
            // hashset에 넣는다
            Set<Set<Integer>> set = new HashSet<>();

            set = IntStream.range(0, computers.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, computers[i].length)
                    .filter(j -> computers[i][j] == 1)
                    .mapToObj(j -> new HashSet<>(Arrays.asList(i, j)))
                )
                .collect(Collectors.toSet());

            System.out.println();

            return set.size();
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
