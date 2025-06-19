package main.binarysearch;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(9));//1001 -> 2
        System.out.println(new BinaryGap().solution(529));//1000010001 -> 4
        System.out.println(new BinaryGap().solution(20));//10100 ->1
        System.out.println(new BinaryGap().solution(15));//1111
        System.out.println(new BinaryGap().solution(32));//100000
        System.out.println(new BinaryGap().solution(1041));//10000010001 -> 5
    }

    public int solution(int N) {
        String bitString = Integer.toBinaryString(N);
        String[] split = bitString.split("");
        int max = 0;
        int count = 0;

        boolean start = false;
        for (int i = 0; i < split.length; i++) {
            if (!start && split[i].equals("1")) {
                start = true;
            } else if (start && split[i].equals("0")) {
                count++;
            } else if (start && split[i].equals("1")) {
                start = false;
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }
}
