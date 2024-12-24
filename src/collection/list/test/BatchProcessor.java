package collection.list.test;

import collection.list.MyList;

/**
 * client code: BatchProcessor
 * 를 고치지 않고, list 전략을 runtime에 지정
 * Strategy pattern
 * OCP
 */
public class BatchProcessor {
    MyList<Integer> list;// 바깥에서 받는다, 추상으로 선언

    public BatchProcessor(MyList<Integer> list) {// 의존관계 주입
        this.list = list;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);// 앞에 추가
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}