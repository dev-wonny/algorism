package main._202504.수열;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations o = new Combinations();
        System.out.println(o.combine(4, 2));//[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(o.combine(1, 1));//[[1]]

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        com(1, 1, new LinkedList<>(), result, n, k);
        return result;
    }

    private void com(int currentIndex, int dept, List<Integer> path, List<List<Integer>> result, int n, int k) {
        //break point
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        //계속 진행
        for (int i = currentIndex; i <= n; i++) {
            path.add(i);
            com(i + 1, dept + 1, path, result, n, k);
            path.remove((Object) i);
        }

        System.out.println();
    }
}
