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
public class MoveZeroes2 {

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
            int leng = nums.length;

            if (leng == 1) {
                return;
            }


            for (int j = 0; j < leng; j++) {

                // 마지막
                if (j == leng - 1) {
                    //내가 마지막이야
                    // 0 이어도 맞고
                    // 숫자가 있어도 안해 그대로 둬
                }
                //중간
                else {
                    // 둘다 0일때는 두개를 하나의 셀로 보자
                    if (nums[j] == 0 && nums[j + 1] == 0 && j < leng - 2) {
                        int temp = nums[j + 2];
                        if (temp != 0) {
                            nums[j] = temp;
                            nums[j + 1] = 0;
                            nums[j + 2] = 0;
                        }
                    }


                    //현재 내가 0이 있다면 오른쪽으로 이동시킨다
                    else if (nums[j] == 0) {
                        int temp = nums[j + 1];
                        nums[j] = temp;
                        nums[j + 1] = 0;
                    }


                    // 0이없으면 계속 둔다

                }

            }

            System.out.println(Arrays.toString(nums));


        }// end func


    }
}