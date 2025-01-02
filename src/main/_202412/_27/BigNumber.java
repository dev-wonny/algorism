package main._202412._27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BigNumber {
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
        stirngList.sort(Comparator.reverseOrder());
        System.out.println("후: " + stirngList);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < stirngList.size(); i++) {
            Integer temp = Integer.parseInt(stirngList.get(i - 1));
            Integer nextTemp = Integer.parseInt(stirngList.get(i));
            if (nextTemp * 10 == temp || nextTemp * 100 == temp || nextTemp * 1000 == temp) {
                // 자리를 바꾼다
                builder.append(nextTemp);
                builder.append(temp);
                i++;
            } else {
                builder.append(temp);
            }
        }

        return builder.toString();
    }// end
}
