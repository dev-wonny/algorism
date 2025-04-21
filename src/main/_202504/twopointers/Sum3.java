package main._202504.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
public class Sum3 {

    public static void main(String[] args) {
        Sum3 o = new Sum3();
        System.out.println(o.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));//[[-1,-1,2],[-1,0,1]]
        System.out.println(o.threeSum(new int[] {0, 1, 1}));//[]
        System.out.println(o.threeSum(new int[] {0, 0, 0}));//[[0,0,0]]
        System.out.println(o.threeSum(new int[] {0, 0, 0, 0}));//[[0,0,0]]
        System.out.println(o.threeSum(new int[] {2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}));//[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 정렬
        Arrays.sort(nums);// -4, -1, -1, 0, 1, 2

        Set<List<Integer>> result = new HashSet<>();

        // 중간index 변화
        for (int i = 1; i < nums.length - 1; i++) {
            // 전제 깔기
            int indexMid = i;
            int indexL = indexMid - 1;
            int indexR = indexMid + 1;

            // 중간으로 하나 잡고, 왼쪽 오른쪽으로 변경시킨다
            while (true) {
                if (indexL < 0) {
                    break;
                }
                if (indexR > nums.length - 1) {
                    break;
                }
                int temp = nums[indexL] + nums[indexMid] + nums[indexR];

                if (temp == 0) {
                    result.add(List.of(nums[indexL], nums[indexMid], nums[indexR]));
                    indexR++;
                    indexL--;
                } else if (temp < 0) {
                    indexR++;
                } else if (temp > 0) {
                    indexL--;
                }
            }
        }


        return result.stream().toList();
    }
}
