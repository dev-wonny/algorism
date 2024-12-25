package main._202412._25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class numberingK {

    public static void main(String[] args) {
        System.out.println("expect: false, result:" + Arrays.toString(
                solution(
                    new int[] {1, 5, 2, 6, 3, 7, 4}
                    , new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
                )
            )
        );


    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] cmd : commands) {
            // 우선 자르고
            int[] splitedArr = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            System.out.println("잘려진 것: " + Arrays.toString(splitedArr));


            // 자른거를 정렬하고
            Arrays.sort(splitedArr);

            // 몇번째 찾아
            int idx = cmd[2] - 1;
            int findValue = splitedArr[idx];
            result.add(findValue);

        }// for end
        // 담은 배열 리턴
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
