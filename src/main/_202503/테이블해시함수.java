package main._202503;

import java.util.Arrays;

public class 테이블해시함수 {

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        테이블해시함수 o = new 테이블해시함수();
        System.out.println(o.solution(data, 2, 2, 3));//4
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // data[col-1]번 오름차순 정렬
        // 같은경우 data[0]으로 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            int index = col - 1;
            if (a[index] != b[index]) {
                return Integer.compare(a[index], b[index]);
            }
            return Integer.compare(b[0], a[0]);
        });


        // 두개 뽑음
        // data[row_begin -1] 번째
        // data[row_end-1] 번째
        //나머지합 구하기
        int xor = 0;
        for (int i = row_begin; i < row_end; i++) {
            xor ^= getSum(data[i - 1], i);
        }
        // bitwise XOR -> ^
        return xor;
    }

    private int getSum(int[] target, int mod) {
        int sum = 0;
        for (int t : target) {
            sum += t % mod;
        }
        return sum;
    }
}
