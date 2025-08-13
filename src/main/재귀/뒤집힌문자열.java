package main.재귀;

public class 뒤집힌문자열 {
    public static void main(String[] args) {
        System.out.println(new 뒤집힌문자열().solution("jaron"));//noraj
    }

    public String solution(String my_string) {
        String answer = "";
        for (int i = my_string.length() - 1; i >= 0; i--) {
            answer += my_string.charAt(i);
        }
        return answer;
    }

    public String solution2(String my_string) {
        return new StringBuilder(my_string).reverse().toString();
    }
}
