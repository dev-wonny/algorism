package main.dp;

public class TwoSum {
    private int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(new TwoSum().twoSum(new int[] {2, 7, 11, 15}, 9));//0,1
        System.out.println(new TwoSum().twoSum(new int[] {3, 2, 4}, 6));//1,2

    }
}
