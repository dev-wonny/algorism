package main._202504.twopointers;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 o = new TwoSum2();
//        System.out.println(Arrays.toString(o.twoSum(new int[] {2, 7, 11, 15}, 9)));//[1,2]
//        System.out.println(Arrays.toString(o.twoSum(new int[] {2, 3, 4}, 6)));//[1,3]
//        System.out.println(Arrays.toString(o.twoSum(new int[] {-1, 0}, -1)));//[1,2]
//        System.out.println(Arrays.toString(o.twoSum(new int[] {5, 25, 75}, 100)));//[2,3]
//        System.out.println(Arrays.toString(o.twoSum(new int[] {3, 24, 50, 79, 88, 150, 345}, 200)));//[3,6]
        System.out.println(Arrays.toString(o.twoSum(new int[] {-10, -8, -2, 1, 2, 5, 6}, 0)));//[3,5]
    }

    private int[] twoSum(int[] numbers, int target) {
        int[] result = new int[] {0, 0};

        int indexFirst = 0;
        int indexLast = numbers.length - 1;

        while (indexFirst < indexLast) {
            int temp = numbers[indexFirst] + numbers[indexLast];
            if (temp > target) {
                indexLast--;
            } else if (temp == target) {
                result[0] = indexFirst + 1;
                result[1] = indexLast + 1;
                break;
            } else {
                indexFirst++;
            }
        }

        return result;
    }

    private int[] twoSum2(int[] numbers, int target) {
        int indexA = 0;
        int indexB = indexA + 1;
        int last = numbers.length;

        int[] result = new int[] {0, 0};

        while (indexA <= last) {
            //break point
            if (indexB == last) {
                indexA++;
                indexB = indexA + 1;//init
                continue;
            }

            // iterate logic
            int temp = numbers[indexA] + numbers[indexB];
            if (temp == target) {
                result[0] = indexA + 1;
                result[1] = indexB + 1;
                break;
            }
//            else if (temp > target) {
            //더 이상 진행해 봤자.. 없음
//                break;
//            }

            else {
                indexB++;
            }
        }

        return result;
    }
}
