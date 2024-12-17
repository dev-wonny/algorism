import java.math.BigDecimal;
import java.math.RoundingMode;

public class MaximumAverageSubarray {

    public static void main(String[] args) {

        double r = Solution.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4);
        System.out.println(r);

        double r2 = Solution.findMaxAverage(new int[] {5}, 1);
        System.out.println(r2);

        double r3 = Solution.findMaxAverage(new int[] {0, 1, 1, 3, 3}, 4);
        System.out.println(r3);

        double r4 = Solution.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4);
        System.out.println(r4);//12.75000

        double r5 = Solution.findMaxAverage(
            new int[] {8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244,
                -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300,
                -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234,
                -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891}, 93);
        System.out.println(r5);//-594.58065

    }

    /**
     * 윈도우 함수
     * https://leetcode.com/problems/maximum-average-subarray-i/submissions/1480783712/?envType=study-plan-v2&envId=leetcode-75
     */
    static class Solution {
        static public double findMaxAverage(int[] nums, int k) {
            if (nums.length == 1) {
                return nums[0];
            }
            double temp = 0;

            for (int i = 0; i < k; i++) {
                temp += nums[i];
            }
            System.out.println(temp);
            double max = temp;


            for (int j = k; j < nums.length; j++) {
                int idx = j - k;
                temp = temp + nums[j] - nums[idx];

                max = Math.max(max, temp);
            }// for end

            BigDecimal result = BigDecimal.valueOf(max / k);
            return result.setScale(5, RoundingMode.HALF_UP).doubleValue();
        }// end
    }
}