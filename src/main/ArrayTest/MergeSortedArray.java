package main.ArrayTest;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSortedArray().merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3)));
        System.out.println(Arrays.toString(new MergeSortedArray().merge(new int[] {1}, 1, new int[] {}, 0)));
        System.out.println(Arrays.toString(new MergeSortedArray().merge(new int[] {0}, 0, new int[] {2}, 1)));

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int leftIndex = 0;
        int rightIndex = 0;

        int mergedIndex = 0;
        while (leftIndex < m && rightIndex < n) {

            //후보군에서 작은 값을 먼저 넣는다
            if (nums1[leftIndex] < nums2[rightIndex]) {
                merged[mergedIndex++] = nums1[leftIndex++];
            } else {
                merged[mergedIndex++] = nums2[rightIndex++];
            }
        }
        while (leftIndex < m) {
            merged[mergedIndex++] = nums1[leftIndex++];
        }
        while (rightIndex < n) {
            merged[mergedIndex++] = nums2[rightIndex++];
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l] = merged[l];
        }
        return merged;
    }
}
