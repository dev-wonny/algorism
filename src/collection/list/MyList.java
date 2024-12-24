package collection.list;

/**
 * 순서 유지
 * 중복 허용
 * 인덱스 사용
 * 크기 동적 변경
 * <p>
 * ex) 장바구니 목록
 * <p>
 * ArrayList(순서 O, 고정), LinkedList(순서 O, 동적)
 */
public interface MyList<E> {

    int size();

    void add(E e);

    // 인덱스 특징
    void add(int index, E e);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E o);
}