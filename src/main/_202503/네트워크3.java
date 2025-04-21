package main._202503;

import main._202411._28.네트워크2;

public class 네트워크3 {
    public static void main(String[] args) {
        // numbers 2이상 20이하
        네트워크2.이중배열생성 computers = new 네트워크2.이중배열생성();


        네트워크3 o = new 네트워크3();
        // 풀이
        int result = o.solution(3, computers.make1());
        System.out.println("예상 결과(2), 실제 값:" + result);

        int result2 = o.solution(3, computers.make2());
        System.out.println("예상 결과(1), 실제 값:" + result2);

    }

    private int solution(int n, int[][] computers) {
        int count = 0;


        for (int x = 0; x < computers.length; x++) {
            int[] computer = computers[x];

            for (int y = 0; y < computer.length; y++) {
                if (computer[y] == 1 && x != y) {
                    DFS(computers, x, y);
                }
            }
        }


        return count;
    }

    private void DFS(int[][] computers, int x, int y) {
        for (int i = 0; i < computers.length; i++) {
            int[] computer = computers[x];

            for (int j = 0; j < computer.length; j++) {
                if (computer[y] == 1 && x != y) {
                    computer[y] = 3;
                    DFS(computers, y, x);
                }
            }
        }


    }
}
