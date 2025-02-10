package main._202501._05;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7};
        int[] nums2 = {2, 3, 5};
        int[] nums3 = {2};
        System.out.println("expect [[2,2,3],[7]], result:" + combinationSum(nums1, 7));
        System.out.println("expect [[2,2,2,2],[2,3,3],[3,5]], result:" + combinationSum(nums2, 8));
        System.out.println("expect [], result:" + combinationSum(nums3, 1));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        makeCombination(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void makeCombination(int[] candidates, int step, int targetSum, List<Integer> comb, List<List<Integer>> result) {
        // 종료 조건
        if (targetSum == 0) {
            result.add(new ArrayList<>(comb));// 현재 조합 추가
            return;
        }

        // 예외 조건
        if (targetSum < 0 || step >= candidates.length) {
            return;
        }

        // 후보 숫자 탐색
        for (int i = step; i < candidates.length; i++) {
            // 현재 숫자를 조합에 추가
            comb.add(candidates[i]);
            // 재귀 호출: target에서 현재 숫자를 뺀 값으로 진행
            makeCombination(candidates, i , targetSum - candidates[i], comb, result);
            // 상태 복원 (백트래킹)
            comb.remove(comb.size() - 1);
        }
    }
}
