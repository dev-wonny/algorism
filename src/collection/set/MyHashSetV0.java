package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

    // int: 4byte, 메모리낭비
    private int[] elementData = new int[10];
    private int size = 0;

    /**
     * 추가할 때마다 값이 유일한지 O(N) 탐색해야 함
     * 따라서 Hash를 적용해서 탐색을 개선한다
     * Hash는 index를 사용한다
     * <p>
     * hashTable LinkedList안에 LinkedList 생성
     * [[], [], [], [], ...]
     * <p>
     * hash 저장: O(1), 최악: O(N)
     * hash 조회: O(1), 최악: O(N)
     */
    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }

        elementData[size] = value;
        size++;
        return true;
    }

    public boolean contains(int value) {
        for (int data : elementData) {
            if (value == data) {
                return true;
            }
        }// for end
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
            "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
            ", size=" + size +
            '}';
    }
}
