package main._202502;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class 수식최대화 {
    public static void main(String[] args) {
        수식최대화 수식최대화 = new 수식최대화();
        System.out.println("expect: 60420, result: " + 수식최대화.solution("100-200*300-500+20"));
        System.out.println("expect: 300, result: " + 수식최대화.solution("50*6-3*2"));

    }

    private static char[][] kihoRandomDoubleArr = {
        {'-', '*', '+'},
        {'-', '+', '*'},
        {'*', '-', '+'},
        {'*', '+', '-'},
        {'+', '-', '*'},
        {'+', '*', '-'},
    };

    private long solution(String expression) {
        char[] charArray = expression.toCharArray();
        Queue<Integer> originNumberDeque = new ArrayDeque<>();
        Queue<Character> originKihoDeque = new ArrayDeque<>();


        StringBuilder sb = new StringBuilder();

        // 각 순서에 따른 연산 결과를 담을 PriorityQueue
        Queue<Long> resultMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (char ch : charArray) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                originNumberDeque.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();// 초기화

                originKihoDeque.add(ch);
            }
        }
        originNumberDeque.add(Integer.parseInt(sb.toString()));



        // 랜덤 순서: kihoOrderNumberingArr
        for (char[] kihoArr : kihoRandomDoubleArr) {
            // 복제 만들기
            Queue<Integer> copyNumberDeque = new ArrayDeque<>(originNumberDeque);
            Queue<Character> copyKihoDeque = new ArrayDeque<>(originKihoDeque);


            for (int i = 0; i < 3; i++) {
                char findKey = kihoArr[i];
                while (copyKihoDeque.contains(findKey)) {
                    DFS(copyNumberDeque, copyKihoDeque, findKey);
                }

            }// 1개의 조합, 3개의 문자 계산 끝남 for end
            Long last = Long.valueOf(copyNumberDeque.poll());//pollFirst
            resultMaxHeap.add(Math.abs(last));
        }// 랜덤 순서 for end


        // 가장 큰 값 리턴
        return resultMaxHeap.peek();
    }

    private void DFS(Queue<Integer> copyNumberDeque, Queue<Character> copyKihoDeque, char findKey) {
        Queue<Integer> tempNumberDeque = new ArrayDeque<>();
        Queue<Character> tempKihoDeque = new ArrayDeque<>();

        while (!copyKihoDeque.isEmpty()) {
            char kiho = copyKihoDeque.poll();//pollFirst
            int a = copyNumberDeque.poll();//pollFirst

            // 같은 경우 계산을 해서 숫자를 넣는다
            if (Objects.equals(kiho, findKey)) {
                int result = 0;
                int b = copyNumberDeque.poll();//pollFirst
                switch (findKey) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                }// switch end

                ((ArrayDeque<Integer>) copyNumberDeque).offerFirst(result);//offerFirst


            }
            // 다르면 temp에 넣어두기
            else {
                tempKihoDeque.add(kiho);// addLast
                tempNumberDeque.add(a);//addLast
            }
        }// while end, -가 두번 옴

        // temp에서 copy로 값, 부호 되돌리기
        while (!tempNumberDeque.isEmpty()) {
            ((ArrayDeque<Integer>) copyNumberDeque)
                .addFirst(((ArrayDeque<Integer>)
                    tempNumberDeque).pollLast());
        }// while end

        while (!tempKihoDeque.isEmpty()) {
            ((ArrayDeque<Character>) copyKihoDeque)
                .addFirst(((ArrayDeque<Character>)
                    tempKihoDeque).pollLast());
        }// while end
    }
}
