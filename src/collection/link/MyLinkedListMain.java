package collection.link;

public class MyLinkedListMain {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

        System.out.println("==기능 사용==");
        System.out.println("list.size(): " + list.size());
        System.out.println("list.get(1): " + list.get(1));
        System.out.println("list.indexOf('c'): " + list.indexOf("c"));
        System.out.println("list.set(2, 'z'), oldValue: " + list.set(2, "z"));
        System.out.println(list);

        System.out.println("==범위 초과==");
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);

        //범위 초과, 사이즈가 늘어나지 않으면 예외 발생
        list.add("범위초과");
        System.out.println(list);


        System.out.println("첫 번째 항목 삭제");
        list.remove(0); //remove First O(1)
        System.out.println(list);

        //중간에 항목에 추가, 삭제
        System.out.println("중간 항목에 추가");
        list.add(1, "중간추가"); //O(1)
        list.add(4, "삭제대상"); //O(1)
        System.out.println(list);

        System.out.println("중간 항목 삭제");
        list.remove(4);//remove Last O(n)
        System.out.println(list);


        MyLinkedList<String> stringList = new MyLinkedList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        String string = stringList.get(0);
        System.out.println("string = " + string);


        MyLinkedList<Integer> intList = new MyLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);

    }
}
