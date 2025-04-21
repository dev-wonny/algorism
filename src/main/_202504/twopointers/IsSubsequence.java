package main._202504.twopointers;

// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence o = new IsSubsequence();
        System.out.println(o.isSubsequence("abc", "ahbgdc"));//t
        System.out.println(o.isSubsequence("axc", "ahbgdc"));//f

    }

    private boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();


        //sArr를 하나씩 처리하면서 다 처리하면 성공 아니면 실패
        int indexA = 0;
        int indexB = 0;
        int targetIndex = sArr.length;
        int last = tArr.length;

        while (indexA < targetIndex) {
            if (indexB >= last) {
                break;
            }

            if (sArr[indexA] == tArr[indexB]) {
                indexA++;
                indexB++;
            } else {
                indexB++;
            }
        }

        if (targetIndex == indexA) {
            return true;
        }

        return false;
    }

    public boolean isSubsequence2(String s, String t) {

        for (int i = 0; i < s.length(); i++) {//짧은 거를 기준으로 돈다
            int temp = t.indexOf(s.charAt(i));
            if (temp == -1) {
                return false;
            }

            t = "" + t.substring(temp + 1);
        }

        return true;
    }

}
