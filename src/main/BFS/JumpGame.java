package main.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] {2, 3, 1, 1, 4}));//true
        System.out.println(new JumpGame().canJump(new int[] {3, 2, 1, 0, 4}));//false
    }

    public boolean canJump(int[] nums) {
        int currentPosition = 0;
        int max = nums[currentPosition];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = max; i > 0; i--) {
            queue.add(currentPosition + i);

        }// for end
        //처음에서 갈수있는 범위로 가보자
        BFS(nums, 0);

        return false;
    }

    public void BFS(int[] nums, int currentPosition) {
        if (currentPosition >= nums.length - 1) {
        }


    }
}