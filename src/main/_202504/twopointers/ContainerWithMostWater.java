package main._202504.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater o = new ContainerWithMostWater();
        System.out.println(o.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));//49
        System.out.println(o.maxArea(new int[] {1,1}));//1
    }
    private int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int extendMax = 0;

        while (left < right) {
            int heightLeft = height[left];
            int heightRight = height[right];

            int tempExtend = (right - left) * (heightLeft < heightRight ? heightLeft : heightRight);
            if (extendMax < tempExtend) {
                extendMax = tempExtend;
            }

            //break
            if (left == right) {
                break;
            }

            if (heightLeft <= heightRight) {
                left++;

            } else if (heightLeft > heightRight) {
                right--;
            }

        }

        return extendMax;
    }
}
