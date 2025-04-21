package main._202504;

public class Password {
    public static void main(String[] args) {
        Password o = new Password();
        System.out.println(o.solution("FooBar123!"));//t
        System.out.println(o.solution("foobar123!"));//f
        System.out.println(o.solution("FooBar123"));//f
        System.out.println(o.solution("F0bar! F0bar!"));//f
        System.out.println(o.solution("Fo0*"));//f
    }

    public boolean solution(String S) {
        if (S.length() < 6 || S.contains(" ")) {
            return false;
        }
        String specialChracters = "!@#$%^&*()_";
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecialCharacter = false;

        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (specialChracters.indexOf(ch) != -1) {
                hasSpecialCharacter = true;
            }
        }

        return hasDigit && hasLower && hasUpper && hasSpecialCharacter;
    }
}
