package collection.list.test;

import collection.list.MyArrayList;
import collection.list.MyLinkedList;

/**
 * 맨 앞에 데이터를 추가하는 경우가 많은 문제
 * MyArrayList << MyLinkedList 가 시간복잡도가 낫다
 */
public class BatchProcessorMain {

    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        BatchProcessor processor1 = new BatchProcessor(list1);
        BatchProcessor processor2 = new BatchProcessor(list2);
        processor1.logic(50_000);
        processor2.logic(50_000);
        //크기: 50000, 계산 시간: 1630ms
        //크기: 50000, 계산 시간: 2ms
    }
}