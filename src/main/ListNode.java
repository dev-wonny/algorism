package main;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode is() {
        return this;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }

    public static ListNode makeListNodeExample(int[] arr) {
        if (arr.length == 0) {
            return null;
        } else if (arr.length == 1) {
            return new ListNode(arr[0]);
        } else {
            ListNode before = new ListNode(arr[0]);
            ListNode start = before;

            int i = 1;
            while (i < arr.length) {
                ListNode next = new ListNode(arr[i]);
                before.setNext(next);
                before = next;
                i += 1;
            }// while end

            return start;
        }// else end
    }
}