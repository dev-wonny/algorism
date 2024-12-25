package collection.iterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaIterableMain {
    public static void main(String[] args) {

        // 커스텀 MyArray 객체
        MyArray myArray = new MyArray(new int[] {1, 2, 3, 4});

        // 커스텀 MyArray 객체에서 비교자 꺼내기
        Iterator<Integer> iterator = myArray.iterator();

        // 비교자 기능 사용해서 순회하기
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("향상 for문");

        for (int ele : myArray) {
            System.out.println(ele);
        }


        // 기본형도 비교자로 순화가 가능하다
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        printAll(list.iterator());
        printAll(set.iterator());

        foreach(list);
        foreach(set);

        // 기본적으로 순회 기능 제공
    }// main end

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator = " + iterator.getClass());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void foreach(Iterable<Integer> iterable) {
        System.out.println("iterable = " + iterable.getClass());
        for (Integer i : iterable) {
            System.out.println(i);
        }
    }
}
