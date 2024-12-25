package collection.set;

import java.util.HashSet;

public class MyHashSetMain {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>(10);
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);

        //검색
        String searchValue = "A";
        boolean result = set.contains(searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + result);

        HashSet<String> hashSet = new HashSet<>();

    }
}
