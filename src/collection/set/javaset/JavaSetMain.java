package collection.set.javaset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetMain {
    public static void main(String[] args) {
        run(new HashSet<>());// 입력한 순서 보장 X
        run(new LinkedHashSet<>());// 입력한 순서 보장 O
        run(new TreeSet<>());// data 정렬
    }

    private static void run(Set<String> set) {
        System.out.println("set = " + set.getClass());
        set.add("다");
        set.add("가");
        set.add("나");
        set.add("2");
        set.add("1");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
