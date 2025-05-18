package main._202504.interval;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges o = new SummaryRanges();
        System.out.println(o.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}));//["0->2","4->5","7"]
        System.out.println(o.summaryRanges(new int[] {0, 2, 3, 4, 6, 8, 9}));//["0","2->4","6","8->9"]
    }

    //bitwise 0 1 10 11      100 101
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int startValue = nums[0];
        int beforeValue = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length) {
                // 마지막 값, 결과에 추가
                result.add(String.valueOf(nums[i]));
                break;
            }
            // 현재 값은 계속해서 변한다
            int currentValue = nums[i];

            if (Math.abs(beforeValue - currentValue) > 1) {
                String temp = startValue + "->" + beforeValue;

                // 긴 값, 결과에 추가
                result.add(temp);
                startValue = currentValue;
            }
            beforeValue = currentValue;
        }
        return result;
    }
}
