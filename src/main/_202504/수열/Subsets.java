package main._202504.수열;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
public class Subsets {
    public static void main(String[] args) {
        Subsets o = new Subsets();
        System.out.println(o.subsets(new int[] {1, 2, 3}));// [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        System.out.println(o.subsets(new int[] {0}));//[[],[0]]
    }

    //순열 구하기
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        result.add(List.of());
        sub(0, nums, result, new ArrayList<>());
        return result;
    }

    private void sub(int index, int[] nums, List<List<Integer>> result, List<Integer> saved) {
        //break point
        result.add(new LinkedList<>(saved));

        for (int i = index; i < nums.length; i++) {

            //방문체크
            saved.add(nums[i]);

            //선택된 것 있다
            sub(i + 1, nums, result, saved);

            //선택된 것 없다를 다음 함수로 넘긴다
            saved.remove(saved.size() - 1);
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 1. 이 숫자를 포함한다
        path.add(nums[index]);
        dfs(index + 1, nums, path, result);

        // 2. 이 숫자를 포함하지 않는다
        path.remove(path.size() - 1);
        dfs(index + 1, nums, path, result);
    }

//    private void sub2(int index, int[] nums, List<List<Integer>> result, List<Integer> saved, boolean[] visited) {
//        //break point
//        if (nums.length == index) {
//            result.add(new LinkedList<>(saved));
//            return;
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            //filter
//            if (visited[i]) {
//                continue;
//            }
//
//            //방문체크
//            visited[i] = true;
//            saved.add(nums[i]);
//            //선택된 것 있다
//            sub(i + 1, nums, result, saved, visited);
//
//            //선택된 것 없다를 다음 함수로 넘긴다
//            saved.remove(saved.size() - 1);
//            visited[i] = false;
////            sub(index + 1, nums, result, saved,visited);
//        }
//    }
}
