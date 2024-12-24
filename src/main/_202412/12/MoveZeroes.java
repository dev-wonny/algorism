import java.util.Arrays;

/**
 * 정수 배열 수가 주어지면, 0이 아닌 원소들의 상대적인 순서를 유지하면서 모든 0을 그 끝으로 이동시킵니다.
 * 배열을 복사하지 않고 제자리에서 이 작업을 수행해야 합니다.
 * <p>
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75s
 * <p>
 * //정렬알고리즘 쓰라는건데
 * 새로 만들지 말라고하니까 스왑하나보다
 */
public class MoveZeroes {

    public static void main(String[] args) {

        Solution s = new Solution();
//        s.moveZeroes(new int[] {0, 1, 0, 3, 12});
//        s.moveZeroes(new int[] {0});
//        s.moveZeroes(new int[] {0, 0});
        s.moveZeroes(new int[] {2, 1});// [2,1]

    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int leng = nums.length;

            if (leng == 1) {
                return;
            }

            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));

            int maxIndex = -1;
            for (int j = 0; j < leng; j++) {
                if (nums[j] == 0) {
                    maxIndex = j;
                }
            }

            if (maxIndex < 0) {
                return;
            }
            System.out.println("maxIndex>> " + maxIndex);

            final int zeroStartIndex = leng - maxIndex - 1;
            System.out.println("zeroStartIndex>>" + zeroStartIndex);

            for (int j = 0; j < leng; j++) {
                if (j == 0 && maxIndex < leng - 1) {
                    nums[j] = nums[maxIndex + 1];
                    System.out.println("처음 maxIndex>> " + maxIndex + ", 값: " + nums[j]);
                    System.out.println(Arrays.toString(nums));
                    maxIndex++;

                } else if (j >= zeroStartIndex) {
                    nums[j] = 0;
                }

                // 마지막
                else if (j == leng - 1) {
                    System.out.println("마지막 maxIndex>> " + maxIndex + ", 값: " + nums[j]);
                    System.out.println(Arrays.toString(nums));


                } else {
                    nums[j] = nums[maxIndex + 1];
                    System.out.println("중간 maxIndex>> " + maxIndex + ", 값: " + nums[j]);
                    System.out.println(Arrays.toString(nums));
                    maxIndex++;
                }

            }

            System.out.println(Arrays.toString(nums));


        }// end func


    }
}