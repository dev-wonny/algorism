package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 큐:  pollFirst, offerLast -> 왼쪽에서 빼냄
 * 스택: pollFirst, offerFirst -> 왼쪽만 씀
 */

public class DequeMain {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>ArrayDeque");
        Deque<Integer> deque = new ArrayDeque<>();

        // 앞 데이터 추가
        System.out.println("offerFirst 1-> 2 -> 2 -> 3");
        deque.offerFirst(1);
        System.out.println(deque);
        deque.offerFirst(2);
        System.out.println(deque);
        deque.offerFirst(2);
        System.out.println(deque);
        deque.offerFirst(3);
        System.out.println(deque);
        System.out.println();

        // 뒤 데이터 추가
        System.out.println("offerLast 10 -> 11 -> 12");
        deque.offerLast(10);
        System.out.println(deque);
        deque.offerLast(11);
        System.out.println(deque);
        deque.offerLast(12);
        System.out.println(deque);

        System.out.println();
        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        System.out.println("deque.peekLast() = " + deque.peekLast());
        System.out.println(deque);


        System.out.println();
        // 데이터 꺼내기
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println();
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println("pollLast = " + deque.pollLast());// 에러 안남
        System.out.println(deque);

        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>queue 처럼 사용");
        //데이터 추가
        System.out.println("offer 1 -> 2 -> 3 && offerLast 비슷");
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque);
        //다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peek() = " + deque.peek());

        //데이터 꺼내기
        System.out.println();
        System.out.println("pollFirst 비슷, poll = " + deque.poll());
        System.out.println("pollFirst 비슷, poll = " + deque.poll());
        System.out.println("pollFirst 비슷, poll = " + deque.poll());
        System.out.println("pollFirst 비슷, poll = " + deque.poll());
        System.out.println(deque);


        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>stack 처럼 사용");
        System.out.println("push 1-> 2-> 3 && offerFirst 비슷");
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);
        System.out.println();

        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peek() = " + deque.peek());
        System.out.println();

        // 데이터 꺼내기
        System.out.println("pollFirst 비슷, pop = " + deque.pop());
        System.out.println("pollFirst 비슷, pop = " + deque.pop());
        System.out.println("pollFirst 비슷, pop = " + deque.pop());
        System.out.println("pop은 에러 생김");
//        System.out.println("pollFirst 비슷, pop = " + deque.pop());
        System.out.println(deque);
    }
}
