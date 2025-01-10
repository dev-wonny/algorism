package collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 7, 9, 3, 1, 2, 4);
        List<Integer> sortedNums = mergeSort(nums);

        // 결과 출력
        System.out.println(sortedNums);
    }

    public static List<Integer> mergeSort(List<Integer> nums) {
        // 리스트 길이가 1이면 정렬 완료된 것으로 간주
        int length = nums.size();
        if (length == 1) {
            return nums;
        }

        // 리스트를 두 부분으로 나눔
        int mid = length / 2;
        List<Integer> leftNums = nums.subList(0, mid);
        List<Integer> rightNums = nums.subList(mid, length);

        // 재귀적으로 정렬
        List<Integer> sortedLeft = mergeSort(leftNums);
        List<Integer> sortedRight = mergeSort(rightNums);

        // 두 정렬된 리스트를 병합
        return merge(sortedLeft, sortedRight);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sortedNums = new ArrayList<>();
        int idxL = 0, idxR = 0;

        // 병합
        while (idxL < left.size() || idxR < right.size()) {
            if (idxL == left.size()) {
                sortedNums.add(right.get(idxR));
                idxR++;
                continue;
            }

            if (idxR == right.size()) {
                sortedNums.add(left.get(idxL));
                idxL++;
                continue;
            }

            if (right.get(idxR) <= left.get(idxL)) {
                sortedNums.add(right.get(idxR));
                idxR++;
            } else {
                sortedNums.add(left.get(idxL));
                idxL++;
            }
        }

        return sortedNums;
    }
}
