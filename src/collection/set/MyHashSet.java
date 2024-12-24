package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

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
public class MyHashSet<E> implements MySet<E> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<E>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    // 기본 생성자
    public MyHashSet() {
        initBuckets();
    }

    public MyHashSet(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];// 생성
        // 이중 배열
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // size
    public int getSize() {
        return size;
    }

    // 추가
    public boolean add(E value) {
        int hashIndex = hashIndex(value);
        // 중복 체크후 저장
        LinkedList<E> bucket = buckets[hashIndex];//O(1)
        if (bucket.contains(value)) {// 과거에 O(N) -> 평균적으로 1,2개 들어있어서 O(1)
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    // hash Table
    private int hashIndex(E value) {
        //hashCode의 결과로 음수가 나올 수 있다. abs()를 사용해서 마이너스를 제거한다.
        return Math.abs(value.hashCode()) % capacity;
    }

    // 탐색
    public boolean contains(E value) {// 과거에 O(N) -> 평균적으로 1,2개 들어있어서 O(1)
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];//O(1)
        return bucket.contains(value);
    }

    // 삭제
    public boolean remove(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];

        // 중복 체크후 제거
        boolean removedResult = bucket.remove((E) value);
        if (removedResult) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
            "buckets=" + Arrays.toString(buckets) +
            ", size=" + size +
            '}';
    }
}
