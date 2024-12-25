package collection.iterable;

import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {// Iterator == 비교자를 만들자

    // 접근할 배열이 필요하다
    private int[] targetArr;
    private int currentIndex = -1;

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() {// 있어?
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() {//줘
        return targetArr[++currentIndex];
    }
}