public class ContainerWithMostWater {

    public static void main(String[] args) {
        int result1 = Solution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("expect:49, result:" + result1);


        int result2 = Solution.maxArea(new int[] {1, 1});
        System.out.println("expect:1, result:" + result2);
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
     */
    static class Solution {
        static public int maxArea(int[] height) {

            int pL = 0;
            int pR = height.length - 1;
            int maxArea = 0;

            while (pL < pR) {
                int tempArea = Math.min(height[pL], height[pR]) * (pR - pL);
                maxArea = Math.max(tempArea, maxArea);

                if (height[pL] < height[pR]) {
                    pL++;
                } else {
                    pR--;
                }
            }

            return maxArea;
        }
    }
}
