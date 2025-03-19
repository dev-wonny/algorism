package main._202503;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/131130
public class 혼자놀기의달인 {
    public static void main(String[] args) {
        혼자놀기의달인 e = new 혼자놀기의달인();

        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        System.out.println(e.solution(cards));
    }

    /**
     * 이 게임에서 얻을 수 있는 최고 점수를 구해서 -> 모든 경우의 수
     * 링크드로 연결해봅시다
     */
    private int solution(int[] cards) {
        if (cards.length <= 1) {
            return 0;
        }
        List<Integer> groupSizes = new ArrayList<>();
        int total = cards.length;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < total; i++) {
            if (!visited.contains(i)) {
                groupSizes.add(DFS(cards, i, visited, groupSizes, 0));
            }
        }

        if (groupSizes.size() < 2) {
            return 0; // 최소한 두 그룹이 있어야 곱할 수 있음
        }

        groupSizes.sort(Collections.reverseOrder()); // 내림차순 정렬
        return groupSizes.get(0) * groupSizes.get(1);
    }// solution end

    private int DFS(int[] cards, int index, Set<Integer> visited, List<Integer> groupSizes, int dept) {
        //break point // 현재 인덱스가 이미 존재하면 한바퀴 끝남 -> 종료
        if (visited.contains(index)) {
            return dept;
        }
        visited.add(index);

        // 다음꺼 진행
        return DFS(cards, cards[index] - 1, visited, groupSizes, dept + 1);
    }
}
