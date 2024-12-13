/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * two pointer
 */
public class IsSubSequence2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.isSubsequence("abc", "ahbgdc");// true
        System.out.println("expect:true, result:" + r);

        boolean r2 = s.isSubsequence("axc", "ahbgdc");// false
        System.out.println("expect:false, result:" + r2);

        boolean r3 = s.isSubsequence("acb", "ahbgdc");// false
        System.out.println("expect:false, result:" + r3);


        boolean r4 = s.isSubsequence("ab", "baab");// true
        System.out.println("expect:true, result:" + r4);

        boolean r5 = s.isSubsequence("aaaaaa", "bbaaaa");// false
        System.out.println("expect:false, result:" + r5);


        boolean r6 = s.isSubsequence("bcd", "uuubcd");// true
        System.out.println("expect:true, result:" + r6);

    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            System.out.println("start>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + s + ">>>" + t);

            int matchedIndex = 0;
            int matchedCount = 0;

            for (int i = 0; i < s.length(); i++) {
                // break point
                if (matchedIndex > t.length() - 1) {
                    System.out.println("break" + matchedIndex);
                    break;
                }
                for (int j = matchedIndex; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        matchedIndex = j + 1;
                        matchedCount++;
                        System.out.println("matched: " + matchedCount + ", i:" + i + ", j:" + j + "(" + s.charAt(i) + "," + t.charAt(j) + ")");
                        break;
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
