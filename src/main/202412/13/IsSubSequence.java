/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * two pointer
 */
public class IsSubSequence {

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.isSubsequence("abc", "ahbgdc");// true
        System.out.println(r);

        boolean r2 = s.isSubsequence("axc", "ahbgdc");// false
        System.out.println(r2);

        boolean r3 = s.isSubsequence("acb", "ahbgdc");// false
        System.out.println(r3);


        boolean r4 = s.isSubsequence("ab", "baab");// true
        System.out.println(r4);

    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            System.out.println("start");
            int matchedCount = 0;
            boolean[] visited = new boolean[t.length()];
            int pointer = 0;

            for (int i = 0; i < s.length(); i++) {
                for (int j = pointer; j < t.length(); ++j) {
                    System.out.println("i:" + i + ", j:" + j);

                    if (pointer == t.length() - 1) {
                        continue;
                    }

                    if (!visited[j] && s.charAt(i) == t.charAt(j)) {
                        matchedCount++;
                        visited[j] = true;
                        pointer = j;
                        System.out.println("matched: " + matchedCount + "i:" + i + ", j:" + j + "(" + s.charAt(i) + "," + t.charAt(j) + ")");
                        continue;
                    }
                }
            }

            if (matchedCount == s.length()) {
                return true;
            }

            return false;
        }// func end
    }
}
