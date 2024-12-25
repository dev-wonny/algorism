package collection.compare;

import collection.compare.comparator.IdComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class SortMain {
    public static void main(String[] args) {

        // 배열의 기본정렬
        Integer[] array = {3, 2, 1};
        System.out.println(Arrays.toString(array));

        System.out.println("기본 정렬 후");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // Comparator 적용
        System.out.println();
        System.out.println("Comparator 비교");
        Integer[] array2 = {4, 5, 8, 3, 6, 2, 1, 9, 7};
        System.out.println("Comparator 적용 전:" + Arrays.toString(array2));

        Arrays.sort(array2, new AscComparator());
        System.out.println("AscComparator:" + Arrays.toString(array2));

        Arrays.sort(array2, new DescComparator());
        System.out.println("DescComparator:" + Arrays.toString(array2));

        System.out.println();
        // 커스텀 객체 비교자 적용
        MyUser myUser1 = new MyUser("F", 10);
        MyUser myUser2 = new MyUser("A", 30);
        MyUser myUser3 = new MyUser("C", 90);
        MyUser myUser4 = new MyUser("B", 40);
        MyUser myUser5 = new MyUser("D", 10);

        // 배열에 담음
        MyUser[] userArray = {myUser1, myUser2, myUser3, myUser4, myUser5};

        // List에 담음
        List<MyUser> userList = new LinkedList<>(List.of(userArray));

        // TreeSet 담음
        TreeSet<MyUser> userTreeSet = new TreeSet<>();
        Collections.addAll(userTreeSet, userArray);

        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
        treeSet2.addAll(List.of(userArray));


        System.out.println("MyUser 배열에 담음>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("MyUser 비교 시작");
        System.out.println("MyUser array 데이터" + Arrays.toString(userArray));

        // 배열에서 제공하는 비교
        // MyUser 는 나이를 기준으로 compare 구현해놓음
        System.out.println("MyUser Comparable 배열에서 제공하는 기본 정렬");
        Arrays.sort(userArray);
        System.out.println("나이 기준: " + Arrays.toString(userArray));// 나이 기준
        System.out.println();
        //아이디로 비교해볼까?
        System.out.println("MyUser IdComparator 정렬");
        Arrays.sort(userArray, new IdComparator());
        System.out.println(Arrays.toString(userArray));
        System.out.println();

        System.out.println("MyUser IdComparator().reversed() 정렬");
        Arrays.sort(userArray, new IdComparator().reversed());
        System.out.println(Arrays.toString(userArray));


        System.out.println();
        System.out.println("MyUser List 담음>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("MyUser List 데이터" + userList);
        System.out.println("MyUser List Comparable 기본 정렬");
        userList.sort(null);
        System.out.println("MyUser List IdComparator 정렬");
        userList.sort(new IdComparator());


        System.out.println();
        System.out.println("MyUser TreeSet 담음>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("MyUser TreeSet 데이터, 데이터 넣을때부터 정렬해줌" + userTreeSet);
        System.out.println("MyUser TreeSet -> IdComparator 정렬");
        System.out.println(treeSet2);


    }// main end


    // 오름차순 1 -> 2 -> 3
    // 내가 작으면 -1
    // 같으면 0
    // 나보다 상대방이 크면 1
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("오름차순 비교 o2=" + o2 + " o1=" + o1);
            // return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
            return o1.compareTo(o2);
        }
    }// AscComparator end


    // 내림차순 4 -> 3 -> 2 -> 1
    static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("내림차순 비교 o2=" + o2 + " o1=" + o1);
            // return ((o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1)) * -1;
            return o2.compareTo(o1);
        }
    }
}