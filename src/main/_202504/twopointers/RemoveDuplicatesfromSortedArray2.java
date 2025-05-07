package main._202504.twopointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray2 o = new RemoveDuplicatesfromSortedArray2();
        System.out.println(o.removeDuplicates(new int[] {1, 1, 1, 2, 2, 3}));//5, nums = [1,1,2,2,3,_]
        System.out.println(o.removeDuplicates(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}));//7, nums = [0,0,1,1,2,3,3,_,_]
    }

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }
        return k;
    }
}
