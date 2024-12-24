package collection.link;

public class NodeMain {
    public static void main(String[] args) {
        //노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        //A -> B -> C

        System.out.println(first);
        System.out.println(first.toString());

        first.add("D");
        first.add("E");
        first.add("F");

        first.printAll();
        System.out.println(first.getLastNode());
        System.out.println(first.getNode(1));
    }
}