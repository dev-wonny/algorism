package collection.list;

import java.util.Arrays;

/**
 * ArrayList
 * 순서 있음
 * 중복 허용
 * 크기 동적
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] objectData;// 동적으로 사이즈 변함
    private int size = 0;

    public MyArrayList() {
        this.objectData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.objectData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if (size == objectData.length) {
            grow();
        }
        // 증가시키고 다시 원래대로 추가
        objectData[size] = e;
        size++;
    }

    // 특정 위치 추가
    @Override
    public void add(int index, E e) {
        if (size == objectData.length) {
            grow();
        }
        // 인덱스 기준으로 오른쪽 데이터가 -> 오른쪽으로 이동
        shiftRightFrom(index);
        objectData[index] = e;
        size++;
    }

    // 인덱스 기준으로 오른쪽 데이터가 -> 오른쪽으로 이동
    private void shiftRightFrom(int index) {
        // 배열의 마지막에서부터 인덱스까지 오른쪽으로 밀기(마지막 배열 값은 사라진다)
        for (int i = size; i > index; i--) {
            objectData[i] = objectData[i - 1];
        }
    }


    // 인덱스 기준으로 오른쪽 데이터가 ->  왼쪽으로 이동
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            objectData[i] = objectData[i + 1];
        }
    }

    private void grow() {
        int oldCapacity = objectData.length;
        int newCapacity = oldCapacity * 2;
        objectData = Arrays.copyOf(objectData, newCapacity);// 대체 해버림
    }

    @Override
    public E get(int index) {
        return (E) objectData[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        objectData[index] = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        E oldVaule = get(index);

        // 인덱스 기준으로 오른쪽 데이터가 ->  왼쪽으로 이동
        shiftLeftFrom(index);
        size--;
        objectData[size] = null;// 마지막 지우기
        return oldVaule;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(objectData[i])) {
                return i;
            }
        }// for end
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(objectData, size)) + " size=" + size + ", capacity=" + objectData.length;
    }
}