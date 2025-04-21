package main._202504.slidingwindow;

public class FixedWindowSubstring {
    public static void main(String[] args) {
        String s = "abcdef";
        int windowSize = 3;

        for (int i = 0; i <= s.length() - windowSize; i++) {
            String sub = s.substring(i, i + windowSize);
            System.out.println(sub);
        }
    }
}
