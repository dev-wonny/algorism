package main._202401._17;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/asteroid-collision
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println("expect: [5,10], result:" + Arrays.toString(asteroidCollision(new int[] {5, 10, -5})));
        System.out.println("expect: [], result:" + Arrays.toString(asteroidCollision(new int[] {8, -8})));
        System.out.println("expect: [10], result:" + Arrays.toString(asteroidCollision(new int[] {10, 2, -5})));
        System.out.println("expect: [-2,-1,1,2], result:" + Arrays.toString(asteroidCollision(new int[] {-2, -1, 1, 2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean checkbuhoPrev = false;
        boolean checkbuhoCurrent = false;

        for (int i = 0; i < asteroids.length; i++) {
            stack.push(asteroids[i]);

            while (!stack.isEmpty()) {
                int currentValue = stack.pop();

                if (stack.size() <= 0) {
                    stack.push(currentValue);
                    break;
                }
                int preValue = stack.pop();

                // 부호 check
                checkbuhoPrev = preValue >= 0;
                checkbuhoCurrent = currentValue >= 0;


                // 부호가 같으면 스택에 소행성 추가, while 벗어나기
                if (checkbuhoCurrent == checkbuhoPrev) {
                    stack.push(preValue);
                    stack.push(currentValue);
                    break;
                }

                // 이전 값이 양수일때만 제거 가능
                if (checkbuhoPrev == false) {
                    stack.push(preValue);
                    stack.push(currentValue);
                    break;
                }

                // 부호가 다른 경우 소행성을 제거
                if (Math.abs(currentValue) - Math.abs(preValue) == 0) {
                    // 둘다 없앰
                } else if (Math.abs(currentValue) - Math.abs(preValue) > 0) {
                    //하나만 없앰
                    stack.push(currentValue);
                } else {
                    //하나만 없앰
                    stack.push(preValue);
                }
            }// while end


        }// for end

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }


    public static int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean checkbuhoPrev = false;
        boolean checkbuhoCurrent = false;

        for (int i = 0; i < asteroids.length; i++) {
            stack.push(asteroids[i]);

            while (!stack.isEmpty()) {
                int currentValue = stack.pop();

                if (stack.size() <= 0) {
                    stack.push(currentValue);
                    break;
                }
                int preValue = stack.pop();

                // 부호 check
                checkbuhoPrev = preValue >= 0;
                checkbuhoCurrent = currentValue >= 0;


                // 부호가 같으면 스택에 소행성 추가, while 벗어나기
                if (checkbuhoCurrent == checkbuhoPrev) {
                    stack.push(preValue);
                    stack.push(currentValue);
                    break;
                }

                // 부호가 다른 경우 소행성을 제거
                if (Math.abs(currentValue) - Math.abs(preValue) == 0) {
                    // 둘다 없앰
                } else if (Math.abs(currentValue) - Math.abs(preValue) > 0) {
                    //하나만 없앰
                    stack.push(currentValue);
                } else {
                    //하나만 없앰
                    stack.push(preValue);
                }
            }// while end


        }// for end

        // 결과를 배열로 변환
        int[] result = stack.stream().mapToInt(Integer::intValue).toArray();

        // 배열의 순서를 역순으로 정렬
        for (int i = 0, j = result.length - 1; i < j; i++, j--) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }
}