/**
 * 교대로 문자열 병합
 * https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.mergeAlternately("abc", "pqr");
        System.out.println("Output: apbqcr, " + result);

        String result2 = s.mergeAlternately("ab", "pqrs");
        System.out.println("Output: apbqrs, " + result2);

        String result3 = s.mergeAlternately("abcd", "pq");
        System.out.println("Output: apbqcd, " + result3);


    }


    static class Solution {
        public String mergeAlternately(String word1, String word2) {

            String[] arr1 = word1.split("");
            String[] arr2 = word2.split("");
            StringBuilder sb = new StringBuilder();

            int maxCount = Math.max(arr1.length, arr2.length);

            for (int i = 0; i < maxCount; i++) {
                if (i <= arr1.length - 1) {
                    sb.append(arr1[i]);
                }
                if (i <= arr2.length - 1) {
                    sb.append(arr2[i]);
                }
            }

            return sb.toString();
        }
    }


}
