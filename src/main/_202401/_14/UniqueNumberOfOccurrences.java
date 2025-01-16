package main._202401._14;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println("expect:true, result:" + uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
        System.out.println("expect:true, result:" + uniqueOccurrences(new int[] {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println("expect:false , result:" + uniqueOccurrences(new int[] {1, 2}));
        System.out.println("expect:true , result:" + uniqueOccurrences(new int[] {2, 2}));
        System.out.println("expect:false , result:" + uniqueOccurrences(new int[] {26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 20, 16, 17, 16, 2, 16, 20, 26, 16}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        // 예외 케이스 {2, 2}
        if (hashMap.size() == 1) {
            return true;
        }

//        int count = 0;
//
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() == 1) {
//                count += 1;
//            }
//        }

        HashSet<Integer> valueSet = new HashSet();
        for (Integer value : hashMap.values()) {
            if (!valueSet.add(value)) {
                // 이미 있어?
                return false;
            }
        }
        return true;
    }// end
}
