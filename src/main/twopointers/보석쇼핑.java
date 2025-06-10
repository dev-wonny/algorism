package main.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
/*
two pointers는 우선 처음부터 끝까지 도달할떄까지 다 돌려본다.
왼쪽에서 오른쪽까지 진행하면서 제일 작은 값을 기록하고 return
 */
public class 보석쇼핑 {
    public static void main(String[] args) {
//        //[3, 7]
//        System.out.println(Arrays.toString(new 보석쇼핑()
//            .solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
//
//        //[1, 3]
//        System.out.println(Arrays.toString(new 보석쇼핑()
//            .solution(new String[] {"AA", "AB", "AC", "AA", "AC"})));
//
//        //[1, 1]
//        System.out.println(Arrays.toString(new 보석쇼핑()
//            .solution(new String[] {"XYZ", "XYZ", "XYZ"})));
//
//        //[1, 5]
//        System.out.println(Arrays.toString(new 보석쇼핑()
//            .solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));

        //[3, 6]
        System.out.println(Arrays.toString(new 보석쇼핑()
            .solution(new String[] {"ZZZ", "YYY", "NNN", "YYY", "BBB", "ZZZ", "NNN"})));
    }

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));

        int targetSize = set.size();
        if (targetSize == 1) {
            return new int[] {1, 1};
        }

        Map<String, Integer> checkMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int resultLeft = 0;
        int resultRight = 0;

        int min = Integer.MAX_VALUE;
        while (true) {
            // break point: right가 끝까지 도달함, 유일한 탈출구
            // left, right 모두 끝까지 가보자
            if (left > right || left >= gems.length) {
                break;
            }

            // 시작~끝 길이 업데이트
            if (checkMap.size() == targetSize) {
                int temp = right - left;
                if (min > temp) {
                    min = temp;
                    resultLeft = left;
                    resultRight = right;
                }

                // left 과거 제거
                String gemType = gems[left];
                Integer i = checkMap.get(gemType);
                checkMap.put(gemType, --i);

                if (i == 0) {
                    checkMap.remove(gemType);
                }
                // left 확장
                left++;
            }

            // 대부분의 로직, right 확장
            else if (right < gems.length) {
                //현재 값 추가 0, 1, 2, ...
                checkMap.put(gems[right], checkMap.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            // 왼쪽만 증가시킴
            else if (right == gems.length) {
                if (left >= gems.length) {
                    break; // left도 끝까지 간 경우 루프 종료
                }
                // left 계속 이동 시도 (이미 end가 끝이므로 left만 움직일 수 있음)
                // left 과거 제거
                String gemType = gems[left];
                Integer i = checkMap.get(gemType);
                checkMap.put(gemType, --i);

                if (i == 0) {
                    checkMap.remove(gemType);
                }
                // left 확장
                left++;

            }
        }

        return new int[] {resultLeft + 1, resultRight};
    }
}
