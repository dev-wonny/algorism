package main._202412._25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneCatMon {
    public static void main(String[] args) {
        System.out.println("expect: 2 ,result:" + solution2(new int[] {3, 1, 2, 3}));
        System.out.println("expect: 3 ,result:" + solution2(new int[] {3, 3, 3, 2, 2, 4}));
        System.out.println("expect: 2 ,result:" + solution2(new int[] {3, 3, 3, 2, 2, 2}));

    }

    public static int solution(int[] nums) {
        int choiceNum = nums.length / 2;
        Set<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int canChoiceVarialbe = hashSet.size();

        if (canChoiceVarialbe < choiceNum) {
            return canChoiceVarialbe;
        }

        return choiceNum;
    }

    public static int solution2(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.collectingAndThen(Collectors.toSet(),
                phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }

    public static int combination(int n, int r) {
        if (n < r) {
            return 0;
        }

        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    public static int factorial(int n) {
        int temp = 1;
        for (int i = n; i > 0; i--) {
            temp *= i;
        }
        return temp;
    }


}
