package main._202501._05;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 1};
        int[] nums3 = {1};
        System.out.println("expect [[1, 2, 3], [1, 3, 2], ...], result:"+permute(nums1));
        System.out.println("expect [[0, 1], [1, 0]], result:"+permute(nums2));
        System.out.println("expect [[1]], result:"+permute(nums3));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result) {
        // 종료 조건: path의 크기가 nums의 길이와 같을 때
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // 결과에 현재 path 추가
            return;
        }

        // 사용하지 않은 숫자를 하나씩 선택
        for (int num : nums) {
            if (path.contains(num)) {
                continue; // 이미 사용된 숫자는 스킵
            }
            path.add(num); // 숫자 추가
            backtrack(nums, path, result); // 재귀 호출
            path.remove(path.size() - 1); // 백트래킹 (상태 복원)
        }
    }
}
