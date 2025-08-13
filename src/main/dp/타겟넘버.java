package main.dp;

public class 타겟넘버 {
    int count = 0;

    public int solution(int[] numbers, int target) {
        // 모든 경우는 두가지야 나를 포함 나를 안포함

        int temp = numbers[0];
        dp(temp, target, numbers, 0);
        dp(-temp, target, numbers, 0);

        return count;
    }

    private void dp(int sum, int target, int[] numbers, int index) {
        if (numbers.length - 1 == index && sum == target) {
            count++;
        }

        if (numbers.length - 1 == index) {
            return;
        }

        dp(sum + numbers[index + 1], target, numbers, index + 1);
        dp(sum - numbers[index + 1], target, numbers, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new 타겟넘버().solution(new int[] {1, 1, 1, 1, 1}, 3));//5
        System.out.println(new 타겟넘버().solution(new int[] {4, 1, 2, 1}, 4));//2
    }

}
