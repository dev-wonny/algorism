package main._202505.twopointer;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 o = new TwoSum1();
        System.out.println(o.twoSum(new int[] {2, 7, 11, 15}, 9));
        System.out.println(o.twoSum(new int[] {3, 2, 4}, 6));
        System.out.println(o.twoSum(new int[] {3, 3}, 6));

    }

    public int[] twoSum(int[] nums, int target) {
//        List<Integer> resultList = new ArrayList<>();
        int[] resultList = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resultList[0] = i;
                    resultList[1] = j;
//                    resultList.add(i);
//                    resultList.add(j);
                }
            }
        }
        return resultList;

//        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
