package main._202504.slidingwindow;

//https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum o = new MinimumSizeSubarraySum();
        System.out.println(o.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));//2
        System.out.println(o.minSubArrayLen(4, new int[] {1, 4, 4}));//1
        System.out.println(o.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));//0
    }

    private int minSubArrayLen(int target, int[] nums) {
        int minLength = 100000;
        int l = 0;
        int r = 0;
        int tempSum = 0;

        for (int i = r; i <= r; i++) {
            tempSum += nums[i];
            r++;

            // 현재 합이 target 이상이면 → 왼쪽 줄여보며 최소 길이 갱신
            while (tempSum <= target) {

                // 일치하는 값 나옴 -> 길이를 구한다
                if (tempSum == target) {
                    minLength = Math.min(minLength, r - l + 1);
                    break;
                }

                //시작한다 -> 값이 target보다 작으면 -> 오른쪽 증가
//                else if (tempSum < target) {
//                    r++;
//                }

                // 값이 target보다 크면 왼쪽을 증가
                l++;
            }
        }


        return minLength == 100000 ? 0 : minLength;
    }
}
