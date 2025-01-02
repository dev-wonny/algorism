package main._202412._27;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {

        System.out.println("expect:3, result:" + solution(new int[] {3, 0, 6, 1, 5}));

    }

    public static int solution(int[] citations) {
        System.out.println("전: " + Arrays.toString(citations));
        Arrays.sort(citations);
        System.out.println("후: " + Arrays.toString(citations));
        double a = (double) citations.length / 2;
        System.out.println("a>> " + a);
        double b = Math.rint(a);
        System.out.println("b>> " + b);
        int result = (int) b;
        System.out.println("result>> " + result);

        return citations[result+1];
    }
}
