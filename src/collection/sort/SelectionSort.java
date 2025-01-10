package collection.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        // num_strs 배열 초기화
        List<Pair> numStrs = new ArrayList<>();
        numStrs.add(new Pair(7, "a"));
        numStrs.add(new Pair(7, "b"));
        numStrs.add(new Pair(5, "a"));
        numStrs.add(new Pair(5, "b"));
        numStrs.add(new Pair(3, "c"));

        // 정렬 실행
        List<Pair> sortedList = sort(numStrs);

        // 결과 출력
        for (Pair pair : sortedList) {
            System.out.println("(" + pair.num + ", " + pair.str + ")");
        }
    }

    public static List<Pair> sort(List<Pair> numStrs) {
        for (int idx = 0; idx < numStrs.size(); idx++) {
            int minNum = numStrs.get(idx).num;
            int minIdx = idx;

            for (int i = idx; i < numStrs.size(); i++) {
                if (numStrs.get(i).num < minNum) {
                    minNum = numStrs.get(i).num;
                    minIdx = i;
                }
            }

            // Swap
            Pair temp = numStrs.get(idx);
            numStrs.set(idx, numStrs.get(minIdx));
            numStrs.set(minIdx, temp);
        }
        return numStrs;
    }

    // Pair 클래스 정의
    static class Pair {
        int num;
        String str;

        public Pair(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}
