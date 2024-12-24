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
public class MyHashSetV1 {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    // 기본 생성자
    public MyHashSetV1() {
        initBuckets();
    }

    public MyHashSetV1(int capacity) {
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
    public boolean add(int value) {
        int hashIndex = hashIndex(value);
        // 중복 체크후 저장
        LinkedList<Integer> bucket = buckets[hashIndex];//O(1)
        if (bucket.contains(value)) {// 과거에 O(N) -> 평균적으로 1,2개 들어있어서 O(1)
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    // hash Table
    private int hashIndex(int value) {
        return value % 10;
    }

    // 탐색
    public boolean contains(int value) {// 과거에 O(N) -> 평균적으로 1,2개 들어있어서 O(1)
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];//O(1)
        return bucket.contains(value);
    }

    // 삭제
    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];

        // 중복 체크후 제거
        boolean removedResult = bucket.remove((Object) value);
        if (removedResult) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
            "buckets=" + Arrays.toString(buckets) +
            ", size=" + size +
            '}';
    }
}
