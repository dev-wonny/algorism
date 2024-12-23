public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node x = this;
        sb.append("[");
        while (x != null) {
            sb.append(x.item);
            if (x.next != null) {
                sb.append("->");
            }
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void printAll() {
        System.out.print(item);
        Node x = next;
        while (x != null) {
            System.out.print(x.item);
            x = x.next;
        }
        System.out.println();
    }

    public void add(Object item) {
        Node lastNode = getLastNode();
        lastNode.next = new Node(item);
    }

    public Node getLastNode() {
        Node c = this;
        Node x = next;
        while (x != null) {
            c = x;
            x = x.next;
        }
        return c;
    }

    public Node getNode(int index) {
        Node x = this;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
}
