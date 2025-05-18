package main._202504.부분집합;

import java.util.ArrayList;
import java.util.List;

public class PowerSetRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3};
        List<Integer> subset = new ArrayList<>();
        generateSubset(arr, 0, subset);
    }

    public static void generateSubset(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // 포함 X
        generateSubset(arr, index + 1, current);

        // 포함 O
        current.add(arr[index]);
        generateSubset(arr, index + 1, current);
        current.remove(current.size() - 1); // 백트래킹
    }
}