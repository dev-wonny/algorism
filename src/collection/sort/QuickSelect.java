package collection.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSelect {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(5, 7, 9, 3, 1, 2, 4));
        int k = 2; // k번째로 큰 숫자
        int result = quickSelect(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int quickSelect(List<Integer> nums, int k) {
        int length = nums.size();

        // 리스트에 하나의 요소만 있다면 그대로 반환
        if (length == 1) {
            return nums.get(0);
        }

        // 랜덤 피벗 선택
        Random random = new Random();
        int pivotIdx = random.nextInt(length);
        int lastIdx = length - 1;

        // 피벗을 리스트의 마지막으로 이동
        swap(nums, pivotIdx, lastIdx);

        int leftIdx = 0;
        int rightIdx = length - 2;
        int pivot = nums.get(lastIdx);

        // 파티셔닝
        while (leftIdx <= rightIdx) {
            if (nums.get(leftIdx) <= pivot) {
                leftIdx++;
                continue;
            }

            if (nums.get(rightIdx) > pivot) {
                rightIdx--;
                continue;
            }

            if (nums.get(leftIdx) > pivot && nums.get(rightIdx) <= pivot) {
                swap(nums, leftIdx, rightIdx);
                continue;
            }
        }

        // 피벗을 올바른 위치로 이동
        swap(nums, leftIdx, lastIdx);

        // k번째로 큰 숫자를 찾기 위해 재귀 호출
        if (leftIdx == length - k) {
            return nums.get(leftIdx);
        } else if (leftIdx < length - k) {
            return quickSelect(nums.subList(leftIdx + 1, length), k);
        } else {
            return quickSelect(nums.subList(0, leftIdx), k - (length - leftIdx));
        }
    }

    // 두 리스트 요소를 교환
    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
