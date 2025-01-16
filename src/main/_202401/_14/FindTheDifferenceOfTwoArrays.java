package main._202401._14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/solutions/4390106/97-beats-only-using-hashset-friendly/?envType=study-plan-v2&envId=leetcode-75
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println("expect:[[1,3],[4,6]], result:" + findDifference2(new int[] {1, 2, 3}, new int[] {2, 4, 6}));
        System.out.println("expect:[[3],[]] , result:" + findDifference(new int[] {1, 2, 3, 3}, new int[] {1, 1, 2, 2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSetOne = new HashSet<>();
        for (int num : nums1) {
            hashSetOne.add(num);
        }

        HashSet<Integer> hashSetTwo = new HashSet<>();
        for (int num : nums2) {
            hashSetTwo.add(num);
        }

//        boolean removedOne = hashSetOne.remove(hashSetTwo);
//        boolean removedTwo = hashSetTwo.remove(hashSetOne);

        List<Integer> resultA = new ArrayList<>();
        List<Integer> resultB = new ArrayList<>();

        for (Integer ele : hashSetTwo) {
            if (!hashSetOne.contains(ele)) {
                resultB.add(ele);
            }
        }

        for (Integer ele : hashSetOne) {
            if (!hashSetTwo.contains(ele)) {
                resultA.add(ele);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(resultA);
        result.add(resultB);

        return result;
    }

    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        for (int ele : nums1) {
            s1.add(ele);
        }
        for (int ele : nums2) {
            s2.add(ele);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultA = new ArrayList<>(s1);
        List<Integer> resultB = new ArrayList<>(s2);

        resultA.removeAll(s2);
        resultB.removeAll(s1);

        result.add(resultA);
        result.add(resultB);
        return result;
    }
}
