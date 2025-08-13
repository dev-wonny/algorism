package main.재귀;

import java.util.Scanner;

//첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
