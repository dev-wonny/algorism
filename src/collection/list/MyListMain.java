package collection.list;

import java.util.Arrays;
import java.util.List;

public class MyListMain {
    public static void main(String[] args) {
        //return new ArrayList<>(a);
        List<Integer> list = Arrays.asList(1, 2, 3);

        // java 9 이상
        //return ImmutableCollections.listFromTrustedArray(e1, e2, e3);
        List<Integer> list2 = List.of(1, 2, 3);


        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.add(1);
        integerMyLinkedList.add(2);
        integerMyLinkedList.add(3);
        integerMyLinkedList.add(4);
        System.out.println(integerMyLinkedList);

    }
}
