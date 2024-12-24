package collection.set;

import collection.set.member.Member;

// class 를 넣어서 전달해보자
public class MyHashSetV2Main2 {

    public static void main(String[] args) {
        Member hi = new Member("hi");
        Member jpa = new Member("JPA");
        Member java = new Member("java");
        Member spring = new Member("spring");

        System.out.println("hi.hashCode() = " + hi.hashCode());
        System.out.println("jpa.hashCode() = " + jpa.hashCode());
        System.out.println("java.hashCode() = " + java.hashCode());
        System.out.println("spring.hashCode() = " + spring.hashCode());

        MyHashSetV2 set = new MyHashSetV2(10);
        set.add(hi);
        set.add(jpa);
        set.add(java);
        set.add(spring);
        System.out.println(set);

        //검색
        Member searchValue = new Member("JPA");
        boolean result = set.contains(searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + result);
    }
}