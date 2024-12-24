public class MyLinkedList<E> {
    private Node<E> first;
    private int size = 0;

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    public void add(int i, E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> x = getNode(i - 1);
            newNode.next = x.next;
            x.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public E get(int index) {
        Node<E> c = getNode(index);
        return c.item;
    }


    public Node<E> getNode(int idx) {
        Node<E> c = first;
        for (int i = 0; i < idx; i++) {
            c = c.next;
        }
        return c;
    }

    public int size() {
        return size;
    }

    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public E remove(int i) {
        Node<E> c = getNode(i);
        E removeItem = c.item;
        if (i == 0) {
            first = c.next;
        } else {
            Node<E> x = getNode(i - 1);
            x.next = c.next;
        }
        c.item = null;
        c.next = null;
        size--;
        return removeItem;
    }


    @Override
    public String toString() {
        return "MyLinkedList{" +
            "first=" + first +
            ", size=" + size +
            '}';
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.item);
                if (temp.next != null) {
                    sb.append("->");
                }
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }


}