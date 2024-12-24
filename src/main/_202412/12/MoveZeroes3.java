/**
 * 정수 배열 수가 주어지면, 0이 아닌 원소들의 상대적인 순서를 유지하면서 모든 0을 그 끝으로 이동시킵니다.
 * 배열을 복사하지 않고 제자리에서 이 작업을 수행해야 합니다.
 * <p>
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75s
 * <p>
 * //정렬알고리즘 쓰라는건데
 * 새로 만들지 말라고하니까 스왑하나보다
 */
public class MoveZeroes3 {

    public static void main(String[] args) {

        Solution s = new Solution();
        s.moveZeroes(new int[] {0, 1, 0, 3, 12});
        s.moveZeroes(new int[] {4, 2, 4, 0, 0, 3, 0, 5, 1, 0});//[4,2,4,3,5,1,0,0,0,0]
//        s.moveZeroes(new int[] {0});
//        s.moveZeroes(new int[] {0, 0});
//        s.moveZeroes(new int[] {2, 1});// [2,1]

    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            // 0이 아닌 원소를 둘 인덱스
            int nonZeroIndex = 0;

            // 0 이 아닌 것은 앞으로 이동
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[nonZeroIndex] = nums[i];
                    nonZeroIndex++;
                }
            }

            // 나머지 0으로 지워버림
            for (int j = nonZeroIndex; j < nums.length; j++) {
                nums[j] = 0;
            }


        }// end func
    }
}