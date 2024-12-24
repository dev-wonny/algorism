package collection.set;

/**
 * 유일성(중복X)
 * 순서 미보장
 * 인덱스 X
 * 빠른 검색
 * <p>
 * ex) 회원 ID, 집합
 * <p>
 * HashSet(순서 X), LinkedHashSet(순서 O)
 * TreeSet(정렬 O)
 * <p>
 * Tree:
 * 부모 Node, 자식 Node
 */
public interface MySet<E> {
    // 인덱스가 없어서 기능이 단순
    boolean add(E element);

    boolean remove(E value);

    boolean contains(E value);
}
