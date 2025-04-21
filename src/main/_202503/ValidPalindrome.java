package main._202503;

//https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome o = new ValidPalindrome();
        System.out.println(o.isPalindrome("A man, a plan, a canal: Panama"));//t -> a man apl ana-c-ana lpa nam a
        System.out.println(o.isPalindrome("race a car"));//f
        System.out.println(o.isPalindrome(" "));//t

    }

    private boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (newString.isEmpty()) {
            return true;
        }
        char[] charArray = newString.toCharArray();
        int length = charArray.length;

        int mid = charArray.length / 2;

        for (int i = 0; i < mid; i++) {
            if (charArray[i] != charArray[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
