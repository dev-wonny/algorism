package main.twopointers;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
//        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[] {7, 1, 5, 3, 6, 4}));//5
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[] {2, 1, 4}));//2
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = prices.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, prices[right] - prices[left]);
            // 값이 큰쪽이 움직인다
            if (prices[left] < prices[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
