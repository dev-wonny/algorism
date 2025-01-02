package main._202412._27;

import java.util.ArrayList;
import java.util.List;

public class BigNumber2 {
    public static void main(String[] args) {
        /**
         *
         * Arrays.sort(numbers);
         * 전: [6, 10, 2]
         * 후: [2, 6, 10]
         *
         * 전: [3, 30, 34, 5, 9]
         * 후: [3, 5, 9, 30, 34]
         *
         * Collections.sort(stirngList);
         * Collections.sort(stringList, Collections.reverseOrder());
         *
         * stringList.sort(String::compareTo);
         * stirngList.sort(Comparator.naturalOrder());
         * stringList.sort((s1, s2) -> s2.compareTo(s1));
         * stirngList.sort(Comparator.reverseOrder());
         * 전: [6, 10, 2]
         * 후: [10, 2, 6]
         *
         * 전: [3, 30, 34, 5, 9]
         * 후: [3, 30, 34, 5, 9]
         *
         *
         * --내림차순
         * 전: [6, 10, 2]
         * 후: [6, 2, 10] 이건 맞아
         *
         * 전: [3, 30, 34, 5, 9]
         * 후: [9, 5, 34, 30, 3] 이건 틀려
         * 30보다 3이 앞에 있어야함
         *
         *
         * >>>>>>>>>>>>>>>>>>>>>stirngList.sort((a, b) -> (b + a).compareTo(a + b));
         * 전: [6, 10, 2]
         * 후: [6, 2, 10]
         *
         * 전: [3, 30, 34, 5, 9]
         * 후: [9, 5, 34, 3, 30]
         */
        System.out.println("expect:6210, result:" + solution(new int[] {6, 10, 2}));
        System.out.println("expect:9534330, result:" + solution(new int[] {3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        List<String> stirngList = new ArrayList<>();
        for (int num : numbers) {
            stirngList.add(String.valueOf(num));
        }
        System.out.println("전: " + stirngList);
        // 내림차순 정렬 (결합한 문자열의 크기를 기준으로 정렬)
        stirngList.sort((a, b) -> (b + a).compareTo(a + b));
        System.out.println("후: " + stirngList);


        return "";
    }// end
}
