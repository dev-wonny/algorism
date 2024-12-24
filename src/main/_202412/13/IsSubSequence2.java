/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * two pointer
 */
public class IsSubSequence2 {

    public static void main(String[] args) {
        boolean r = Solution.isSubsequence2("abc", "ahbgdc");// true
        System.out.println("expect:true, result:" + r);

        boolean r2 = Solution.isSubsequence2("axc", "ahbgdc");// false
        System.out.println("expect:false, result:" + r2);

        boolean r3 = Solution.isSubsequence2("acb", "ahbgdc");// false
        System.out.println("expect:false, result:" + r3);


        boolean r4 = Solution.isSubsequence2("ab", "baab");// true
        System.out.println("expect:true, result:" + r4);

        boolean r5 = Solution.isSubsequence2("aaaaaa", "bbaaaa");// false
        System.out.println("expect:false, result:" + r5);


        boolean r6 = Solution.isSubsequence2("bcd", "uuubcd");// true
        System.out.println("expect:true, result:" + r6);

    }

    static class Solution {

        /**
         * 비효율적
         * O(N^2)
         */
        static public boolean isSubsequence(String s, String t) {
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

        /**
         * 성능 개선
         * O(N)
         */
        static public boolean isSubsequence2(String s, String t) {
            int pointerA = 0;
            int pointerB = 0;

            while (pointerA < s.length() && pointerB < t.length()) {
                if (s.charAt(pointerA) == t.charAt(pointerB)) {
                    pointerA++;
                }
                pointerB++;
            }

            // i가 s의 길이에 도달하면 모든 문자가 매칭된 것
            return pointerA == s.length();
        }// func end
    }
}
