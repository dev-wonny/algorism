package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {// 객체는 Iterable 가능합니다
    private int[] intArr;

    public MyArray(int[] intArr) {
        this.intArr = intArr;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(intArr);// 커스텀 iterator로 설정
    }
}
